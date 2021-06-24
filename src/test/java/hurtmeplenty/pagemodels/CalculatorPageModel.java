package hurtmeplenty.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CalculatorPageModel {
    private WebDriver driver;

    @FindBy(xpath = "//article[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement firstIframe;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement secondIframe;

    @FindBy(xpath = "//label[contains(text(),'Number of instances')]/following-sibling::input")
    private WebElement numberOfInstanceInput;

    @FindBy(xpath = "//label[contains(text(),'Operating System / Software')]/following-sibling::md-select//span[@class='md-select-icon']")
    private WebElement operatingSystemSelectIcon;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement machineClassSelectIcon;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineTypeSelectIcon;

    @FindBy(name = "nodesCount")
    private WebElement numberOfNodesInput;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']//div[@class='md-container md-ink-ripple']")
    private WebElement addGPUCheckbox;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUSelectIcon;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement GPUTypeSelectIcon;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSDSelectIcon;

    @FindBy(xpath = "(//md-select[@placeholder='Datacenter location'])[2]")
    private WebElement dataCenterLocationSelectIcon;

    @FindBy(xpath = "(//md-select[@placeholder='Committed usage'])[2]")
    private WebElement committedUsageSelectIcon;

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

    @FindBy(xpath = "//md-content[@id='soleTenant']/md-list[@class='cartitem ng-scope']//div[contains(text(),'local SSD')]")
    private WebElement localSSD;

    @FindBy(xpath = "//md-content[@id='soleTenant']/md-list[@class='cartitem ng-scope']/md-list-item[4]/div")
    private WebElement commitmentTerm;

    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//form[@name='emailForm']//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//h2[@class='md-title']/b[@class='ng-binding']")
    private WebElement totalAmount;

    private String operatingSystemSelect = "//md-option[@class='md-ink-ripple']/div[contains(text(),'%s')]";
    private String machineClassSelect = "(//md-option[@value='%s'])[2]";
    private String machineTypeSelect = "//md-option[@ng-repeat='instance in typeInfo']/div[contains(text(),'%s')]";
    private String numberOfGPUSelect = "//md-option[@ng-value='item.value']/div[@class='md-text ng-binding' and text()=%s]";
    private String GPUTypeSelect = "//md-option[@ng-value='item.value']/div[contains(text(),'%s')]";
    private String localSSDSelect = "//div[contains(text(),'%s')]";
    private String dataCenterLocationSelect = "(//md-option[@ng-value='item.value']/div[contains(text(),'%s')])[3]";
    private String commitedUsageSelect = "(//div[text()='%s'])[2]";


    public CalculatorPageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void switchToIframes() {
        driver.switchTo().frame(firstIframe);
        driver.switchTo().frame(secondIframe);
    }

    public void fillTheForm(int numberOfInstance, String operatingSystemValue, String machineClassValue,
                            String machineTypeValue, String numberOfGPUValue, String GPUTypeValue, String localSSDValue,
                            String dataCenterLocationValue, String commitedUsageValue, int numberOfNodes) {
        switchToIframes();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(numberOfInstanceInput)).sendKeys(String.valueOf(numberOfInstance));
        operatingSystemSelectIcon.click();
        driver.findElement(By.xpath(String.format(operatingSystemSelect, operatingSystemValue))).click();
        machineClassSelectIcon.click();
        driver.findElement(By.xpath(String.format(machineClassSelect, machineClassValue))).click();
        machineTypeSelectIcon.click();
        driver.findElement(By.xpath(String.format(machineTypeSelect, machineTypeValue))).click();
        numberOfNodesInput.sendKeys(String.valueOf(numberOfNodes));
        addGPUCheckbox.click();
        numberOfGPUSelectIcon.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(numberOfGPUSelect, numberOfGPUValue))))).click();
        GPUTypeSelectIcon.click();
        driver.findElement(By.xpath(String.format(GPUTypeSelect, GPUTypeValue))).click();
        localSSDSelectIcon.click();
        driver.findElement(By.xpath(String.format(localSSDSelect, localSSDValue))).click();
        dataCenterLocationSelectIcon.click();
        driver.findElement(By.xpath(String.format(dataCenterLocationSelect, dataCenterLocationValue))).click();
        committedUsageSelectIcon.click();
        driver.findElement(By.xpath(String.format(commitedUsageSelect, commitedUsageValue))).click();
        addToEstimateInstances.findElement(By.xpath("./..")).submit();
        addToEstimateSoleTenantNodes.findElement(By.xpath("./..")).submit();

    }

    public String getVMClass() {
        return VMClassValue.getText();
    }

    public String getInstanceType() {
        return instanceType.getText();
    }

    public String getRegion() {
        return region.getText();
    }

    public String getLocalSSD() {
        return localSSD.getText();
    }

    public String getCommitmentTerm() {
        return commitmentTerm.getText();
    }

    public void emailEstimateButtonClick() {
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(emailEstimateButton));
        emailEstimateButton.click();

    }

    public void setEmaiInput(String email) {
        new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(emailInput));
        new WebDriverWait(driver, 40);
        emailInput.sendKeys(email);
    }

    public void sendEmail() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(sendEmailButton));
        sendEmailButton.click();
    }

    public String getTotalAmount() {
        switchToIframes();
        return totalAmount.getText();
    }
}
