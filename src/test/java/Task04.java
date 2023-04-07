import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task04 extends TestBase {
    /*Test Case 4: Logout User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page
     */

    @Test
    public void logoutUser() {
        //Test Case 4: Logout User
        //1. Launch browser
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

        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("istanbulda@evim.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");

        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //8. Verify that 'Logged in as username' is visible
        WebElement username = driver.findElement(By.xpath("//b"));
        assertTrue(username.isDisplayed());

        //9. Click 'Logout' button
        driver.findElement(By.linkText("Logout")).click();

        //10. Verify that user is navigated to login page
        String actualUrl = driver.getCurrentUrl();
        assertEquals("https://automationexercise.com/login",actualUrl);

    }
}
