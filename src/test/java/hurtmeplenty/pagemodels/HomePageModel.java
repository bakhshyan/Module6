package hurtmeplenty.pagemodels;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageModel extends BasePage {
    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchIcon;

    public HomePageModel(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private void clickSearchIcon() {
        searchIcon.click();
    }

    private void typeItemToSearchInput(String searchText) {
        searchIcon.sendKeys(searchText);
    }

    private WebElement getSearchInputElement() {
        return searchIcon;
    }

    public void searchItem(String searchText) {
        clickSearchIcon();
        typeItemToSearchInput(searchText);
        getSearchInputElement().sendKeys(Keys.ENTER);
    }


}

