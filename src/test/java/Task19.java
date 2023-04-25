import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.*;

public class Task19 extends TestBase {
    /*
          Test Case 19: View & Cart Brand Products
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Click on 'Products' button
        4. Verify that Brands are visible on left side bar
        5. Click on any brand name
        6. Verify that user is navigated to brand page and brand products are displayed
        7. On left side bar, click on any other brand link
        8. Verify that user is navigated to that brand page and can see products
     */

    @Test
    public void viewCartBrandProducts() {
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[text()=' Products']")).click();

        // 4. Verify that Brands are visible on left side bar
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        assertTrue(driver.findElement(By.xpath("(//h2)[2]")).isDisplayed());

        // 5. Click on any brand name
        driver.findElement(By.xpath("//a[text()='H&M']")).click();

        // 6. Verify that user is navigated to brand page and brand products are displayed
        String title = driver.getTitle();
        assertTrue(title.contains("H&M"));
        assertTrue(driver.findElement(By.xpath("//h2[text()='Brand - H&M Products']")).isDisplayed());

        // 7. On left side bar, click on any other brand link
        driver.findElement(By.xpath("//a[text()='Biba']")).click();

        // 8. Verify that user is navigated to that brand page and can see products
        String titleBiba = driver.getTitle();
        assertTrue(titleBiba.contains("Biba"));
        assertTrue(driver.findElement(By.xpath("//h2[text()='Brand - Biba Products']")).isDisplayed());
    }
}
