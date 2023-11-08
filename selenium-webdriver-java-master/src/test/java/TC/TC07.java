package TC;

import POM.CartPage;
import POM.CheckOutPage;
import POM.LoginPage;
import POM.OrderPage;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.File;

@org.testng.annotations.Test
public class TC07 {
    public static void tc06() {
        //LoginPage
        String email_address = "tin2@gmail.com";
        String password = "123456";

        //  Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();

        // import function from POM
        LoginPage loginPage = new LoginPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        try {
            // 1. Open target page
            driver.get("http://live.techpanda.org/");
            // Delay Web for Performance

            // 2. Click on my account link
            loginPage.myAccountLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 3.Login in application using previously created credential
            loginPage.enterEmailAddress(email_address);
            loginPage.enterPassword(password);

            // 3a. Click Login
            loginPage.loginButton();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 4.Click on 'My Orders'
            orderPage.setMyOrderLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 5.Click on 'View Order'
            orderPage.setViewOrderLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //6.Click on 'Print Order' link
            orderPage.setPrintOrderLink();

            // Take Screen shot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String png = "D:\\Fall23\\SWT301\\Ecommerce Project_Huynh_Trung_Tin\\src\\test\\java\\TC\\TC07.png";
            FileUtils.copyFile(srcFile, new File(png));

        } catch (Exception e) {
            e.printStackTrace();
        }
        //  Quit browser session
        driver.quit();
    }
}