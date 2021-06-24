package hurtmeplenty.tests;

import hurtmeplenty.pagemodels.TempMailPageModel;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class TotalAmountTest extends BaseTest {
    public TempMailPageModel tempMailPageModel;

    @Test
    public void testTotalAmount() throws InterruptedException {
        String calculatorPage = driver.getCurrentUrl();
        String mailPage = null;
        tempMailPageModel = new TempMailPageModel(driver);
        ((JavascriptExecutor) driver).executeScript("window.open();");
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {
            if (!actual.equalsIgnoreCase(currentHandle)) {
                driver.switchTo().window(actual);
                driver.get("https://10minutemail.com/");
                mailPage = actual;
            }
        }
        String email = tempMailPageModel.getMailAddress();
        driver.switchTo().window(currentHandle);
        String totalAmountFromCalculatorPage = calculatorPageModel.getTotalAmount();
        calculatorPageModel.emailEstimateButtonClick();
        calculatorPageModel.setEmaiInput(email);
        calculatorPageModel.sendEmail();
        driver.switchTo().window(mailPage);
        tempMailPageModel.clickMailBoxHeader();
        Assert.assertTrue(totalAmountFromCalculatorPage.contains(tempMailPageModel.getTotalAmount()));
    }
}
