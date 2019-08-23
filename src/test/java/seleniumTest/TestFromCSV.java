package seleniumTest;

import com.opencsv.CSVReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class TestFromCSV
{
    ChromeDriver driver = new ChromeDriver();

    @Test(dataProvider = "inputData")
    public void seeData (String term) throws Exception
    {
       driver.get("https://google.com");
       driver.manage().window().maximize();
       driver.findElement(By.name("q")).sendKeys(term);
       driver.findElement(By.name("btnK")).submit();
       takeSnapShot(driver, "c://Trishul//google//"+term+".png");

    }

    @DataProvider(name = "inputData")
    public Object[] getDataFromProvider() throws IOException
    {

        return new Object[][]
                {
                        { "shoes" },
                        { "food" },
                        { "games" }
                };
    }

    @AfterClass
    public void closeBrowser()
    {
        driver.quit();
    }


    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }

}
