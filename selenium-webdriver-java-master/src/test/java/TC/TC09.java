package TC;

import POM.IndexPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.File;

@org.testng.annotations.Test
public class TC09 {
    public static void tc08() {
        //LoginPage
        String coupon = "GURU50";
        //  Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();

        // import function from POM
        IndexPage indexPage = new IndexPage(driver);

        try {
            // 1. Open target page
            driver.get("http://live.techpanda.org/");
            // Delay Web for Performance

            // 2. Go to Mobile and add IPHONE to cart
            indexPage.setMobileLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 2a.add IPHONE to cart
            indexPage.setAddToCartLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 3.Enter Coupon Code
            indexPage.setEnterCouponCode(coupon);
            indexPage.setApplyLink();

            //Verify Grand Total is changed
            WebElement ActualDiscount = driver
                    .findElement(By.xpath("(//td[@colspan='1'])[3]"));
            String ExpectedDiscount = "DISCOUNT (GURU50)";
            Assert.assertEquals(ActualDiscount.getText(), ExpectedDiscount);


            // Take Screen shot
//            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            String png = "D:\\Fall23\\SWT301\\Ecommerce Project_Huynh_Trung_Tin\\src\\test\\java\\TC\\TC08.png";
//            FileUtils.copyFile(srcFile, new File(png));

        } catch (Exception e) {
            e.printStackTrace();
        }
        //  Quit browser session
        driver.quit();
    }
}
