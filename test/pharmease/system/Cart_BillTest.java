

package pharmease.system;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Cart_BillTest {

    private Cart_Bill cartBill;

    @Before
    public void setUp() {
        // You might need to mock the database connection or set up a test database for the cart items.
        cartBill = new Cart_Bill("username");
        // Creating some mock cart items for testing addToCart() method
        cartBill.cartItems = new ArrayList<>();
        // Creating a mock CartItem for testing addToCart() method
        Cart_Bill.CartItem mockCartItem = cartBill.new CartItem(1, "Paracetamol", 2, 10.0);
        cartBill.cartItems.add(mockCartItem); // Add mockCartItem to cartItems
    }
/*
    @Test
    public void testCalculateOrderTotal_WithItems() {
        // Action: Calculate the order total
        cartBill.calculateOrderTotal();

        // Assertion
        double expectedTotal = 20.0; // Replace with the expected total based on your cart items.
        assertEquals(expectedTotal, Double.parseDouble(cartBill.jLabel5.getText()), 0.01);
    }
*/

    @Test
    public void testCalculateOrderTotal_EmptyCart() {
        // Clear cart items for testing an empty cart scenario
        cartBill.cartItems.clear();

        // Action
        cartBill.calculateOrderTotal();

        // Assertion
        double expectedTotal = 0.0;
        assertEquals(expectedTotal, Double.parseDouble(cartBill.jLabel5.getText()), 0.01);
    }


    @Test
    public void testAddToCart_NewItem() {
        // Action
        cartBill.addToCart(2, "Medicine B", 3, 15.0);

        // Assertion
        assertEquals(1, cartBill.cartItems.size()); // Expecting 1 item in cart
        assertEquals(2, cartBill.cartItems.get(0).getMedicineId()); // Expecting medicineId to be 2
    }

    @Test
    public void testAddToCart_ExistingItem() {
        // Existing cart item with medicineId 1
        cartBill.addToCart(1, "Medicine A", 2, 10.0);

        // Adding the existing item again with a different quantity
        cartBill.addToCart(1, "Medicine B", 5, 10.0);

        // Assertion
        assertEquals(1, cartBill.cartItems.size()); // Expecting 1 item in cart
        assertEquals(1, cartBill.cartItems.get(0).getMedicineId()); // Existing item
        assertEquals(5, cartBill.cartItems.get(0).getQuantity()); // Total quantity after addition
    }
}
