package pharmease.system;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Search_AddToCart extends javax.swing.JFrame {
    private static String loggedInUsername;
    public Search_AddToCart() {
        initComponents();
    }
    protected void searchAndUpdateTable(String searchQuery) {
        if (!searchQuery.matches("^[a-zA-Z0-9 ]*$")) {
            JOptionPane.showMessageDialog(null, "Invalid characters in search query.");
            return;
        }

        try {
            Connection con = DBConnection.getCon();
            String query = "SELECT * FROM medicines WHERE name LIKE ? OR description LIKE ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, "%" + searchQuery + "%");
                ps.setString(2, "%" + searchQuery + "%");

                ResultSet rs = ps.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching medicines: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Log the exception for debugging
        }
    }

    protected void addToCart() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a medicine to add to the cart.");
            return;
        }

        String medicineId = jTable1.getValueAt(selectedRow, 0).toString(); // Assuming medicine_id is in the first column
        String quantity = JOptionPane.showInputDialog("Enter quantity:");

        if (!validateQuantityInput(quantity)) {
            return;
        }

        try {
            Connection con = DBConnection.getCon();
            String query = "INSERT INTO Cart (username, medicine_id, quantity) VALUES (?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                String username = getLoggedInUsername();
                if (username == null || username.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please log in before adding items to the cart.");
                    return;
                }

                ps.setString(1, username);
                ps.setString(2, medicineId);
                ps.setString(3, quantity);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Medicine added to the cart successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add medicine to the cart.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding medicine to cart: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Log the exception for debugging
        }
    }

    protected boolean validateQuantityInput(String quantity) {
        if (quantity == null || quantity.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid quantity.");
            return false;
        }
        try {
            int quantityValue = Integer.parseInt(quantity);
            if (quantityValue < 0) {        //<=0
                JOptionPane.showMessageDialog(null, "Quantity should be a positive number.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number for quantity.");
            return false;
        }
        return true;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\search_icon.png")); // NOI18N
        jLabel2.setText("Medicine name/ description:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 290, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 280, -1));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Medicine_id", "Name", "Description", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 292, 688, 320));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\AddToCart.png")); // NOI18N
        jButton1.setText("Add to Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 630, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\Cart.png")); // NOI18N
        jButton2.setText("View Cart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 630, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\logout.png")); // NOI18N
        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\Search.png")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        String searchQuery = jTextField1.getText();
        if (!searchQuery.matches("^[a-zA-Z0-9 ]*$")) {
            JOptionPane.showMessageDialog(null, "Invalid characters in search query.");
            return;
        }
        try {
            Connection con = DBConnection.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM medicines WHERE name LIKE '%" + searchQuery + "%' OR description LIKE '%" + searchQuery + "%'");
            //jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Add to Cart button action
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a medicine to add to the cart.");
            return;
        }

        String medicineId = jTable1.getValueAt(selectedRow, 0).toString(); // Assuming medicine_id is in the first column
        String quantity = JOptionPane.showInputDialog("Enter quantity:");
        if (!validateQuantityInput(quantity)) {
            return;
        }

        try {
            Connection con = DBConnection.getCon();
            Statement st = con.createStatement();
            
            // Retrieve the logged-in username
            String username = getLoggedInUsername();

            // Ensure the user is logged in
            if (username == null || username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please log in before adding items to the cart.");
                return;
            }
            
            // Assuming you have a Cart table with columns (cart_id, username, medicine_id, quantity)
            st.executeUpdate("INSERT INTO Cart (username, medicine_id, quantity) VALUES ('" + username + "', '" + medicineId + "', '" + quantity + "')");
            
            JOptionPane.showMessageDialog(null, "Medicine added to the cart successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }                                       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to logout", "Select", JOptionPane.YES_NO_OPTION);
        if (a==0) {
            setVisible(false);
            new Login().setVisible(true);
            logout();
        }
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Cart_Bill(getLoggedInUsername()).setVisible(true);   
    }//GEN-LAST:event_jButton2ActionPerformed

    // Method to set the logged-in username
    public static void setLoggedInUsername(String username) {
        loggedInUsername = username;
    }

    // Method to retrieve the logged-in username
    public static String getLoggedInUsername() {
        return loggedInUsername;
    }

    // Method to perform logout
    public static void logout() {
        loggedInUsername = null;
    }    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search_AddToCart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
