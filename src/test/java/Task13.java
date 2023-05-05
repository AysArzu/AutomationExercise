import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task13 extends TestBase{
    //Test Case 13: Verify Product quantity in Cart
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click 'View Product' for any product on home page
    //5. Verify product detail is opened
    //6. Increase quantity to 4
    //7. Click 'Add to cart' button
    //8. Click 'View Cart' button
    //9. Verify that product is displayed in cart page with exact quantity

    @Test
    public void task13() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String title = driver.getTitle();
        assertTrue(title.contains("Automation"));

        //4. Click 'View Product' for any product on home page
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();

        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        //5. Verify product detail is opened
        assertEquals("https://automationexercise.com/product_details/1", driver.getCurrentUrl());

        //6. Increase quantity to 4
        driver.findElement(By.xpath("//input[@type='number']")).clear();
        driver.findElement(By.xpath("//input[@type='number']")).sendKeys("4");

        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@type='button']")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//u")).click();
        //9. Verify that product is displayed in cart page with exact quantity
        assertEquals("4",driver.findElement(By.xpath("//button[@class='disabled']")).getText());
    }
}
