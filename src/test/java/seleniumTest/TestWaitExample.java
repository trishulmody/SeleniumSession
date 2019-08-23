package seleniumTest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestWaitExample
{

    private WebDriver driver;
    private String baseUrl;
    private WebElement element;

    @BeforeMethod
    public void setUp() throws Exception
    {
        driver = new ChromeDriver();
        baseUrl = "http://localhost/Trishul_Customer/seleniumWaitAndAddElement.html";
    }

    @Test
    public void testLongWait() throws Exception
    {
        driver.get(baseUrl);
        Thread.sleep(10000);
    try
        {
            element = driver.findElement(By.tagName("p"));
            if (element != null)
                System.out.println("Paragraph tag found in this page");
        }
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testShortWait() throws Exception
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.get(baseUrl);
        try
        {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated((By.tagName("p"))));
            if (element != null)
                System.out.println("Paragraph tag found in this page");
        }
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() throws Exception
    {
        driver.quit();
    }
}