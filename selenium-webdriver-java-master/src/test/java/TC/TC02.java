package TC;

import driver.driverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@org.testng.annotations.Test
public class TC02 {
    public static void tc02() {

        // 1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // 2. Open target page
            driver.get("http://live.techpanda.org/");
            // Delay Web for Performance

            // 3. Verify Home Page Title
            String wishTitle = "Home page";
            String pageTitle = driver.getTitle();
            Assert.assertEquals(wishTitle, pageTitle);

            // 4. Click on Mobile
            WebElement mobileMenu = driver.findElement(By.className("level0"));
            mobileMenu.click();

            // 5. Read the cost of Sony Xperia mobile in the list page
            WebElement sonyXperiaPriceListPage = driver
                    .findElement(By.xpath("//a[contains(text(),'Sony Xperia')]/following::span[@class='price']"));
            String sonyXperiaPriceList = sonyXperiaPriceListPage.getText();

            // 6. Click on Sony Xperia mobile
            WebElement sonyXperiaLink = driver.findElement(By.xpath("//a[contains(text(),'Sony Xperia')]"));
            sonyXperiaLink.click();

            // 7. Read the cost of Sony Xperia mobile in the details page
            WebElement sonyXperiaPriceDetailsPage = driver.findElement(By.xpath("//span[@class='price']"));
            String sonyXperiaPriceDetails = sonyXperiaPriceDetailsPage.getText();

            // 8. Compare the product prices from list and details page
            Assert.assertEquals("Product price not match", sonyXperiaPriceList, sonyXperiaPriceDetails);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 9. Quit browser session
        driver.quit();
    }
}
