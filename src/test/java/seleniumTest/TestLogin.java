package seleniumTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.File;

public class TestLogin
{
    public String login(String name, String pass) throws Exception
    {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://testing-ground.scraping.pro/login");
    WebElement username = driver.findElement(By.name("usr"));
    username.sendKeys(name);
    Thread.sleep(1000);
    WebElement password= driver.findElement(By.name("pwd"));
    password.sendKeys(pass);
    Thread.sleep(1000);
    password.submit();
    Thread.sleep(1000);
    WebElement result = driver.findElement(By.cssSelector("#case_login > h3"));
    String msg = result.getText();
    driver.quit();
    return msg;
    }

    @Test
    public void validLogin() throws Exception
    {
     String result =  login("admin","12345");
     System.out.println(result);
     Assert.assertEquals(result,"WELCOME :)");
    }

    @Test
    public void invalidBothLogin() throws Exception
    {
        String result =  login("incorrect","incorrect");
        System.out.println(result);
        Assert.assertEquals(result,"ACCESS DENIED!");
    }

    @Test
    public void invalidUserLogin() throws Exception
    {
        String result =  login("incorrect","12345");
        System.out.println(result);
        Assert.assertEquals(result,"ACCESS DENIED!");
    }

    @Test
    public void invalidPassLogin() throws Exception
    {
        String result =  login("admin","incorrect");
        System.out.println(result);
        Assert.assertEquals(result,"ACCESS DENIED!");
    }

}
