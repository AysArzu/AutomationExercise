import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task15 extends TestBase {
    //Test Case 15: Place Order: Register before Checkout
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click 'Signup / Login' button
    //5. Fill all details in Signup and create account
    //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    //7. Verify ' Logged in as username' at top
    //8. Add products to cart
    //9. Click 'Cart' button
    //10. Verify that cart page is displayed
    //11. Click Proceed To Checkout
    //12. Verify Address Details and Review Your Order
    //13. Enter description in comment text area and click 'Place Order'
    //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    //15. Click 'Pay and Confirm Order' button
    //16. Verify success message 'Your order has been placed successfully!'
    //17. Click 'Delete Account' button
    //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button

    @Test
    public void task15() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String title = driver.getTitle();
        assertTrue(title.contains("Automation"));

        //4. Click on 'Signup / Login' button
        driver.findElement(By.linkText("Signup / Login")).click();

        //5. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("istanbul");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("istanbul@evi.com", Keys.ENTER);
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("password")).sendKeys("12345");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("12")
                .sendKeys(Keys.TAB).sendKeys("March").
                sendKeys(Keys.TAB).sendKeys("2014").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB)
                .sendKeys("Ankara").sendKeys(Keys.TAB)
                .sendKeys("Adana").sendKeys(Keys.TAB)
                .sendKeys("bireysel").sendKeys(Keys.TAB)
                .sendKeys("yeni mah. 215. sok").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("Canada").sendKeys(Keys.TAB).
                sendKeys("Montreal").sendKeys(Keys.TAB).
                sendKeys("Toronto").sendKeys(Keys.TAB).
                sendKeys("437834789").sendKeys(Keys.TAB).
                sendKeys("9832141783589").sendKeys(Keys.ENTER).perform();

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement kullanici = driver.findElement(By.xpath("//b"));
        assertTrue(kullanici.isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        //7. Verify ' Logged in as username' at top
        WebElement logged = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        assertTrue(logged.isDisplayed());

        //8. Add products to cart
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//a[@data-product-id='4']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        wait(2);

        driver.findElement(By.xpath("//a[@data-product-id='5']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        wait(2);

        //9. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //10. Verify that cart page is displayed
        assertTrue(driver.findElement(By.xpath("//li[text()='Shopping Cart']")).isDisplayed());

        //11. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[.='Proceed To Checkout']")).click();
        wait(2);
        //12. Verify Address Details and Review Your Order
        String deliveryAddress = driver.findElement(By.xpath("//li[@class='address_city address_state_name address_postcode']")).getText();

        assertEquals("Toronto Montreal 437834789",deliveryAddress);

        //13. Enter description in comment text area and click 'Place Order'
        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //15. Click 'Pay and Confirm Order' button
        //16. Verify success message 'Your order has been placed successfully!'
        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement delete = driver.findElement(By.xpath("//b"));
        assertTrue(delete.isDisplayed());
    }
}
