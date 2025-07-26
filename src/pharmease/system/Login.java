package pharmease.system;

import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    DBConnection con;
    
    public void setUsernameText(String username) {
        jTextField1.setText(username);
    }
    public String getUsernameText() {
        return jTextField1.getText();
    }
    public void setPasswordText(String password) {
        jPasswordField1.setText(password);
    }
    public String getPasswordText() {
        return new String(jPasswordField1.getPassword());
    }
    
    public Login() {
        initComponents();
        con= new DBConnection();
        if (con==null) {
            JOptionPane.showMessageDialog(this,"DB Connection not available", "Error", JOptionPane.ERROR_MESSAGE);             
        }    
        }

    public boolean validateLogin() {
        String username = getUsernameText().trim();
        String password = getPasswordText();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username/Password should not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        boolean loginSuccessful = authenticateUser(username, password);

        if (loginSuccessful) {
            Search_AddToCart.setLoggedInUsername(username);
            new Search_AddToCart().setVisible(true);
            dispose();
        } else {
            if (!usernameExists(username)) {
                JOptionPane.showMessageDialog(this, "Invalid username", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return loginSuccessful;
    }

    private boolean authenticateUser(String username, String password) {
        try (Connection con = DBConnection.getCon();
             PreparedStatement st = con.prepareStatement("SELECT * FROM USER WHERE username=? AND password=?")) {

            st.setString(1, username);
            st.setString(2, password);

            try (ResultSet rs = st.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error connecting to the database or executing query", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean usernameExists(String username) {
        try (Connection con = DBConnection.getCon();
             PreparedStatement st = con.prepareStatement("SELECT * FROM USER WHERE username=?")) {

            st.setString(1, username);

            try (ResultSet rs = st.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(185, 202, 209));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 240, 30));

        jPasswordField1.setBackground(new java.awt.Color(185, 202, 209));
        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 240, 30));

        jButton1.setBackground(new java.awt.Color(185, 202, 209));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\login_icon.png")); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, 160, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Don't have an account?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 580, -1, -1));

        jButton3.setBackground(new java.awt.Color(167, 208, 217));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\signup_icon.png")); // NOI18N
        jButton3.setText("Sign up here");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 580, 170, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\Login.png")); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (validateLogin()) {
            // Login successful logic (already handled in validateLogin)
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new SignUp().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
