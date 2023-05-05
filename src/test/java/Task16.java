import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task16 extends TestBase {
    //Test Case 16: Place Order: Login before Checkout
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click 'Signup / Login' button
    //5. Fill email, password and click 'Login' button
    //6. Verify 'Logged in as username' at top
    //7. Add products to cart
    //8. Click 'Cart' button
    //9. Verify that cart page is displayed
    //10. Click Proceed To Checkout
    //11. Verify Address Details and Review Your Order
    //12. Enter description in comment text area and click 'Place Order'
    //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    //14. Click 'Pay and Confirm Order' button
    //15. Verify success message 'Your order has been placed successfully!'
    //16. Click 'Delete Account' button
    //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    @Test
    public void task16() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        //4. Click on 'Signup / Login' button
        driver.findElement(By.linkText("Signup / Login")).click();

        //5. Fill email, password and click 'Login' button
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("bidihat@arzu.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //6. Verify 'Logged in as username' at top
        WebElement username = driver.findElement(By.xpath("//b"));
        assertTrue(username.isDisplayed());

        //7. Add products to cart
        //1.Product
        driver.findElement(By.xpath("//a[@data-product-id='4']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        wait(2);
        //2.Product
        driver.findElement(By.xpath("//a[@data-product-id='5']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        wait(2);
        //3. Product
        driver.findElement(By.xpath("//a[@data-product-id='6']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();

        //8. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //9. Verify that cart page is displayed
        assertTrue(driver.findElement(By.xpath("//li[text()='Shopping Cart']")).isDisplayed());

        //10. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[.='Proceed To Checkout']")).click();
        wait(2);

        //11. Verify Address Details and Review Your Order
        WebElement verifyAdress = driver.findElement(By.xpath("(//h2)[1]"));
        assertTrue(verifyAdress.isDisplayed());
        WebElement reviewYourOrder = driver.findElement(By.xpath("(//h2)[2]"));
        assertTrue(reviewYourOrder.isDisplayed());

        //12. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//textarea[@class='form-control']")).
                sendKeys("urunler cabuk ulassin");
        wait(1);
        driver.findElement(By.xpath("//a[@href='/payment']")).click();
        wait(2);

        //NOT: alert geldi bundan kurtulmak icin refresh yapip islemleri tekrar yapmak zorunda kaldigim icin ayni kodlari yazdim.
        driver.navigate().refresh();
        driver.findElement(By.xpath("//textarea[@class='form-control']")).
                sendKeys("urunler cabuk ulassin");
        wait(1);
        driver.findElement(By.xpath("//a[@href='/payment']")).click();
        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Sen Baskasin");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB)
                .sendKeys("123456789").sendKeys(Keys.TAB)
                .sendKeys("311").sendKeys(Keys.TAB)
                .sendKeys("09").sendKeys(Keys.TAB)
                .sendKeys("2024", Keys.ENTER).perform();
        wait(2);
        //14. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait(2);

        //15. Verify success message 'Your order has been placed successfully!'
        //  assertEquals(driver.findElement(By.cssSelector("h1.entry-title")).getText(), "Your order has been placed successfully!");

        //16. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        wait(2);
        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement delete = driver.findElement(By.xpath("//b"));
        assertTrue(delete.isDisplayed());
        wait(3);
        driver.findElement(By.linkText("Continue")).click();
    }
}
