package BringItOn;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CodeTest extends PasteBinTest {
    @Test
    public void testCode(){
        Assert.assertEquals(driver.findElement(By.xpath("//textarea[@class='textarea']")).getText(),text,"Text ccode is incorrect");
    }

}
