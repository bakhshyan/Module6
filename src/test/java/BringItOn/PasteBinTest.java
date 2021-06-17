package BringItOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PasteBinTest {
    public WebDriver driver;
    public PasteBinPageModel pasteBinPageModel;
    public String text= "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force" ;
    public String pastNameValue = "Hayk";
    public String syntaxHighlightingValue = "Bash";

    @BeforeTest(alwaysRun = true)
    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        driver.manage().window().maximize();

        pasteBinPageModel = new PasteBinPageModel(driver);
        pasteBinPageModel.submitForm(text,syntaxHighlightingValue,"10 Minutes", pastNameValue);
        Thread.sleep(10000);
    }

//    @Test
//    public void submitForm() throws InterruptedException {
//        pasteBinPageModel = new PasteBinPageModel(driver);
//        pasteBinPageModel.submitForm(text,"Bash","10 Minutes", "Hayk");
//        Thread.sleep(10000);
//        System.out.println(driver.getTitle());
//
//    }

//    @AfterTest(alwaysRun = true)
//    public void tearDown() {
//        driver.quit();
//
//    }
}
