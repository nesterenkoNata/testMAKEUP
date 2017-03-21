import Login.Methods;
import Reviews.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Tests {
    Tests() {
        this.driver = new ChromeDriver();
    }

    static WebDriver driver;

    public static void main(String[] args) {
        Tests test = new Tests();
        test.loginTestxml();
        test.loginTestsPositive();
        test.choosingGoods();
        test.checkingCart();
        test.review();
        test.addReview();
        test.myReview();

    }

    @Test(priority = 1)

    public static void loginTestxml() {
        driver.manage().window().maximize();
        driver.get("https://makeup.com.ua/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            File loginXml = new File("E:\\testMAKEUP\\src\\main\\Data files\\login.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(loginXml);

            doc.getDocumentElement().normalize();
            NodeList user = doc.getElementsByTagName("User");

            for (int i = 0; i < user.getLength(); i++) {
                Node nNode = user.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    Login.Methods meth = new Login.Methods(driver);
                    meth.moveToLogin();
                    meth.sendLogin(eElement.getElementsByTagName("login").item(0).getTextContent());
                    meth.sendPassword(eElement.getElementsByTagName("password").item(0).getTextContent());
                    Assert.assertEquals(meth.forgotPass(), "");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public static void loginTestsPositive() {
        driver.manage().window().maximize();
        driver.get("https://makeup.com.ua/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Login.Methods meth = new Login.Methods(driver);
        meth.moveToLogin();
        meth.sendLogin("ushakova.n.o@gmail.com");
        meth.sendPassword("367521");
    }

    @Test(priority = 3)
    public static void choosingGoods() {
        Good.Methods meth = new Good.Methods(driver);
        meth.make();
        meth.category();
        meth.powder();
        meth.powderBuy();
        meth.keep();

    }

    @Test(priority = 4)
    public static void checkingCart() {
        driver.manage().window().maximize();
        driver.get("https://makeup.com.ua/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Good.Methods methodG = new Good.Methods(driver);
        Cart.Methods methodC = new Cart.Methods(driver);
        methodC.openCart();
        methodC.order();
        try {
            Assert.assertEquals(methodC.pricePowderCart(), methodG.powderPrice());
        } catch (Exception e) {
            System.out.println();
        }
    }
    @Test(priority = 5)
    public static void review() {
        driver.manage().window().maximize();
        driver.get("https://makeup.com.ua/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Reviews.Methods methodR = new Reviews.Methods (driver);
        methodR.chooseLanvin();
        try {
            Assert.assertTrue(driver.findElement(By.xpath(Locators.review)).isDisplayed());
        } catch (Exception e) {
            System.out.println();
        }
    }

    @Test(priority = 6)
    public static void addReview() {
        driver.manage().window().maximize();
        driver.get("https://makeup.com.ua/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Reviews.Methods methodR = new Reviews.Methods (driver);
        methodR.chooseLanvin();
        methodR.addReview();
        methodR.sendCity("Киев");
        methodR.text("Товаром довольна");
        methodR.add();
    }
    @Test(priority = 7)
    public static void myReview() {
        driver.manage().window().maximize();
        driver.get("https://makeup.com.ua/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Reviews.Methods methodR = new Reviews.Methods (driver);
        methodR.chooseLanvin();
        try {
            Assert.assertTrue(driver.findElement(By.partialLinkText("Духи очень нравятся")).isDisplayed());
        } catch (Exception e) {
            System.out.println("Текст не найден");
        }
    }
}

