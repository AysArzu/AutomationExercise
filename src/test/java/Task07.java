import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Task07 extends TestBase {
    //Test Case 7: Verify Test Cases Page
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Test Cases' button
    //5. Verify user is navigated to test cases page successfully

    @Test
    public void task07() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String title = driver.getTitle();
        assertTrue(title.contains("Automation"));

        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//a[text()=' Test Cases']")).click();

        //Reklam ciktigi icin yaptim
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[text()=' Test Cases']")).click();
        //5. Verify user is navigated to test cases page successfully
        WebElement text2 = driver.findElement(By.xpath("//b"));
        assertTrue(text2.isDisplayed());
    }
}
