package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    //Define your locators at the top of the class
    By myAccountLink = By.linkText("MY ACCOUNT");
    By enterEmailAddress = By.id("email");
    By enterPassword = By.id("pass");
    By loginButton = By.xpath("//button[@class='button']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Create methods for each action
    public void myAccountLink() {
        driver.findElement(myAccountLink).click();
    }

    public void enterEmailAddress(String emailAddress) {
        WebElement emailAddressElement = driver.findElement(enterEmailAddress);
        emailAddressElement.clear(); // clear the QTY before
        emailAddressElement.sendKeys(emailAddress);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(enterPassword);
        passwordElement.clear(); // clear the QTY before
        passwordElement.sendKeys(password);
    }

    public void loginButton() {
        driver.findElement(loginButton).click();
    }

}