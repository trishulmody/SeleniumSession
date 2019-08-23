package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestActionClassExample
{

    public static void main(String[] args) throws Exception
    {

// Initiate browser
        WebDriver driver = new ChromeDriver();

// maximize browser
        driver.manage().window().maximize();

// Open webpage
        driver.get("http://jqueryui.com/resources/demos/droppable/default.html");

// Add 5 seconds wait
        Thread.sleep(5000);

// Create object of actions class
        Actions actions = new Actions(driver);

// find element which we need to drag
        WebElement drag = driver.findElement(By.xpath(".//*[@id='draggable']"));

// find element which we need to drop
        WebElement drop = driver.findElement(By.xpath(".//*[@id='droppable']"));

// this will drag element to destination
        actions.dragAndDrop(drag, drop).build().perform();

// Add 5 seconds wait
        Thread.sleep(5000);

// this will close the web driver instance & 
        driver.quit();

    }
}