package bringiton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
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

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();

    }
}
