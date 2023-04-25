import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task14 extends TestBase {
    @Test
    public void test01() throws AWTException {
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

//        3. Verify that home page is visible successfully
      WebElement homePage =  driver.findElement(By.xpath("//html"));
        assertTrue(homePage.isDisplayed());
//        4. Add products to cart
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//a[@data-product-id='1'])")).click();
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='2'])")).click();
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='3'])")).click();
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
//        5. Click 'Cart' button
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
//        6. Verify that cart page is displayed
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
//        7. Verify that cart page is displayed
        assertTrue(driver.findElement(By.id("cart_items")).isDisplayed());

//        8. Click 'Register / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
//        9. Fill all details in Signup and create account


        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("istanbul");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("istanbulda@evim.com");

        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();


        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("password")).sendKeys("12345");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).sendKeys("12")
                .sendKeys(Keys.TAB).sendKeys("March").
                sendKeys(Keys.TAB).sendKeys("2014").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB)
                .sendKeys("Ankara").sendKeys(Keys.TAB)
                .sendKeys("Adana").sendKeys(Keys.TAB)
                .sendKeys("bireysel").sendKeys(Keys.TAB)
                .sendKeys("yeni mah. 215. sok").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("Canada").sendKeys(Keys.TAB).
                sendKeys("Montreal").sendKeys(Keys.TAB).
                sendKeys("Toronto").sendKeys(Keys.TAB).
                sendKeys("437834789").sendKeys(Keys.TAB).
                sendKeys("9832141783589").
                sendKeys(Keys.ENTER).perform();

//        10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement kullanici = driver.findElement(By.xpath("//b"));
        assertTrue(kullanici.isDisplayed());
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
//        11. Verify ' Logged in as username' at top
        assertTrue(driver.findElement(By.xpath("//b")).isDisplayed());
        wait(3);
//        12.Click 'Cart' button
        driver.findElement(By.linkText("Cart")).click();
//        13. Click 'Proceed To Checkout' button
        driver.findElement(By.linkText("Proceed To Checkout")).click();

//        14. Verify Address Details and Review Your Order
        assertTrue(driver.findElement(By.xpath("//h2")).isDisplayed());

//        15. Enter description in comment text area and click 'Place Order'
        Robot robot = new Robot();
        robot.mouseWheel(8);
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("bu kiyafetler cok guzel");
        driver.findElement(By.linkText("Place Order")).click();

//        16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("123456789");
        Actions ac = new Actions(driver);
        ac.sendKeys(Keys.TAB)
                .sendKeys("12345").sendKeys(Keys.TAB)
                .sendKeys("113").sendKeys(Keys.TAB)
                .sendKeys("09").sendKeys(Keys.TAB)
                .sendKeys("2025").
//        17. Click 'Pay and Confirm Order' button
        sendKeys(Keys.ENTER).perform();


//        18. Verify success message 'Your order has been placed successfully!'
       assertEquals(driver.findElement(By.cssSelector("h1.entry-title")).getText(), "Your order has been placed successfully!");


//        19. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
//        20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement delete = driver.findElement(By.xpath("//b"));
        assertTrue(delete.isDisplayed());

        driver.findElement(By.linkText("Continue")).click();


    }
}