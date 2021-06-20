package icanwin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
    private WebDriver driver;
    private PasteBinPageModel pasteBinPageModel;

    @BeforeTest(alwaysRun = true)
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void submitForm() {
        pasteBinPageModel = new PasteBinPageModel(driver);
        pasteBinPageModel.submitForm("test", "10 Minutes", "Hayk");
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();

    }
}
