package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestLocatorExample
{

    WebDriver driver;

    @BeforeClass
    @Parameters({"browserName"})
    public void setUpBrowser(@Optional("chrome") String browserName){


        if(browserName.equalsIgnoreCase("internetexplorer")){
            System.setProperty("webdriver.ie.driver","C:\\Python27\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","C:\\Python27\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else{
            System.setProperty("webdriver.chrome.driver","C:\\Python27\\chromedriver.exe");
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--headless");
//            driver = new ChromeDriver(chromeOptions);
            driver = new ChromeDriver();
        }
    }


    @Test
    public void testAllLocators() throws InterruptedException
    {

        driver.get("http://localhost/Trishul_Customer/seleniumLocators.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String pageTitle = driver.getTitle();

        System.out.println("Page Title: "+pageTitle);

        WebElement idElement= driver.findElement(By.id("testingId"));
        System.out.println("By ID : "+idElement.getText());

        WebElement classElement= driver.findElement(By.className("testingClass"));
        System.out.println("By Class : "+classElement.getText());

        WebElement nameElement= driver.findElement(By.name("testingName"));
        System.out.println("By Name : "+nameElement.getText());

        WebElement tagElement= driver.findElement(By.tagName("a"));
        System.out.println("By Tag Name : "+tagElement.getText());


        WebElement linkElement= driver.findElement(By.linkText("This is an Anchor tag"));
        System.out.println("By Link Text : "+linkElement.getText());


        WebElement partialLinkElement= driver.findElement(By.partialLinkText("chor"));
        System.out.println("By Partial Link Text : "+partialLinkElement.getText());


        WebElement xpathElement= driver.findElement(By.xpath("//*[@id='testingId']"));
        System.out.println("By Xpath : "+xpathElement.getText());

        WebElement cssElement= driver.findElement(By.cssSelector("#testingId"));
        System.out.println("By CSS selector : "+cssElement.getText());
    }


    @AfterMethod
    public void tearDownBrowser(){
        driver.quit();
    }

}