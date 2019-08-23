package seleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSum
{
    public int sum(int a, int b)
    {
        return a+b;
    }

    @Test
    public void verifyCorrectSum()
    {
        System.out.println("ACTUAL: "+sum(2,5));
        System.out.println("EXPECTED: "+7);
        Assert.assertTrue(sum(2,5)==7,"Sum of 2 and 5 should be 7");

    }

    @Test
    public void verifyIncorrectSum()
    {
        System.out.println("ACTUAL: "+sum(2,5));
        System.out.println("EXPECTED: "+8);
        Assert.assertFalse(sum(2,5)==8,"Sum of 2 and 5 should NOT be 8");
    }
}
