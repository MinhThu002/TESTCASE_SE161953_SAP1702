package TC;

import driver.driverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@org.testng.annotations.Test
public class TC04 {
    public static void tc03() {

        //  Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // 1. Open target page
            driver.get("http://live.techpanda.org/");
            // Delay Web for Performance

            // 2. Click on Mobile
            WebElement mobileMenu = driver.findElement(By.className("level0"));
            mobileMenu.click();

            // 3. Click on Add To Compare product 1 Sony Xperia
            WebElement productSelect = driver.findElement(By.xpath("(//a[@class='link-compare'])[2]"));
            productSelect.click();

            //  Click on Add To Compare product 2 Iphone
            WebElement productSelect1 = driver.findElement(By.xpath("(//a[@class='link-compare'])[3]"));
            productSelect1.click();

            // 4. Click on Compare  and switching to new window
            WebElement productCompare = driver.findElement(By.xpath("//button[@class='button']"));
            productCompare.click();
            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            // 5. Verify the pop-up window and check that the products are reflected in it Heading "COMPARE PRODUCTS" with selected products in it.
            WebElement errorMessage = driver.findElement(By.xpath("//h1[text()='Compare Products']"));
            String expectedErrorMessage = "COMPARE PRODUCTS";
            Assert.assertEquals(expectedErrorMessage, errorMessage.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }
        // Quit browser session
        driver.quit();
    }
}