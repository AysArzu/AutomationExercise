import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Task12 extends TestBase {
    @Test
    public void Task12() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement html = driver.findElement(By.xpath("//html"));
        assertTrue(html.isDisplayed());

        //4. Click 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().back();
        driver.navigate().forward();
        //5. Hover over first product and click 'Add to cart'
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();


        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();

        //7. Hover over second product and click 'Add to cart'
        driver.findElement(By.xpath("//a[@data-product-id='2']")).click();
        //driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
        //8. Click 'View Cart' button
        driver.findElement(By.linkText("View Cart")).click();

        //9. Verify both products are added to Cart
        assertTrue(driver.findElement(By.id("product-1")).isDisplayed());
        assertTrue(driver.findElement(By.id("product-2")).isDisplayed());
        //10. Verify their prices, quantity and total price
        assertTrue(driver.findElement(By.xpath("//p[text()='Rs. 500']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//p[text()='Rs. 400']")).isDisplayed());

        assertTrue(driver.findElement(By.xpath("//button[@class='disabled']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//button[@class='disabled'])[2]")).isDisplayed());


        assertTrue(driver.findElement(By.xpath("//p[@class='cart_total_price']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("(//p[@class='cart_total_price'])[2]")).isDisplayed());
    }
}
