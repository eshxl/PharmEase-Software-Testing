package pharmease.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SignUp extends javax.swing.JFrame {
    public SignUp() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Full Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 120, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Age");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 280, 120, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Email id");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 120, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Phone No");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 360, 120, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Gender");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 120, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Blood Group");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 440, 120, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Username");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 520, 120, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Password");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 520, 120, -1));

        jComboBox1.setBackground(new java.awt.Color(225, 222, 222));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 200, -1));

        jComboBox2.setBackground(new java.awt.Color(225, 222, 222));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 440, 200, -1));

        jTextField1.setBackground(new java.awt.Color(225, 222, 222));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 200, -1));

        jTextField2.setBackground(new java.awt.Color(225, 222, 222));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 280, 200, -1));

        jTextField3.setBackground(new java.awt.Color(225, 222, 222));
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 200, -1));

        jTextField4.setBackground(new java.awt.Color(225, 222, 222));
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 360, 200, -1));

        jTextField5.setBackground(new java.awt.Color(225, 222, 222));
        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, 200, -1));

        jTextField6.setBackground(new java.awt.Color(225, 222, 222));
        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 520, 200, -1));

        jButton1.setBackground(new java.awt.Color(225, 222, 222));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\register_icon.png")); // NOI18N
        jButton1.setText("REGISTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 580, -1, -1));

        jButton2.setBackground(new java.awt.Color(225, 222, 222));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\back.png")); // NOI18N
        jButton2.setText("Back to login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 780, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\Register.png")); // NOI18N
        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // to open the login window and close the signup window
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void setFullNameText(String fullName) {
        jTextField1.setText(fullName);
    }
    public void setAgeText(String age) {
        jTextField2.setText(age);
    }
    public void setEmailText(String email) {
        jTextField3.setText(email);
    }
    public void setPhoneNoText(String phoneNo) {
        jTextField4.setText(phoneNo);
    }
    public void setGenderText(String gender) {
        jComboBox1.setSelectedItem(gender);
    }
    public void setBloodGroupText(String bloodGroup) {
        jComboBox2.setSelectedItem(bloodGroup);
    }
    public void setUsernameText(String username) {
        jTextField5.setText(username);
    }
    public void setPasswordText(String password) {
        jTextField6.setText(password);
    }
    
    public boolean registerUser() {
        String fullName = jTextField1.getText().trim();
        String age = jTextField2.getText().trim();
        String email = jTextField3.getText().trim();
        String phoneNo = jTextField4.getText().trim();
        String gender = (String) jComboBox1.getSelectedItem();
        String bloodGroup = (String) jComboBox2.getSelectedItem();
        String username = jTextField5.getText().trim();
        String password = jTextField6.getText().trim();

        if (fullName.isEmpty() || age.isEmpty() || email.isEmpty() || phoneNo.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
/*/
        // Fullname validation
        if (!fullName.matches("^[a-zA-Z\\s.-]*$")) {
            JOptionPane.showMessageDialog(this, "Full name should contain only letters, spaces, hyphens and periods", "Error", JOptionPane.ERROR_MESSAGE);
            return false; 
        }
/*/
        // Email validation
        if (!email.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //Check for valid age
        try {
            int userAge = Integer.parseInt(age);
            if (userAge < 18 || userAge > 100) {
                JOptionPane.showMessageDialog(this, "Please enter a valid age (between 18 and 100)", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid age", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Check for valid phone no
        if (phoneNo.length() != 10 || !phoneNo.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid 10-digit phone number", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Username validation
        if (!username.matches("^[a-zA-Z0-9._]*$")) {
            JOptionPane.showMessageDialog(this, "Username should contain only letters, numbers, and underscores", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Check password strength
        if (password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*\\d.*")) {
            int response = JOptionPane.showConfirmDialog(this, "Your password is weak. Do you want to continue?", "Password Warning", JOptionPane.YES_NO_OPTION);
            if (response != JOptionPane.YES_OPTION) {
                return false; // User chose not to continue with a weak password
            }
        }

        try {
            String query = "INSERT INTO USER (fullname, age, emailid, phoneno, gender, bloodgroup, username, password) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (Connection con = DBConnection.getCon(); PreparedStatement st = con.prepareStatement(query)) {
                st.setString(1, fullName);
                st.setString(2, age);
                st.setString(3, email);
                st.setString(4, phoneNo);
                st.setString(5, gender);
                st.setString(6, bloodGroup);
                st.setString(7, username);
                st.setString(8, password);

                int rowsAffected = st.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Registration successful. You can now login with your credentials.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(this, "Registration failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(this, "Username already exists. Please choose another username.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error connecting to the database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            e.printStackTrace();
        }
        return false;
    }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean isRegistered = registerUser();
        if (isRegistered) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
