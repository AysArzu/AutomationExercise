import org.junit.Test;
import utilities.TestBase;

import static org.junit.Assert.*;

public class Task17 extends TestBase {
    /*
           Test Case 17: Remove Products From Cart
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Add products to cart
        5. Click 'Cart' button
        6. Verify that cart page is displayed
        7. Click 'X' button corresponding to particular product
        8. Verify that product is removed from the cart
     */

    @Test
    public void removeProductsFromCart() {
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        assertEquals(driver.getCurrentUrl(),"http://automationexercise.com");

//        4. Add products to cart

//        5. Click 'Cart' button

//        6. Verify that cart page is displayed

//        7. Click 'X' button corresponding to particular product

//        8. Verify that product is removed from the cart

    }
}
