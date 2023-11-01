package TC;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@org.testng.annotations.Test
public class TC01 {
    public static void tc01() {

        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //2. Open target page
            driver.get("http://live.techpanda.org/");
            // Delay Web for Performance

            // 3. Verify Home Page Title
            String wishTitle = "Home page";
            String pageTitle = driver.getTitle();
            Assert.assertEquals(wishTitle, pageTitle);

            // 4. Click on Mobile
            WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            mobileMenu.click();

            // 5. In the list of all mobile, select SORT BY -> dropdown as name
            WebElement sortByDropdown = driver.findElement(By.xpath("//select[@title='Sort By']"));
            sortByDropdown.sendKeys("Name");
            // 6. Verify all products are sorted by name
            List<WebElement> productNames = driver.findElements(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul"));
            List<String> productNamesList = new ArrayList<>();
            for (WebElement productName : productNames) {
                productNamesList.add(productName.getText());
            }
            //check if they are sorted
            List<String> sortedProductNamesList = new ArrayList<>(productNamesList);
            Collections.sort(sortedProductNamesList);
            Assert.assertEquals(sortedProductNamesList, productNamesList);

        }catch (Exception e){
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
