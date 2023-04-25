import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Task22 extends TestBase {
    /*
    Test Case 22: Add to cart from Recommended items
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Scroll to bottom of page
4. Verify 'RECOMMENDED ITEMS' are visible
5. Click on 'Add To Cart' on Recommended product
6. Click on 'View Cart' button
7. Verify that product is displayed in cart page
     */
    @Test
    public void addCart() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Scroll to bottom of page
        Actions actions = new Actions(driver);

        WebElement target = driver.findElement(By.xpath("(//h2)[82]"));
        actions.scrollToElement(target).perform();
        //4. Verify 'RECOMMENDED ITEMS' are visible
        WebElement recommendedItems = driver.findElement(By.xpath("//h2[.='recommended items']"));
        assertTrue(recommendedItems.isDisplayed());
        //5. Click on 'Add To Cart' on Recommended product
        driver.findElement(By.xpath("(//a[@data-product-id='4'])[3]")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        wait(3);

        driver.findElement(By.xpath("(//a[@data-product-id='6'])[3]")).click();



        //6. Click on 'View Cart' button
        driver.findElement(By.xpath("//u[.='View Cart']")).click();
        wait(3);
        //7. Verify that product is displayed in cart page
        WebElement dress = driver.findElement(By.xpath("//a[text()='Stylish Dress']"));
        assertTrue(dress.isDisplayed());

        WebElement t_shirt= driver.findElement(By.xpath("//a[text()='Summer White Top']"));
        assertTrue(t_shirt.isDisplayed());
    }
}
