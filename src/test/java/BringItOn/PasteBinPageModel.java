package BringItOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBinPageModel {
    private WebDriver driver;

    @FindBy(css = "textarea[id='postform-text']")
    private WebElement newPasteTextArea;

    @FindBy(xpath = "//span[@data-select2-id='1']")
    private WebElement syntaxHighlighting;

    @FindBy(xpath = "//span[@data-select2-id='3']")
    private WebElement pasteExpirtaion;


    @FindBy(css = "input[id='postform-name']")
    private WebElement pastName;

    @FindBy(css = "button[type='submit']")
    private WebElement createNewPasteButton;

    @FindBy(xpath = "//button[text()='AGREE']")
    private WebElement agreeCookiesButton;

    public PasteBinPageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    private void fillTextArea(String text) {
        newPasteTextArea.sendKeys(text);
    }

    private void selectSyntaxHighlighting(String syntaxHighlightingValue) {
        syntaxHighlighting.click();
        driver.findElement(By.xpath("//li[text() ='" + syntaxHighlightingValue + "']")).click();
    }

    private void selectPasteExpiration(String pastExpirationValue) {
        pasteExpirtaion.click();
        driver.findElement(By.xpath("//li[text() ='" + pastExpirationValue + "']")).click();
    }

    private void fillPastName(String pastNameValue) {
        pastName.sendKeys(pastNameValue);

    }

    private void agreeCookies() {
        new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(agreeCookiesButton)).click();
    }

    public void submitForm(String text, String syntaxHighlightingValue, String pastExpirationValue, String pastNameValue) {
        //agreeCookies();
        fillTextArea(text);
        selectSyntaxHighlighting(syntaxHighlightingValue);
        selectPasteExpiration(pastExpirationValue);
        fillPastName(pastNameValue);
        createNewPasteButton.submit();
       // agreeCookies();


    }
}
