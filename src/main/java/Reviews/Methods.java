package Reviews;


import Good.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Methods {
    static WebDriver driver;

    public Methods(WebDriver driver) {
        this.driver = driver;
    }

    public static void chooseLanvin () {
        WebElement l= driver.findElement(By.xpath(Locators.lanvin));
        l.click();
    }
    public static void addReview () {
        WebElement add = driver.findElement(By.xpath(Locators.review));
        add.click();
    }
    public static void sendCity (String TestData) {
        WebElement city = driver.findElement(By.xpath(Locators.city));
        city.sendKeys(TestData);
    }
    public static void text (String TestData) {
        WebElement text = driver.findElement(By.xpath(Locators.text));
        text.sendKeys(TestData);
    }
    public static void add () {
        WebElement a= driver.findElement(By.xpath(Locators.add));
        a.click();
    }
}
