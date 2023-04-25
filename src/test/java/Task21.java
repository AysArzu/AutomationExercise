import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.Assert.*;

public class Task21 extends TestBase {
        /*
            Test Case 21: Add review on product
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Click on 'Products' button
            4. Verify user is navigated to ALL PRODUCTS page successfully
            5. Click on 'View Product' button
            6. Verify 'Write Your Review' is visible
            7. Enter name, email and review
            8. Click 'Submit' button
            9. Verify success message 'Thank you for your review.'
         */

    @Test
    public void addReviewProduct() {
        //  2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        // 4. Verify user is navigated to ALL PRODUCTS page successfully
        String title = driver.getTitle();
        assertTrue(title.contains("All Products"));


        // 5. Click on 'View Product' button
        driver.findElement(By.xpath("//a[@ href='/product_details/1']")).click();
        // 6. Verify 'Write Your Review' is visible
        WebElement isDisplayed = driver.findElement(By.xpath("//a[text()='Write Your Review']"));
        assertTrue(isDisplayed.isDisplayed());
        // 7. Enter name, email and review
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Zorro");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Zorro@xplanet.com");
        driver.findElement(By.xpath("//textarea[@name='review']")).sendKeys("Shopping is so good.");

        // 8. Click 'Submit' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // 9. Verify success message 'Thank you for your review.'
        WebElement text = driver.findElement(By.xpath("//span[text()='Thank you for your review.']"));
        assertTrue(text.isDisplayed());


    }
}