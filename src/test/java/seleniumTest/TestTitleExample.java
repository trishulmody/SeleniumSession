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

public class TestTitleExample
{

    WebDriver driver;

    @BeforeMethod
    @Parameters({"browserName"})
    public void setUpBrowser(@Optional("chrome") String browserName)
    {

/*        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);*/
        if (browserName.equalsIgnoreCase("internetexplorer"))
        {
            System.setProperty("webdriver.ie.driver", "C:\\Python27\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "C:\\Python27\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Python27\\chromedriver.exe");
            driver = new ChromeDriver();
        }
    }


    @Test
    public void testTitle()
    {

        driver.get("http://localhost/Trishul_Customer/seleniumLocators.html");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
    }


    @AfterMethod
    public void tearDownBrowser()
    {
        driver.quit();
    }

}