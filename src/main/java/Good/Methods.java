package Good;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Methods {
    static WebDriver driver;

    public Methods(WebDriver driver) {
        this.driver = driver;
    }

    public static void make () {
        WebElement make = driver.findElement(By.xpath(Locators.make));
        make.click();
    }
    public static void category () {
        WebElement cat = driver.findElement(By.xpath(Locators.category));
        cat.click();
    }
    public static void powder() {
        WebElement p = driver.findElement(By.xpath(Locators.powder));
        p.click();
    }
    public static void powderBuy() {
        WebElement buy = driver.findElement(By.xpath(Locators.powderbuy));
        buy.click();

    }

        public static void keep() {
        WebElement keep = driver.findElement(By.xpath(Locators.keep));
        keep.click();
    }
    public static void mainPage() {
        WebElement m = driver.findElement(By.xpath(Locators.mainPage));
        m.click();
    }
    public static String powderPrice() {
        WebElement p1 = driver.findElement(By.xpath(Locators.powderPrice1));
        String A = p1.getText();
        return A;
    }


}
