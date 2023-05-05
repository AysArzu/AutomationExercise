import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Task10 extends TestBase {
    //Test Case 10: Verify Subscription in home page
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Scroll down to footer
    //5. Verify text 'SUBSCRIPTION'
    //6. Enter email address in input and click arrow button
    //7. Verify success message 'You have been successfully subscribed!' is visible

    @Test
    public void task10() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String title = driver.getTitle();
        assertTrue(title.contains("Automation"));


        //4. Scroll down to footer
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//p)[81]"))).perform();
        //5. Verify text 'SUBSCRIPTION'
        WebElement subscription = driver.findElement(By.xpath("(//h2)[82]"));
        assertTrue(subscription.isDisplayed());

        //6. Enter email address in input and click arrow button
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("istanbul@evim.com", Keys.ENTER);

        //7. Verify success message 'You have been successfully subscribed!' is visible

        WebElement actualResult = driver.findElement(By.xpath("//div[text()='You have been successfully subscribed!']"));
        assertTrue(actualResult.isDisplayed());
    }
}
