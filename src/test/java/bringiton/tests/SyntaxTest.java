package bringiton.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SyntaxTest extends BaseTest {
    @Test
    public void testSyntax() {
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='left']/a[@class='btn -small h_800']")).getText(),syntaxHighlightingValue,"Syntax is incorrect");
    }
}
