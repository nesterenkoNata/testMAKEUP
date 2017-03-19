import Login.Methods;
import org.openqa.selenium.WebDriver;
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

                            Methods meth = new Methods(driver);
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

    @Test (priority = 2)
    public static void loginTestsPositive(){
        driver.manage().window().maximize();
        driver.get("https://makeup.com.ua/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Methods loginMethods1 = new Methods(driver);
            loginMethods1.moveToLogin();
            loginMethods1.sendLogin("ushakova.n.o@gmail.com");
            loginMethods1.sendPassword("367521");
            driver.quit();
        }
}
