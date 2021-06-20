package hurtmeplenty.pagemodels;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TempMailPageModel {
    private WebDriver driver;
    @FindBy(xpath = "//input[@id='mail_address']")
    private WebElement mailAddressInput;

    @FindBy(xpath = "//div[@class='mail_message']/div[@class='message_top']")
    private WebElement mailBoxHeader;

    @FindBy(xpath ="//tr[@id='mobilepadding']//table/tbody/tr[3]/td[2]" )
    private WebElement totalAmount;

    public TempMailPageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getMailAddress() {
        return mailAddressInput.getAttribute("value");
    }

    public void clickMailBoxHeader() {
        new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(mailBoxHeader)).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mailBoxHeader);
    }

    public String getTotalAmount() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", totalAmount);
        return totalAmount.getText();
    }
}
