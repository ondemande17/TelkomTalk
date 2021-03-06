/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package telkomtalk.UI.pkg;

import java.awt.Point;
import javax.swing.ImageIcon;
import telkomtalk.client.Client;

/**
 *
 * @author AhmadFauzi__
 */
public class AddContactUI extends javax.swing.JFrame {
    Point point = new Point();
    Client client = null;
    MaintUI mainUI = null;
    /**
     * Creates new form AddContactUI
     */
    public AddContactUI() {
        initComponents();
    }
    
    public void setClient(Client _client) {
        this.client = _client;
    }
    
    public void setMainUI(MaintUI ui) {
        mainUI = ui;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        avatar = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        addContactButton = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(360, 182));
        setUndecorated(true);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telkomtalk/UI/images/close_default.png"))); // NOI18N
        closeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeButtonMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButtonMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                closeButtonMouseReleased(evt);
            }
        });
        getContentPane().add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 3, 20, 20));

        minimizeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telkomtalk/UI/images/minimize_default.png"))); // NOI18N
        minimizeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minimizeButtonMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseReleased(evt);
            }
        });
        getContentPane().add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 3, 20, 20));

        avatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telkomtalk/UI/images/avatar_default2.png"))); // NOI18N
        avatar.setMaximumSize(new java.awt.Dimension(55, 55));
        avatar.setMinimumSize(new java.awt.Dimension(55, 55));
        avatar.setPreferredSize(new java.awt.Dimension(55, 55));
        getContentPane().add(avatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 55, 55));

        username.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        username.setBorder(null);
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 61, 200, 25));

        addContactButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telkomtalk/UI/images/button_addcontact_default.png"))); // NOI18N
        addContactButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addContactButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addContactButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addContactButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addContactButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addContactButtonMouseReleased(evt);
            }
        });
        getContentPane().add(addContactButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 150, 35));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telkomtalk/UI/images/AddContactUI.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 182));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        point.x = evt.getX();
        point.y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point p = getLocation();
        setLocation(p.x+evt.getX()-point.x,p.y+evt.getY()-point.y);
    }//GEN-LAST:event_formMouseDragged

    private void closeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMousePressed
        ImageIcon closeImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/close_pressed.png"));
        closeButton.setIcon(closeImage);
    }//GEN-LAST:event_closeButtonMousePressed

    private void closeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseExited
        ImageIcon closeImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/close_default.png"));
        closeButton.setIcon(closeImage);
    }//GEN-LAST:event_closeButtonMouseExited

    private void closeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseEntered
        ImageIcon closeImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/close_hover.png"));
        closeButton.setIcon(closeImage);
    }//GEN-LAST:event_closeButtonMouseEntered

    private void closeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseReleased
        ImageIcon closeImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/close_default.png"));
        closeButton.setIcon(closeImage);

        hide();
    }//GEN-LAST:event_closeButtonMouseReleased

    private void minimizeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMousePressed
        ImageIcon minimizeImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/minimize_pressed.png"));
        minimizeButton.setIcon(minimizeImage);
    }//GEN-LAST:event_minimizeButtonMousePressed

    private void minimizeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseExited
        ImageIcon minimizeImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/minimize_default.png"));
        minimizeButton.setIcon(minimizeImage);
    }//GEN-LAST:event_minimizeButtonMouseExited

    private void minimizeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseEntered
        ImageIcon minimizeImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/minimize_hover.png"));
        minimizeButton.setIcon(minimizeImage);
    }//GEN-LAST:event_minimizeButtonMouseEntered

    private void minimizeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseReleased
        ImageIcon minimizeImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/minimize_default.png"));
        minimizeButton.setIcon(minimizeImage);

        setExtendedState(getExtendedState()| LoginUI.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseReleased

    private void addContactButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addContactButtonMouseEntered
        ImageIcon addContactImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/button_addcontact_hover.png"));
        addContactButton.setIcon(addContactImage);
    }//GEN-LAST:event_addContactButtonMouseEntered

    private void addContactButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addContactButtonMousePressed
        ImageIcon addContactImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/button_addcontact_pressed.png"));
        addContactButton.setIcon(addContactImage);
    }//GEN-LAST:event_addContactButtonMousePressed

    private void addContactButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addContactButtonMouseExited
        ImageIcon addContactImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/button_addcontact_default.png"));
        addContactButton.setIcon(addContactImage);
    }//GEN-LAST:event_addContactButtonMouseExited

    private void addContactButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addContactButtonMouseReleased
        ImageIcon addContactImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/button_addcontact_default.png"));
        addContactButton.setIcon(addContactImage);
        
        client.addContacts(username.getText());
        mainUI.getContacts();
    }//GEN-LAST:event_addContactButtonMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddContactUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddContactUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddContactUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddContactUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new AddContactUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addContactButton;
    private javax.swing.JLabel avatar;
    private javax.swing.JLabel background;
    private javax.swing.JLabel closeButton;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
