package seleniumTest;

import com.beust.jcommander.Parameter;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGExample
{

    @Test(priority = 4)
    public void makePayment()
    {
        Assert.assertTrue(true);
        System.out.println("5. makePayment");
    }

    @Test(priority = 3)
    public void selectNumberOfSeat()
    {
        Assert.assertTrue(true);
        System.out.println("4. selectNumberOfSeat");
    }

    @Test
    public void loginToApp()
    {
        Assert.assertTrue(true);
        System.out.println("1. loginToApp");
    }

    @Test(priority = 1)
    public void selectMovie()
    {
        Assert.assertTrue(true);
        System.out.println("2. selectMovie");
    }


    @Test(priority = 2)
    public void selectTheatre()
    {
        Assert.assertTrue(true);
        System.out.println("3. selectTheatre");
    }

    @Test(enabled = false)
    @Parameters({"param"})
    public void goToCounterAndBuyWithCash(@Optional("test") String param){
        Assert.assertTrue(true);
        System.out.println("goToCounterAndBuyWithCash: " + param);
    }


}
