import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task23 extends TestBase {
    /*
    Test Case 23: Verify address details in checkout page
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'Signup / Login' button
    5. Fill all details in Signup and create account
    6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    7. Verify ' Logged in as username' at top
    8. Add products to cart
    9. Click 'Cart' button
    10. Verify that cart page is displayed
    11. Click Proceed To Checkout
    12. Verify that the delivery address is same address filled at the time registration of account
    13. Verify that the billing address is same address filled at the time registration of account
    14. Click 'Delete Account' button
    15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */
    @Test
    public void name() {
//        2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement homePage =  driver.findElement(By.xpath("//html"));
        assertTrue(homePage.isDisplayed());

        //    4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //    5. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("mugla");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("mugla@mgl.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        driver.findElement(By.xpath("//label[@for='id_gender2']")).click();
        Actions actions= new Actions(driver);
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

        //    6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement kullanici = driver.findElement(By.xpath("//b"));
        assertTrue(kullanici.isDisplayed());

        //    7. Verify ' Logged in as username' at top
        driver.findElement(By.xpath("//a[.='Continue']")).click();

        WebElement logged = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        assertTrue(logged.isDisplayed());

        //    8. Add products to cart
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//a[@data-product-id='4']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        wait(2);

        driver.findElement(By.xpath("//a[@data-product-id='5']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        wait(2);

        driver.findElement(By.xpath("//a[@data-product-id='6']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        wait(2);
        //    9. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //    10. Verify that cart page is displayed
        assertTrue(driver.findElement(By.xpath("//li[text()='Shopping Cart']")).isDisplayed());

        //    11. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[.='Proceed To Checkout']")).click();
        wait(2);

        //    12. Verify that the delivery address is same address filled at the time registration of account
        String deliveryAddress = driver.findElement(By.xpath("//li[@class='address_city address_state_name address_postcode']")).getText();

        assertEquals("New Jersey Amerika 123456",deliveryAddress);

        //    13. Verify that the billing address is same address filled at the time registration of account
        String billingAddress = driver.findElement(By.xpath("(//li[@class='address_city address_state_name address_postcode'])[2]")).getText();
        assertEquals(billingAddress,deliveryAddress);
        wait(2);
        //    14. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        wait(2);

        //    15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement delete = driver.findElement(By.xpath("//b"));
        assertTrue(delete.isDisplayed());
        wait(3);
        driver.findElement(By.linkText("Continue")).click();

    }
}
