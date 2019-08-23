package seleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAssertionExample
{
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void hardAssertion(){

        Assert.assertNull("assertion");
        Assert.assertNotNull("assertion");

        Assert.assertTrue(true);
        Assert.assertFalse(true);

//        Assert.assertEquals("pass","pass");
//        Assert.assertNotEquals("pass","pass");
    }

    @Test
    public void softAssertion(){

//        softAssert.assertEquals("pass","pass");
//        softAssert.assertNotEquals("pass","pass");


        softAssert.assertNull("assertion");
        softAssert.assertNotNull("assertion");

        softAssert.assertTrue(true);
        softAssert.assertFalse(true);

        softAssert.assertAll();
    }
}
