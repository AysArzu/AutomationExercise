import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Task03 extends TestBase {
    @Test
    public void test01() {
//Test Case 3: Login User with incorrect email and password
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String title = driver.getTitle();
        assertTrue(title.contains("Automation"));
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();


        //5. Verify 'Login to your account' is visible
        WebElement loginAccount = driver.findElement(By.xpath("//h2"));
        assertTrue(loginAccount.isDisplayed());

        //6. Enter incorrect email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("iztanbul@evim.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");
        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //8. Verify error 'Your email or password is incorrect!' is visible
       WebElement incorrectMail = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
        assertTrue(incorrectMail.isDisplayed());
    }
}
