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

    String machineClassValue = "regular";
    String machineTypeValue = "e2-standard-2";
    String localSSDValue = "24x375";
    String dataCenterLocationValue = "Iowa";
    String commitmentUsageValue = "3 Years";

    @BeforeTest(alwaysRun = true)
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
        calculatorPageModel.fillTheForm(10,
                "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS",
                machineClassValue,
                machineTypeValue,
                "0",
                "NVIDIA Tesla V100",
                localSSDValue,
                dataCenterLocationValue,
                commitmentUsageValue,
                1);

    }

//    @AfterTest(alwaysRun = true)
//    public void tearDown() {
//        driver.quit();
//    }

}
