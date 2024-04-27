package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdditionalInformationPage extends BasePage {

    @FindBy(xpath = "//div[@class='form-group title']")
    private WebElement title;

    @FindBy(xpath = "//span[@class='select2-selection__rendered'][1]")
    private WebElement nationalitySelector;

    @FindBy(xpath = "//li[@class='select2-results__option' and contains(text(), 'Brasil')]")
    private WebElement argentinaOption;

    @FindBy(id = "PlaceOfBirth")
    private WebElement inputPlaceOfBirth;

    @FindBy(id = "txtOccupation")
    private WebElement inputOccupation;

    @FindBy(id = "txtSalaryAnual")
    private WebElement inputSalaryAnnual;

    @FindBy(xpath = "//input[@id='txtFullName']")
    private WebElement inputFullName;

    @FindBy(xpath = "//input[@id='txtNumberId']")
    private WebElement inputNumberId;

    @FindBy(xpath = "//span[@id='select2-txtAnnualIncome-container']")
    private WebElement incomeSelector;

    @FindBy(xpath = "//li[@class='select2-results__option'][2]")
    private WebElement incomeOption;

    @FindBy(id = "btnSaveInfo")
    private WebElement buttonNext;

    public AdditionalInformationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public void clickNationalitySelector() {
        nationalitySelector.click();
    }

    public void clickArgentinaOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(argentinaOption));
        argentinaOption.click();
    }

    public void fillPlaceOfBirthInput(String placeOfBirth) {
        inputPlaceOfBirth.sendKeys(placeOfBirth);
    }

    public void fillOccupationInput(String occupation) {
        inputOccupation.sendKeys(occupation);
    }

    public void fillAnnualSalaryInput(String annualSalary) {
        inputSalaryAnnual.sendKeys(annualSalary);
    }

    public void clickAnnualIncomeSelector() {
        incomeSelector.click();
    }

    public void clickIncomeOption() {
        incomeOption.click();
    }

    public void fillFullNameInput(String fullName) {
        inputFullName.sendKeys(fullName);
    }

    public void fillNumberIdInput(String numberId) {
        inputNumberId.sendKeys(numberId);
    }

    public PaymentPage clickNextButton() {
        buttonNext.click();
        return new PaymentPage(driver);
    }

}