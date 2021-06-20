package hurtmeplenty.tests;

import hurtmeplenty.pagemodels.TempMailPageModel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Set;

public class EmailTest extends BaseTest {
    public TempMailPageModel tempMailPageModel;

    @Test
    public void openNewTab() throws InterruptedException {
        String currentUrl = driver.getCurrentUrl();
        String actualWindow = null;
        tempMailPageModel = new TempMailPageModel(driver);
        ((JavascriptExecutor) driver).executeScript("window.open();");
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {
            if (!actual.equalsIgnoreCase(currentHandle)) {
                driver.switchTo().window(actual);
                driver.get("https://10minutemail.com/");
                actualWindow = actual;
            }
        }
        Thread.sleep(3000);
        String email = tempMailPageModel.getMailAddress();
        driver.switchTo().window(currentHandle);
        Thread.sleep(3000);
        calculatorPageModel.emailEstimateButtonClick();
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", calculatorPageModel.getEmailInput());
        boolean staleElement = true;

        while (staleElement) {

            try {

                calculatorPageModel.getEmailInput().sendKeys(email);
                staleElement = false;


            } catch (StaleElementReferenceException e) {

                staleElement = true;

            }

        }
        Thread.sleep(5000);
        calculatorPageModel.sendEmail();

        driver.switchTo().window(actualWindow);
        Thread.sleep(7000);

        tempMailPageModel.clickMailBoxHeader();

        System.out.println(tempMailPageModel.getTotalAmount());
    }
}
