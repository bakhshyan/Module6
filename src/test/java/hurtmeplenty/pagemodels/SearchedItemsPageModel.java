package hurtmeplenty.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchedItemsPageModel extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='gs-title']")
    private WebElement searchIcon;

    public SearchedItemsPageModel(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickSearchedResult(String searchItem) {
        waitForELementToAppear(searchIcon);
        searchIcon.findElement(By.linkText(searchItem)).click();
    }
}
