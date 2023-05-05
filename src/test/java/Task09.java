import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task09 extends TestBase {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. Enter product name in search input and click search button
    //7. Verify 'SEARCHED PRODUCTS' is visible
    //8. Verify all the products related to search are visible


    @Test
    public void task09() {
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

        //6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("saree");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProduct = driver.findElement(By.xpath("(//h2)[3]"));
        assertTrue(searchedProduct.isDisplayed());

        //8. Verify all the products related to search are visible
        WebElement product1 = driver.findElement(By.xpath("//a[@data-product-id='39']"));
        WebElement product2 = driver.findElement(By.xpath("//a[@data-product-id='40']"));
        WebElement product3 = driver.findElement(By.xpath("//a[@data-product-id='41']"));
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        assertTrue(product1.isDisplayed());
        assertTrue(product2.isDisplayed());
        assertTrue(product3.isDisplayed());
    }
}
