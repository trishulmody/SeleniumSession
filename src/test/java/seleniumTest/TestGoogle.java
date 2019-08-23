package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestGoogle
{


    public void googleSearch(String t) throws InterruptedException
    {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(t); // send also a "\n"
        Thread.sleep(1000);
        element.submit();
        // wait until the google page shows the result
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.partialLinkText("royalcollegemiraroad")).getText());
        driver.findElement(By.partialLinkText("royalcollegemiraroad")).click();
        Thread.sleep(3000);
        driver.quit();

    }
    @Test //(invocationCount = 2)
    public void searchRoyalCollege() throws InterruptedException
    {
        googleSearch("Royal College Mira Road");
    }

}
