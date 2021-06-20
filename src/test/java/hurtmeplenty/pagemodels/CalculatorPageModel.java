package hurtmeplenty.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CalculatorPageModel {
    private WebDriver driver;

    @FindBy(xpath = "//iframe[@src='/products/calculator/index_ad8ca20a6d1799e286a0c0839aeb86ca523afe927b04501d8ba77dc59e5b8523.frame']")
    private WebElement firstIframe;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement secondIframe;

    @FindBy(xpath = "//input[@id='input_66']")
    private WebElement numberOfInstanceInput;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_59']/span[@class='md-select-icon']")
    private WebElement operatingSystemSelectIcon;

    @FindBy(xpath = "//md-option[@value='rhel']")
    private WebElement operatingSystemSelect;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_60']/span[@class='md-select-icon']")
    private WebElement machineClassSelectIcon;

    @FindBy(xpath = "//md-option[@id='select_option_80']/div[@class='md-text']")
    private WebElement machineClassSelect;


    @FindBy(xpath = "//md-select-value[@id='select_value_label_63']/span[@class='md-select-icon']")
    private WebElement machineTypeSelectIcon;

    @FindBy(xpath = "//md-option[@id='select_option_242']/div[@class='md-text ng-binding']")
    private WebElement machineTypeSelect;

    @FindBy(xpath = "//input[@id='input_107']")
    private WebElement numberOfNodesInput;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']//div[@class='md-container md-ink-ripple']")
    private WebElement addGPUCheckbox;

    @FindBy(xpath = "//md-select[@id='select_370']")
    private WebElement numberOfGPUSelectIcon;

    @FindBy(xpath = "//md-option[@id='select_option_377']/div[@class='md-text ng-binding']")
    private WebElement numberOfGPUSelect;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement GPUTypeSelectIcon;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']/div[@class='md-text ng-binding']")
    private WebElement GPUTypeSelect;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_104']/span[@class='md-select-icon']")
    private WebElement localSSDSelectIcon;

    @FindBy(xpath = "//md-option[@id='select_option_119']/div[@class='md-text']")
    private WebElement localSSDSelect;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_105']/span[@class='md-select-icon']")
    private WebElement dataCenterLocationSelectIcon;

    @FindBy(xpath = "//md-option[@id='select_option_256']/div[@class='md-text ng-binding']")
    private WebElement dataCenterLocationSelect;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_106']/span[@class='md-select-icon']")
    private WebElement committedUsageSelectIcon;

    @FindBy(xpath = "//md-option[@id='select_option_125']/div[@class='md-text']")
    private WebElement commitedUsageSelect;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimateInstances;

    @FindBy(xpath = "//form[@name='SoleTenantForm']//button[@aria-label='Add to Estimate']")
    private WebElement addToEstimateSoleTenantNodes;

    @FindBy(xpath = "//md-list-item[@ng-if='item.items.editHook && item.items.editHook.initialInputs.class']/div[@class='md-list-item-text ng-binding']")
    private WebElement VMClassValue;

    @FindBy(xpath = "//md-card-content[@id='resultBlock']//md-content[@id='compute']//md-list-item[3]")
    private WebElement instanceType;

    @FindBy(xpath = "//md-card-content[@id='resultBlock']//md-content[@id='compute']//md-list-item[4]")
    private WebElement region;

    @FindBy(xpath = "//md-content[@id='soleTenant']/md-list[@class='cartitem ng-scope']/md-list-item[7]/div")
    private WebElement localSSD;

    @FindBy(xpath = "//md-content[@id='soleTenant']/md-list[@class='cartitem ng-scope']/md-list-item[4]/div")
    private WebElement commitmentTerm;

    public CalculatorPageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void switchToIframes() {
        driver.switchTo().frame(firstIframe);
        driver.switchTo().frame(secondIframe);
    }

    public void fillTheForm(int numberOfInstance, int numberOfNodes) {
        switchToIframes();
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(numberOfInstanceInput)).sendKeys(String.valueOf(numberOfInstance));
        operatingSystemSelectIcon.click();
        operatingSystemSelect.click();
        machineClassSelectIcon.click();
        machineClassSelect.click();
        machineTypeSelectIcon.click();
        machineTypeSelect.click();
        numberOfNodesInput.sendKeys(String.valueOf(numberOfNodes));
        addGPUCheckbox.click();
        numberOfGPUSelectIcon.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(numberOfGPUSelect)).click();
        GPUTypeSelectIcon.click();
        GPUTypeSelect.click();
        localSSDSelectIcon.click();
        localSSDSelect.click();
        dataCenterLocationSelectIcon.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dataCenterLocationSelect);
        dataCenterLocationSelect.click();
        committedUsageSelectIcon.click();
        commitedUsageSelect.click();
        addToEstimateInstances.findElement(By.xpath("./..")).submit();
        addToEstimateSoleTenantNodes.findElement(By.xpath("./..")).submit();

    }

    public String getVMClass() {
        return VMClassValue.getText();
    }

    public String getInstanceType(){
        return instanceType.getText();
    }

    public String getRegion() {
        return region.getText();
    }

    public String getLocalSSD() {
        return localSSD.getText();
    }

    public String getCommitmnetTerm() {
        return commitmentTerm.getText();
    }


}
