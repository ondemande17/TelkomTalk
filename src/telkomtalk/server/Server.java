/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package telkomtalk.server;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author Hawari Rahman
 */
class ServerThread extends Thread {
    
    public Server server = null;
    public Socket socket = null;
    public int ID = -1;
    public String username = "";
    public ObjectInputStream streamIn = null;
    public ObjectOutputStream streamOut = null;
    
    public ServerThread(Server _server, Socket _socket) {
        super();
        server = _server;
        socket = _socket;
        ID = socket.getPort();
    }
    
    public void send(Message msg) {
        try {
            streamOut.writeObject(msg);
            streamOut.flush();
            System.out.println("Outgoing: " + msg.toString());
        }
        catch(IOException ex) {
            System.out.println("Failed to send message: " + ex.getMessage());
        }
    }
    
    public int getID() {
        return ID;
    }
    
    @SuppressWarnings("deprecation")
    public void run() {
        System.out.println("ServerThread " + ID + " is running now...");
        while(true) {
            try {
                Message msg = (Message) streamIn.readObject();
                System.out.println("Incoming: " + msg.toString());
                server.handle(ID, msg);
            }
            catch(Exception ex) {
                System.out.println(ID + " Error Reading: " + ex.getMessage());
                server.remove(ID);
                stop();
            }
        }
    }
    
    public void open() throws IOException {
        streamOut = new ObjectOutputStream(socket.getOutputStream());
        streamOut.flush();
        streamIn = new ObjectInputStream(socket.getInputStream());
    }
    
    public void close() throws IOException {
        if(socket != null)
            socket.close();
        if(streamIn != null)
            streamIn.close();
        if(streamOut != null)
            streamOut.close();
    }
}

public class Server implements Runnable {
    public ServerThread clients[];
    public ServerSocket server = null;
    public Thread thread;
    public int clientCount = 0, port = 5000;
    public Database db;
    
    public Server() {
        clients = new ServerThread[50];
        db = new Database();
        
        try {
            server = new ServerSocket(port);
            port = server.getLocalPort();
            System.out.println("Server started... IP: " + InetAddress.getLocalHost() + ", Port: " + server.getLocalPort());
            start();
        }
        catch(IOException ex) {
            System.out.println("Failed to start server: " + ex.getMessage());
        }
    }
    
    public Server(int Port) {
        clients = new ServerThread[50];
        port = Port;
        db = new Database();
        
        try {
            server = new ServerSocket(port);
            port = server.getLocalPort();
            System.out.println("Server started... IP: " + InetAddress.getLocalHost() + ", Port: " + server.getLocalPort());
            start();
        }
        catch(IOException ex) {
            System.out.println("Failed to start server: " + ex.getMessage());
        }
    }
    
    public void run() {
        while(thread != null) {
            try {
                System.out.println("Waiting for a client...");
                addThread(server.accept());
            }
            catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void start() {
        if(thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }
    
    @SuppressWarnings("deprecation")
    public void stop() {
        if(thread != null) {
            thread.stop();
            thread = null;
        }
    }
    
    private int findClient(int ID) {
        for(int i=0; i < clientCount; i++) {
            if(clients[i].getID() == ID)
                return i;
        }
        return -1;
    }
    
    public synchronized void handle(int ID, Message msg) {
        if(msg.type.equals("login")) {
            if(findUserThread(msg.sender) == null) {
                if(db.checkLogin(msg.sender, msg.content)) {
                    clients[findClient(ID)].username = msg.sender;
                    System.out.println(clients[findClient(ID)].username + " has logged in...");
                    clients[findClient(ID)].send(new Message("login", "SERVER", "TRUE", msg.sender));
                }
                else {
                    clients[findClient(ID)].send(new Message("login", "SERVER", "FALSE", msg.sender));
                }
            }
            else {
                clients[findClient(ID)].send(new Message("login", "SERVER", "FALSE", msg.sender));
            }
        }
        else if(msg.type.equals("logout")) {
            remove(ID);
        }
        else if(msg.type.equals("register")) {
            if(db.checkUsername(msg.sender)) {
                String username = msg.sender;
                String content[] = msg.content.split("@");
                String name = content[0];
                String password = content[1];
                
                if(db.register(username, name, password)) {
                    clients[findClient(ID)].send(new Message("register", "SERVER", "TRUE", msg.sender));
                }
                else {
                    clients[findClient(ID)].send(new Message("register", "SERVER", "Failed to register", ""));
                }
            }
            else {
                clients[findClient(ID)].send(new Message("register", "SERVER", "Username already exists", ""));
            }
        }
        else if(msg.type.equals("update")) {
            String content[] = msg.content.split("@");
            String name = content[0];
            String password = content[1];
            
            if(db.update(msg.sender, name, password)) {
                clients[findClient(ID)].send(new Message("update", "SERVER", "TRUE", msg.sender));
            }
            else {
                clients[findClient(ID)].send(new Message("update", "SERVER", "FALSE", msg.sender));
            }
        }
        else if(msg.type.equals("message")) {
            if(findUserThread(msg.recipient) != null) {
                findUserThread(msg.recipient).send(msg);
                db.storeMessage(msg);
            }
            else {
                db.queueMessage(msg);
            }
        }
        else if(msg.type.equals("unread")) {
            sendUnreadMessage(msg.sender);
        }
        else if(msg.type.equals("contacts")) {
            sendUserList(msg.sender);
        }
        else if(msg.type.equals("addcontact")) {
            short result = db.addContact(msg);
            if(result == 0) {
                clients[findClient(ID)].send(new Message("addcontact", "SERVER", "TRUE", msg.sender));
            }
            else {
                clients[findClient(ID)].send(new Message("addcontact", "SERVER", "Error Code:" + result, msg.sender));
            }
        }
        else if(msg.type.equals("send_req")) {
            findUserThread(msg.recipient).send(new Message("send_req", msg.sender, msg.content, msg.recipient));
        }
        else if(msg.type.equals("send_acc")) {
            if(!msg.content.equals("NO")) {
                String IP = findUserThread(msg.sender).socket.getInetAddress().getHostAddress();
                findUserThread(msg.recipient).send(new Message("send_acc", IP, msg.content, msg.recipient));
            }
            else {
                findUserThread(msg.recipient).send(new Message("send_acc", msg.sender, msg.content, msg.recipient));
            }
        }
    }
    
    public void announce(String type, String sender, String content) {
        Message msg = new Message(type, sender, content, "All");
        for(int i = 0; i < clientCount; i++) {
            clients[i].send(msg);
        }
    }
    
    public void sendUserList(String username) {
        ArrayList<String> contacts = db.getContacts(username);
        for(int i = 0; i < contacts.size(); i++) {
            String content = contacts.get(i) + "@" + db.getName(contacts.get(i));
            findUserThread(username).send(new Message("contacts", "SERVER", content, username));
        }
    }
    
    public void sendUnreadMessage(String username) {
        ArrayList<Message> unread = db.getUnreadMessage(username);
        for(int i = 0; i < unread.size(); i++) {
            findUserThread(username).send(unread.get(i));
        }
    }
    
    public ServerThread findUserThread(String usr) {
        for(int i = 0; i < clientCount; i++) {
            if(clients[i].username.equals(usr)) {
                return clients[i];
            }
        }
        return null;
    }
    
    @SuppressWarnings("deprecation")
    public synchronized void remove(int ID) {
        int pos = findClient(ID);
        if(pos >= 0) {
            ServerThread toTerminate = clients[pos];
            System.out.println("Removing client thread " + ID + " at " + pos);
            if(pos < clientCount-1) {
                for(int i = pos+1; i < clientCount; i++) {
                    clients[i+1] = clients[i];
                }
            }
            clientCount--;
            try {
                toTerminate.close();
            }
            catch(IOException ex) {
                System.out.println("Can't remove client: " + ex.getMessage());
            }
            toTerminate.stop();
        }
    }
    
    private void addThread(Socket socket) {
        if(clientCount < clients.length) {
            System.out.println("Client accepted: " + socket);
            clients[clientCount] = new ServerThread(this, socket);
            try {
                clients[clientCount].open();
                clients[clientCount].start();
                clientCount++;
            }
            catch(IOException ex) {
                System.out.println("Can't add client: " + ex.getMessage());
            }
        }
        else {
            System.out.println("Client refused... Maximum limit reached");
        }
    }
}
