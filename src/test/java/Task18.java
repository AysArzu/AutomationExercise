import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Task18 extends TestBase {
    /*
           Test Case 18: View Category Products
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that categories are visible on left side bar
        4. Click on 'Women' category
        5. Click on any category link under 'Women' category, for example: Dress
        6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        7. On left side bar, click on any sub-category link of 'Men' category
        8. Verify that user is navigated to that category page
     */

    @Test
    public void viewCategoryProducts() {
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that categories are visible on left side bar
        assertTrue(driver.findElement(By.xpath("//h2[.='Category']")).isDisplayed());
//        4. Click on 'Women' category
        driver.findElement(By.xpath("//a[@href='#Women']")).click();

//        5. Click on any category link under 'Women' category, for example: Dress
        driver.findElement(By.xpath("//a[text()='Tops ']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='#Women']")).click();
       driver.findElement(By.xpath("//a[text()='Tops ']")).click();
//        6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        assertTrue(driver.findElement(By.xpath("//*[text()='Women - Tops Products']")).isDisplayed());

//        7. On left side bar, click on any sub-category link of 'Men' category
        driver.findElement(By.xpath("//a[@href='#Men']")).click();
        driver.findElement(By.xpath("//a[text()='Jeans ']")).click();

//        8. Verify that user is navigated to that category page
        assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());

    }
}
