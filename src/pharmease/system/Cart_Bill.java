package pharmease.system;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.util.ArrayList;
import java.util.List;

public class Cart_Bill extends javax.swing.JFrame {
    private String loggedInUsername;
    private String userFullName;
    public List<CartItem> cartItems; // New field to store cart items

    public Cart_Bill(String username) {
        this.loggedInUsername = Search_AddToCart.getLoggedInUsername();
        initComponents();
        retrieveUserFullName(); // Retrieve user's full name
        displayCartItems();
        calculateOrderTotal();
        jComboBox1.setSelectedItem("Cash on Delivery");

        // Display the full name of the user
        jLabel2.setText(userFullName);
    }

        class CartItem {
        private int medicineId;
        private String medicineName;
        private int quantity;
        private double price;

        public CartItem(int medicineId, String medicineName, int quantity, double price) {
            this.medicineId = medicineId;
            this.medicineName = medicineName;
            this.quantity = quantity;
            this.price = price;
        }

        // Getters for fields
        public String getUserFullName() {
            return userFullName;
        }
        
        public int getMedicineId() {
            return medicineId;
        }

        public String getMedicineName() {
            return medicineName;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }
    }
    
    // Add this method to retrieve user's full name
    protected void retrieveUserFullName() {
        try {
            Connection con = DBConnection.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT fullname FROM User WHERE username = '" + loggedInUsername + "'");

            if (rs.next()) {
                userFullName = rs.getString("fullname");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error retrieving user's full name: " + e.getMessage());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\name_icon.png")); // NOI18N
        jLabel1.setText("Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 80, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 150, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\payment_method.png")); // NOI18N
        jLabel3.setText("Payment Method:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, -1, 20));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash on Delivery", "Other (Currently not available)" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 220, -1));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Sl No", "Medicine_Id", "Medicine_name", "Quantity", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 590, 260));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Order Total= Rs");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 550, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 550, 80, 16));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\confirm_order_icon.png")); // NOI18N
        jButton1.setText("PLACE ORDER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 590, -1, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\logout.png")); // NOI18N
        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 40, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\clear_cart.png")); // NOI18N
        jButton2.setText("CLEAR CART");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 590, -1, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 220, 140));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\address.png")); // NOI18N
        jLabel6.setText("Add Address:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\back.png")); // NOI18N
        jButton4.setText("BACK");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 585, 111, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\PharmEase System\\Bg images & Icons (PharmEase System)\\Bill.png")); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to logout", "Select", JOptionPane.YES_NO_OPTION);
        if (a==0) {
            setVisible(false);
            new Login().setVisible(true);
        }

    }//GEN-LAST:event_jButton3ActionPerformed
   
    public void displayCartItems() {
        try {
            Connection con = DBConnection.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT c.medicine_id, m.name AS medicine_name, c.quantity, (m.price * c.quantity) AS price " +
                                           "FROM Cart c " +
                                           "JOIN medicines m ON c.medicine_id = m.medicine_id " +
                                           "WHERE c.username = '" + loggedInUsername + "'");
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error displaying cart items: " + e.getMessage());
        }
    }

    public void calculateOrderTotal() {
        try {
            Connection con = DBConnection.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(m.price * c.quantity) AS total " +
                                           "FROM Cart c " +
                                           "JOIN medicines m ON c.medicine_id = m.medicine_id " +
                                           "WHERE c.username = '" + loggedInUsername + "'");

            if (rs.next()) {
                double total = rs.getDouble("total");
                jLabel5.setText(String.format("%.2f", total));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error calculating order total: " + e.getMessage());
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // PLACE ORDER button action
        String paymentMethod = jComboBox1.getSelectedItem().toString();
        if (!paymentMethod.equals("Cash on Delivery")) {
            JOptionPane.showMessageDialog(null, "Currently only 'Cash on Delivery' is available as a payment method.");
            return;
        }
        
        // Check if the user has provided an address
        String address = jTextArea1.getText().trim();
        if (address.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please provide an address.");
            return;
        }
        
        // Check if the cart is empty
        //if (!isCartEmpty()) {
            try {
                Connection con = DBConnection.getCon();
                PreparedStatement ps = con.prepareStatement("INSERT INTO Orders (username, total_amount, payment_method, address) VALUES (?, ?, ?, ?)");
                ps.setString(1, loggedInUsername);
                ps.setDouble(2, Double.parseDouble(jLabel5.getText()));
                ps.setString(3, paymentMethod);
                ps.setString(4, address);

                int result = ps.executeUpdate();

                if (result > 0) {
                    // Order placed successfully
                    int a = JOptionPane.showConfirmDialog(null, "Confirm placing order?", "Select", JOptionPane.YES_NO_OPTION);
                    if (a == 0) {
                        JOptionPane.showMessageDialog(null, "Order placed successfully!");
                        // You may want to clear the cart after placing the order
                        clearCart();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to place the order.");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        //} else {
        //    JOptionPane.showMessageDialog(null, "Cart is empty. Can't place an order.");
        //}
    }//GEN-LAST:event_jButton1ActionPerformed

    /*/
    //method to check if the cart is empty
    protected boolean isCartEmpty() {
        try {
            Connection con = DBConnection.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS count FROM Cart WHERE username = '" + loggedInUsername + "'");
            if (rs.next()) {
                int count = rs.getInt("count");
                return count == 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error checking if the cart is empty: " + e.getMessage());
        }
        return true; // Default to true in case of an error
    }
    /*/
    
    public boolean isMedicineInCart(int medicineId) {
    for (CartItem item : cartItems) {
        if (item.getMedicineId() == medicineId) {
            return true;
        }
    }
    return false;
    }
    
    private int quantity;

    // Setter method for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter method for quantity
    public int getQuantity() {
        return this.quantity;
    }

    public void addToCart(int medicineId, String medicineName, int quantity, double price) {
        cartItems = new ArrayList<>();
        for (CartItem item : cartItems) {
            if (item.getMedicineId() == medicineId) {
                setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        CartItem item = new CartItem(medicineId, medicineName, quantity, price);
        cartItems.add(item);
    }
    
    public double getOrderTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // CLEAR CART button action
        int confirmClear = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear the cart?", "Confirm Clear Cart", JOptionPane.YES_NO_OPTION);
        if (confirmClear == 0) {
            try {
                Connection con = DBConnection.getCon();
                Statement st = con.createStatement();
                st.executeUpdate("DELETE FROM Cart WHERE username = '" + loggedInUsername + "'");
                displayCartItems(); // Refresh the cart view
                calculateOrderTotal(); // Update the order total
                JOptionPane.showMessageDialog(null, "Cart cleared successfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error clearing the cart: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setVisible(false);
        new Search_AddToCart().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    // You may want to add a method to clear the cart after placing the order
    protected void clearCart() {
        try {
            Connection con = DBConnection.getCon();
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM Cart WHERE username = '" + loggedInUsername + "'");
            displayCartItems(); // Refresh the cart view
            calculateOrderTotal(); // Update the order total
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    Search_AddToCart addToCartInstance = new Search_AddToCart();
    String username = addToCartInstance.getLoggedInUsername();
    public String getLoggedInUsername() {
        return loggedInUsername;
    }
    
    public static void main(String args[]) {
        // Create an instance of Search_AddToCart to get the username
        Search_AddToCart addToCartInstance = new Search_AddToCart();
        String username = addToCartInstance.getLoggedInUsername();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cart_Bill(username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
