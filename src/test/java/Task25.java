import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Task25 extends TestBase {
    //Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Scroll down page to bottom
    //5. Verify 'SUBSCRIPTION' is visible
    //6. Click on arrow at bottom right side to move upward
    //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen

    @Test
    public void scrollDownAndUp() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        assertTrue(logo.isDisplayed());
        //4. Scroll down page to bottom
        WebElement bottom = driver.findElement(By.xpath("//p[@class='pull-left']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(bottom).perform();
        wait(2);

        //5. Verify 'SUBSCRIPTION' is visible
        WebElement subscription = driver.findElement(By.xpath("//h2[.='Subscription']"));
        assertTrue(subscription.isDisplayed());
        wait(2);

        //6. Click on arrow at bottom right side to move upward
        driver.findElement(By.xpath("//a[@id='scrollUp']")).click();
        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen

       assertTrue( driver.findElement(By.xpath("(//h2[.='Full-Fledged practice website for Automation Engineers'])[1] | " +
                "(//h2[.='Full-Fledged practice website for Automation Engineers'])[2] |" +
                " (//h2[.='Full-Fledged practice website for Automation Engineers'])[3]")).isDisplayed());
    }
}
