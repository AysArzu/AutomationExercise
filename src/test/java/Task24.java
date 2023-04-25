import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task24 extends TestBase {
    /*
         Test Case 24: Download Invoice after purchase order
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Add products to cart
        5. Click 'Cart' button
        6. Verify that cart page is displayed
        7. Click Proceed To Checkout
        8. Click 'Register / Login' button
        9. Fill all details in Signup and create account
        10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        11. Verify ' Logged in as username' at top
        12.Click 'Cart' button
        13. Click 'Proceed To Checkout' button
        14. Verify Address Details and Review Your Order
        15. Enter description in comment text area and click 'Place Order'
        16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        17. Click 'Pay and Confirm Order' button
        18. Verify success message 'Your order has been placed successfully!'
        19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        20. Click 'Continue' button
        21. Click 'Delete Account' button
        22. Verify 'ACCOUNT DELETED!' and click 'Continue' button

     */

    @Test
    public void download() {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        assertTrue(logo.isDisplayed());
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // 4. Add products to cart
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        wait(2);

        driver.findElement(By.xpath("//a[@data-product-id='2']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        wait(2);

        driver.findElement(By.xpath("//a[@data-product-id='3']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        wait(2);
        //   5. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //   6. Verify that cart page is displayed
        assertTrue(driver.findElement(By.xpath("//li[text()='Shopping Cart']")).isDisplayed());

        //        7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[.='Proceed To Checkout']")).click();
        wait(2);

        //        8. Click 'Register / Login' button
        driver.findElement(By.xpath("(//a[@ href='/login'])[2]")).click();
        wait(4);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //        9. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("mugla");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("mugla@mgl.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        driver.findElement(By.xpath("//label[@for='id_gender2']")).click();

        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("mgll").sendKeys(Keys.TAB)
                .sendKeys("4").sendKeys(Keys.TAB)
                .sendKeys("January").sendKeys(Keys.TAB)
                .sendKeys("2010").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("Luppo").sendKeys(Keys.TAB)
                .sendKeys("Zippo").sendKeys(Keys.TAB)
                .sendKeys("Self").sendKeys(Keys.TAB)
                .sendKeys("Alabama").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("Canada").sendKeys(Keys.TAB)
                .sendKeys("Amerika").sendKeys(Keys.TAB)
                .sendKeys("New Jersey").sendKeys(Keys.TAB)
                .sendKeys("123456").sendKeys(Keys.TAB)
                .sendKeys("9809987654321", Keys.ENTER).perform();


        //        10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement kullanici = driver.findElement(By.xpath("//b"));
        assertTrue(kullanici.isDisplayed());


        //        11.Click continue and verify ' Logged in as username' at top
        driver.findElement(By.xpath("//a[.='Continue']")).click();

        WebElement logged = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        assertTrue(logged.isDisplayed());

        //        12.Click 'Cart' button
        driver.findElement(By.xpath("//a[@ href='/view_cart']")).click();
        wait(2);
        //        13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        wait(2);
        //        14. Verify Address Details and Review Your Order
        assertTrue(driver.findElement(By.xpath("//h2")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//h2)[2]")).isDisplayed());
        wait(2);
        //        15. Enter description in comment text area and click 'Place Order'
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Good dresses", Keys.ENTER);
        driver.findElement(By.xpath("//a[.='Place Order']")).click();
        wait(2);
        //        16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Sen Baskasin");
        actions.sendKeys(Keys.TAB)
                .sendKeys("123456789").sendKeys(Keys.TAB)
                .sendKeys("311").sendKeys(Keys.TAB)
                .sendKeys("09").sendKeys(Keys.TAB)
                .sendKeys("2024", Keys.ENTER).perform();
        wait(2);

        //        17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait(2);
        //        18. Verify success message 'Your order has been placed successfully!'
        //  assertEquals(driver.findElement(By.cssSelector("h1.entry-title")).getText(), "Your order has been placed successfully!");

        //        19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        driver.findElement(By.xpath("//a[.='Download Invoice']")).click();
        wait(4);
        String userHome = System.getProperty("user.home");

        String path = userHome + "\\Downloads\\invoice.txt";
        boolean isExist = Files.exists(Paths.get(path));
        assertTrue(isExist);
        //        20. Click 'Continue' button
        driver.findElement(By.xpath("//a[.='Continue']")).click();
        wait(3);

        //        21. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        wait(2);

        //        22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement delete = driver.findElement(By.xpath("//b"));
        assertTrue(delete.isDisplayed());
        wait(3);
        driver.findElement(By.linkText("Continue")).click();


    }
}
