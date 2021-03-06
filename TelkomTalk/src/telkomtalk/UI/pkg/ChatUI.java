/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package telkomtalk.UI.pkg;

import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author AhmadFauzi__
 */
public class ChatUI extends javax.swing.JFrame {
    Point point = new Point();
    /**
     * Creates new form ChatUI
     */
    public ChatUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        avatar = new javax.swing.JLabel();
        closeButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        otherMessageScroll = new javax.swing.JScrollPane();
        otherMessage = new javax.swing.JTextArea();
        myMessageScroll = new javax.swing.JScrollPane();
        myMessage = new javax.swing.JTextArea();
        background = new javax.swing.JLabel();

        setBackground(new java.awt.Color(249, 191, 59));
        setMinimumSize(new java.awt.Dimension(360, 550));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(360, 550));
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

        avatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avatar.setText("Avatar");
        avatar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(avatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, 70));

        closeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telkomtalk/UI/images/close_default.png"))); // NOI18N
        closeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButtonMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeButtonMousePressed(evt);
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
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minimizeButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseReleased(evt);
            }
        });
        getContentPane().add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 3, 20, 20));

        username.setText("username");
        username.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 140, 20));

        status.setText("status");
        status.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 140, -1));

        otherMessageScroll.setBorder(null);

        otherMessage.setColumns(20);
        otherMessage.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        otherMessage.setRows(5);
        otherMessage.setBorder(null);
        otherMessage.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        otherMessageScroll.setViewportView(otherMessage);

        getContentPane().add(otherMessageScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 119, 330, 270));

        myMessageScroll.setBorder(null);

        myMessage.setColumns(20);
        myMessage.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        myMessage.setRows(5);
        myMessage.setBorder(null);
        myMessageScroll.setViewportView(myMessage);

        getContentPane().add(myMessageScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 434, 330, 100));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telkomtalk/UI/images/ChatUI.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 550));

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

    private void closeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseEntered
        ImageIcon closeImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/close_hover.png"));
        closeButton.setIcon(closeImage);
    }//GEN-LAST:event_closeButtonMouseEntered

    private void closeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseExited
        ImageIcon closeImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/close_default.png"));
        closeButton.setIcon(closeImage);
    }//GEN-LAST:event_closeButtonMouseExited

    private void closeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseReleased
        ImageIcon closeImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/close_default.png"));
        closeButton.setIcon(closeImage);

        System.exit(0);
    }//GEN-LAST:event_closeButtonMouseReleased

    private void minimizeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMousePressed
        ImageIcon minimizeImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/minimize_pressed.png"));
        minimizeButton.setIcon(minimizeImage);
    }//GEN-LAST:event_minimizeButtonMousePressed

    private void minimizeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseEntered
        ImageIcon minimizeImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/minimize_hover.png"));
        minimizeButton.setIcon(minimizeImage);
    }//GEN-LAST:event_minimizeButtonMouseEntered

    private void minimizeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseExited
        ImageIcon minimizeImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/minimize_default.png"));
        minimizeButton.setIcon(minimizeImage);
    }//GEN-LAST:event_minimizeButtonMouseExited

    private void minimizeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseReleased
        ImageIcon minimizeImage = new ImageIcon(getClass().getResource("/telkomtalk/UI/images/minimize_default.png"));
        minimizeButton.setIcon(minimizeImage);

        setExtendedState(getExtendedState()| LoginUI.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseReleased

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar;
    private javax.swing.JLabel background;
    private javax.swing.JLabel closeButton;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JTextArea myMessage;
    private javax.swing.JScrollPane myMessageScroll;
    private javax.swing.JTextArea otherMessage;
    private javax.swing.JScrollPane otherMessageScroll;
    private javax.swing.JLabel status;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
