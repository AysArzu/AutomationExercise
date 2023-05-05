import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.*;

public class Task01 extends TestBase {
    //Test Case 1: Register User
    @Test
    public void registerUser() {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String title = driver.getTitle();
        assertTrue(title.contains("Automation"));

        //4. Click on 'Signup / Login' button
        driver.findElement(By.linkText("Signup / Login")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement signUp = driver.findElement(By.xpath("(//h2)[3]"));
        assertTrue(signUp.isDisplayed());

        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("istanbul");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("istanbul@evim.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement yazi = driver.findElement(By.xpath("//b"));
        assertTrue(yazi.isDisplayed());


        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("password")).sendKeys("12345");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("12")
                .sendKeys(Keys.TAB).sendKeys("March").
                sendKeys(Keys.TAB).sendKeys("2014").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB)
                //10. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
                .sendKeys("Ankara").sendKeys(Keys.TAB)
                .sendKeys("Adana").sendKeys(Keys.TAB)
                .sendKeys("bireysel").sendKeys(Keys.TAB)
                .sendKeys("yeni mah. 215. sok").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("Canada").sendKeys(Keys.TAB).
                sendKeys("Montreal").sendKeys(Keys.TAB).
                sendKeys("Toronto").sendKeys(Keys.TAB).
                sendKeys("437834789").sendKeys(Keys.TAB).
                sendKeys("9832141783589").
         //11. Click 'Create Account button'
                        sendKeys(Keys.ENTER).perform();


        //12. Verify that 'ACCOUNT CREATED!' is visible
        WebElement kullanici = driver.findElement(By.xpath("//b"));
        assertTrue(kullanici.isDisplayed());

       //13. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

       //14. Verify that 'Logged in as username' is visible
        WebElement logged = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        assertTrue(logged.isDisplayed());

       //15. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

       //16. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement delete = driver.findElement(By.xpath("//b"));
        assertTrue(delete.isDisplayed());

        driver.findElement(By.linkText("Continue")).click();




    }
}
