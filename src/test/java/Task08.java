import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task08 extends TestBase {
    //Test Case 8: Verify All Products and product detail page
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. The products list is visible
    //7. Click on 'View Product' of first product
    //8. User is landed to product detail page
    //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
    @Test
    public void task08() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String title = driver.getTitle();
        assertTrue(title.contains("Automation"));

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        //reklam icin
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[text()=' Products']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        assertEquals("https://automationexercise.com/products", driver.getCurrentUrl());

        //6. The products list is visible
        WebElement text = driver.findElement(By.xpath("(//h2)[3]"));
        assertTrue(text.isDisplayed());

        //7. Click on 'View Product' of first product
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        //8. User is landed to product detail page
        assertEquals("https://automationexercise.com/product_details/1", driver.getCurrentUrl());

        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//p)[3]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//*[text()='Rs. 500']")).isDisplayed());

        assertTrue(driver.findElement(By.xpath("(//p)[4]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//p)[5]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//p)[6]")).isDisplayed());

    }
}
