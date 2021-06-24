package hurtmeplenty.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TotalAmountTest extends BaseTest {

    @Test
    public void testTotalAmount() throws InterruptedException {
        calculatorPageModel.openNewTab();
        String email = tempMailPageModel.getMailAddress();
        driver.switchTo().window(calculatorPageModel.getCurrentHandle());
        String totalAmountFromCalculatorPage = calculatorPageModel.getTotalAmount();
        calculatorPageModel.emailEstimateButtonClick();
        calculatorPageModel.setEmaiInput(email);
        calculatorPageModel.sendEmail();
        driver.switchTo().window(calculatorPageModel.getMailPage());
        tempMailPageModel.clickMailBoxHeader();
        Assert.assertTrue(totalAmountFromCalculatorPage.contains(tempMailPageModel.getTotalAmount()));
    }
}
