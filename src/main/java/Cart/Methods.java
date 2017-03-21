package Cart;


import Good.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Methods {
    static WebDriver driver;

    public Methods(WebDriver driver) {
        this.driver = driver;
    }

    public static void openCart() {
        WebElement open = driver.findElement(By.xpath(Locators.openCart));
        open.click();
    }
    public static void order() {
        WebElement order = driver.findElement(By.xpath(Locators.order));
        order.click();
    }
    public static String pricePowderCart(){
        WebElement p2=driver.findElement(By.xpath(Locators.powderPriceCart));
        String C = p2.getText();
        return C;
    }

}
