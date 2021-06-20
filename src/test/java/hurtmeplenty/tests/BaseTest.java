package hurtmeplenty.tests;

import hurtmeplenty.pagemodels.CalculatorPageModel;
import hurtmeplenty.pagemodels.HomePageModel;
import hurtmeplenty.pagemodels.SearchedItemsPageModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BaseTest {
    public WebDriver driver;
    public HomePageModel homePageModel;
    public SearchedItemsPageModel searchedItemsPageModel;
    public CalculatorPageModel calculatorPageModel;

    @BeforeSuite(alwaysRun = true)
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();
        homePageModel = new HomePageModel(driver);
        searchedItemsPageModel = new SearchedItemsPageModel(driver);
        calculatorPageModel = new CalculatorPageModel(driver);
        String searchText = "Google Cloud Platform Pricing Calculator";
        homePageModel.searchItem(searchText);
        searchedItemsPageModel.clickSearchedResult(searchText);
        calculatorPageModel.fillTheForm(10, 1);


    }


    @Test
    public void testVMClassValue() {
        Assert.assertEquals(calculatorPageModel.getVMClass(), "VM class: regular", "VM class value is incorrect");
    }

    @Test
    public void testInstanceType() {
        Assert.assertEquals(calculatorPageModel.getInstanceType(), "Instance type: e2-standard-2", "Instance type is incorrect");
    }

    @Test
    public void testLocalSSDSpace() {
        Assert.assertEquals(calculatorPageModel.getLocalSSD(), "Total available local SSD space 24x375 GiB", "Local SSD space is incorrect");
    }

    @Test
    public void testRegion() {
        Assert.assertEquals(calculatorPageModel.getRegion(), "Region: Iowa", "Region is incorrect");
    }

    @Test
    public void testCommitmentTerm() {
        Assert.assertEquals(calculatorPageModel.getCommitmnetTerm(), "Commitment term: 1 Year", "Commitment term year is incorrect");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }


}
