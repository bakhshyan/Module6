package BringItOn;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TitleTest extends PasteBinTest{


    @Test
    public void testTitle() throws InterruptedException {
        Assert.assertEquals(driver.getTitle(),pastNameValue+" - Pastebin.com","Title is incorrect");
    }

}