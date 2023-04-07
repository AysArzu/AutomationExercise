import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

//Test Case 2: Login User with correct email and password
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Signup / Login' button
//5. Verify 'Login to your account' is visible
//6. Enter correct email address and password
//7. Click 'login' button
//8. Verify that 'Logged in as username' is visible
//9. Click 'Delete Account' button
//10. Verify that 'ACCOUNT DELETED!' is visible
public class Task02 extends TestBase {
    @Test
    public void loginUser() {
        //Test Case 2: Login User with correct email and password
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
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("istanbul@evim.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");
        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //8. Verify that 'Logged in as username' is visible
       WebElement username = driver.findElement(By.xpath("//b"));
       assertTrue(username.isDisplayed());

        //9. Click 'Delete Account' button
        driver.findElement(By.linkText("Delete Account")).click();

        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement delete = driver.findElement(By.xpath("//b"));
        assertTrue(delete.isDisplayed());
    }
}
