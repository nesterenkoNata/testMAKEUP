package Login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Methods {
    static WebDriver driver;
    public Methods(WebDriver driver) {
        this.driver = driver;
    }

    public static void moveToLogin() {
        Actions action = new Actions(driver);
        WebElement login = driver.findElement(By.xpath(Locators.login));
        action.moveToElement(login).click().build().perform();
    }

    public static void sendLogin (String TestData) {
        WebElement loginField = driver.findElement(By.xpath(Locators.loginForm));
        loginField.sendKeys(TestData);
    }

    public static void sendPassword (String TestData) {
        WebElement passwordField = driver.findElement(By.xpath(Locators.passForm));
        passwordField.sendKeys(TestData);
        passwordField.submit();
    }

    public static String forgotPass() {
        WebElement emptyP = driver.findElement(By.xpath(Locators.forgotPass));
        String A = emptyP.getText();
        return A;
    }
}

