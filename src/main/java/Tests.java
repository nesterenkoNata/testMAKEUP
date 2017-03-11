import Login.Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class Tests {
    Tests() {
            this.driver = new ChromeDriver();
        }

        static WebDriver driver;

        public static void main(String[] args) {
            Tests test = new Tests();
            test.loginTestsNegative();
            test.loginTestsPositive();
        }

        @Test(priority = 1)
        public static void loginTestsNegative() {
            driver.manage().window().maximize();
            driver.get("https://makeup.com.ua/");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Methods loginMethods = new Methods(driver);

            loginMethods.moveToLogin();
            loginMethods.sendLogin("test@@gmail.com");
            loginMethods.sendPassword("11111111111");

            try {
                Assert.assertEquals(loginMethods.forgotPass(), "");
            } catch (Exception e) {
                System.out.println();
            }
        }

            @Test (priority = 2)
            public static void loginTestsPositive(){
            driver.manage().window().maximize();
            driver.get("https://makeup.com.ua/");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Methods loginMethods1 = new Methods(driver);
            loginMethods1.moveToLogin();
            loginMethods1.sendLogin("ushakova.n.o@gmail.com");
            loginMethods1.sendPassword("367521");

        }
            @AfterTest
            public void tearDownSecond(){driver.quit();}
}
