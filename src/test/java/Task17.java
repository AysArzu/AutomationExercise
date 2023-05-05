import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

//        4. Add products to cart
        driver.findElement(By.xpath("//a[@data-product-id='4']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        wait(2);

        driver.findElement(By.xpath("//a[@data-product-id='5']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        wait(2);

        driver.findElement(By.xpath("//a[@data-product-id='6']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
//        5. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
//        6. Verify that cart page is displayed
        assertTrue(driver.findElement(By.xpath("//li[text()='Shopping Cart']")).isDisplayed());
//        7. Click 'X' button corresponding to particular product
        driver.findElement(By.xpath("(//a[@class='cart_quantity_delete'])[1]")).click();


//        8. Verify that product is removed from the cart
        WebElement product1 = driver.findElement(By.xpath("//a[text()='Stylish Dress']"));
        wait(3);
        assertFalse(product1.isDisplayed());
    }
}
