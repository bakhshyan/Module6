package hurtmeplenty.pagemodels;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TempMailPageModel extends BasePage {
    private WebDriver driver;
    @FindBy(xpath = "//input[@id='mail_address']")
    private WebElement mailAddressInput;

    @FindBy(xpath = "//span[@class='small_message_icon']")
    private WebElement mailBoxHeader;

    @FindBy(xpath = "//tr[@id='mobilepadding']//table/tbody/tr[3]/td[2]")
    private WebElement totalAmount;

    public TempMailPageModel(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getMailAddress() {
        waitForELementToAppear(mailAddressInput);
        return mailAddressInput.getAttribute("value");
    }

    public void clickMailBoxHeader() {
        waitForELementToAppear(mailBoxHeader);
        mailBoxHeader.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mailBoxHeader);
    }

    public String getTotalAmount() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", totalAmount);
        return totalAmount.getText();
    }
}
