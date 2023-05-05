import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Task06 extends TestBase {
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Contact Us' button
//5. Verify 'GET IN TOUCH' is visible
//6. Enter name, email, subject and message
//7. Upload file
//8. Click 'Submit' button
//9. Click OK button
//10. Verify success message 'Success! Your details have been submitted successfully.' is visible
//11. Click 'Home' button and verify that landed to home page successfully
    @Test
    public void task06(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String title = driver.getTitle();
        assertTrue(title.contains("Automation"));

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("// a[text()=' Contact us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        assertTrue(driver.findElement(By.xpath("(//h2)[2]")).isDisplayed());

        //6. Enter name, email, subject and message
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Cennet");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Kahraman@gmail.com");
        driver.findElement(By.cssSelector("input[name='subject']")).sendKeys("iade");
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("Iade etmek istiyorum");

        //7. Upload file
        String userHome = System.getProperty("user.home");
        String path= userHome + "\\Desktop\\logo.jpeg";
        driver.findElement(By.cssSelector("input[type='file']")).sendKeys(path);
        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //9. Click OK button
        driver.switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement text = driver.findElement(By.xpath("//div[text()='Success! Your details have been submitted successfully.']"));
        assertTrue(text.isDisplayed());

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("(//*[text()=' Home'])[2]")).click();
    }
}
