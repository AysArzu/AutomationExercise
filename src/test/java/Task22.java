import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

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

        //5. Click on 'Add To Cart' on Recommended product

        //6. Click on 'View Cart' button

        //7. Verify that product is displayed in cart page

    }
}
