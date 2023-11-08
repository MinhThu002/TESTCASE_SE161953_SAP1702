package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    WebDriver driver;

    //Define your locators at the top of the class
    By myOrderLink = By.linkText("MY ORDERS");
    By viewOrderLink = By.xpath("//span[@class='nobr']//a");
    By printOrderLink = By.linkText("Print Order");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Create methods for each action
    public void setMyOrderLink() {
        driver.findElement(myOrderLink).click();
    }

    public void setViewOrderLink() {
        driver.findElement(viewOrderLink).click();
    }

    public void setPrintOrderLink() {
        driver.findElement(printOrderLink).click();
    }

}