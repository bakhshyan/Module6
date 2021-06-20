package hurtmeplenty.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchedItemsPageModel {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='gs-title']")
    private WebElement searchIcon;

    public SearchedItemsPageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSearchedResult(String searchItem) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(searchIcon));
        searchIcon.findElement(By.linkText(searchItem)).click();
    }
}
