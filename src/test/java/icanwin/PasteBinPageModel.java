package icanwin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBinPageModel extends BasePage {
    private WebDriver driver;

    @FindBy(css = "textarea[id='postform-text']")
    private WebElement newPasteTextArea;

    @FindBy(xpath = "//span[@data-select2-id='3']")
    private WebElement pasteExpirtaion;


    @FindBy(css = "input[id='postform-name']")
    private WebElement pastName;

    @FindBy(css = "button[type='submit']")
    private WebElement createNewPasteButton;

    @FindBy(xpath = "//button[text()='AGREE']")
    private WebElement agreeCookiesButton;

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement userName;

    public PasteBinPageModel(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private void fillTextArea(String text) {
        newPasteTextArea.sendKeys(text);
    }

    private void selectPasteExpiration(String pastExpirationValue) {
        pasteExpirtaion.click();
        driver.findElement(By.xpath("//li[text() ='" + pastExpirationValue + "']")).click();
    }

    private void fillPastName(String pastNameValue) {
        pastName.sendKeys(pastNameValue);

    }

    private void agreeCookies() {
        waitForELementToAppear(agreeCookiesButton);
        agreeCookiesButton.click();

    }

    private String getUsername() {
        waitForELementToAppear(userName);
        return userName.getText();
    }
    public void submitForm(String text, String pastExpriationValue, String pastNameValue) {
        //agreeCookies();
        fillTextArea(text);
        selectPasteExpiration(pastExpriationValue);
        fillPastName(pastNameValue);
        createNewPasteButton.submit();
        getUsername();

    }
}
