import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.*;

import static org.junit.Assert.*;

public class Task26 extends TestBase {
    //Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Scroll down page to bottom
    //5. Verify 'SUBSCRIPTION' is visible
    //6. Scroll up page to top
    //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen

    @Test
    public void ArrowScrollDown() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        //4. Scroll down page to bottom
        Actions actions = new Actions(driver);
        actions.
                sendKeys(Keys.PAGE_DOWN).

                perform();
        //5. Verify 'SUBSCRIPTION' is visible
        WebElement subscription = driver.findElement(By.xpath("//h2[text()='Subscription']"));
        assertTrue(subscription.isDisplayed());

        //6. Scroll up page to top
        actions.sendKeys(Keys.PAGE_UP).perform();

        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        assertTrue(driver.findElement(By.xpath("(//h2)[1] | (//h2)[2] | (//h2)[3]")).isDisplayed());
    }
}
