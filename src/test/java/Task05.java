import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Task05 extends TestBase {
    @Test
    public void name() {
        //Test Case 5: Register User with existing email
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String title = driver.getTitle();
        assertTrue(title.contains("Automation"));

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());

        //6. Enter name and already registered email address

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("istanbul");
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("istanbulda@evim.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        //8. Verify error 'Email Address already exist!' is visible
assertTrue(driver.findElement(By.xpath("//p[text()='Email Address already exist!']")).isDisplayed());
    }
}
