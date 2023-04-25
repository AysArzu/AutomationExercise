import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task20 extends TestBase {
    /*
        Test Case 20: Search Products and Verify Cart After Login
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Click on 'Products' button
        4. Verify user is navigated to ALL PRODUCTS page successfully
        5. Enter product name in search input and click search button
        6. Verify 'SEARCHED PRODUCTS' is visible
        7. Verify all the products related to search are visible
        8. Add those products to cart
        9. Click 'Cart' button and verify that products are visible in cart
        10. Click 'Signup / Login' button and submit login details
        11. Again, go to Cart page
        12. Verify that those products are visible in cart after login as well

     */

    @Test
    public void verifyCartAfterLogin() {
//        2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

//        3. Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[text()=' Products']")).click();

//        4. Verify user is navigated to ALL PRODUCTS page successfully
        String title = driver.getTitle();
        assertTrue(title.contains("All Products"));

//        5. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("t-shirt");
        driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();

//        6. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProduct = driver.findElement(By.xpath("//h2[.='Searched Products']"));
        assertTrue(searchedProduct.isDisplayed());

//        7. Verify all the products related to search are visible
        WebElement products = driver.findElement(By.xpath("//input[@value='t-shirt']"));
        assertTrue(products.isDisplayed());

//        8. Add those products to cart
        driver.findElement(By.xpath("//a[@data-product-id='28']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        wait(3);

        driver.findElement(By.xpath("//a[@data-product-id='29']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        wait(3);

        driver.findElement(By.xpath("//a[@data-product-id='30']")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        wait(3);

//        9. Click 'Cart' button and verify that products are visible in cart
        driver.findElement(By.xpath("//a[text()=' Cart']")).click();

//        10. Click 'Signup / Login' button and submit login details
        driver.findElement(By.xpath("//a[@ href='/login']")).click();

        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("istanbulda@evim.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

//        11. Again, go to Cart page
        driver.findElement(By.xpath("//a[.=' Cart']")).click();

//        12. Verify that those products are visible in cart after login as well
        WebElement t_shirt1= driver.findElement(By.xpath("//a[@href='/product_details/28']"));
        assertTrue(t_shirt1.isDisplayed());

        WebElement t_shirt2= driver.findElement(By.xpath("//a[@href='/product_details/29']"));
        assertTrue(t_shirt2.isDisplayed());

        WebElement t_shirt3= driver.findElement(By.xpath("//a[@href='/product_details/30']"));
        assertTrue(t_shirt3.isDisplayed());
    }
}
