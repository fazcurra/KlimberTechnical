package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingPage extends BasePage {

    @FindBy(id = "BirthdayStep1")
    private WebElement birthDate;

    @FindBy(className = "select2-selection__rendered")
    private WebElement provinceSelector;

    @FindBy(xpath = "//li[@class='select2-results__option'][2]")
    private WebElement provinceOption;

    @FindBy(id = "txtPhoneCode")
    private WebElement inputPhoneCode;

    @FindBy(id = "txtPhoneNumber")
    private WebElement inputPhoneNumber;

    @FindBy(xpath = "//div[@class='slider-handle min-slider-handle round']")
    private WebElement sliderPrice;

    @FindBy(id = "chkDisability")
    private WebElement checkBoxDisability;

    @FindBy(id = "chkAccident")
    private WebElement checkBoxAccident;

    @FindBy(id = "chkIllness")
    private WebElement checkBoxIllness;

    @FindBy(xpath = "//span[@class='monthlyPrice']")
    private WebElement monthlyPrice;

    @FindBy(id = "suma_aseguradatotal")
    private WebElement finalPrice;

    @FindBy(id = "btnSaveStep1")
    private WebElement buttonHireInsurance;

    public PricingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public void fillBirthDate(String input) {
        birthDate.sendKeys(input);
    }

    public void clickProvinceSelector() {
        provinceSelector.click();
    }

    public void selectProvince() {
        provinceOption.click();
    }

    public void fillPhoneNumber(String code, String number) {
        inputPhoneCode.sendKeys(code);
        inputPhoneNumber.sendKeys(number);
    }

    public void moveSlider(int xOffset, int yOffset) {
        actions.dragAndDropBy(sliderPrice, xOffset, yOffset).perform();
    }

    public void clickDisabilityCheckBox() {
        checkBoxDisability.click();
    }

    public void clickAccidentCheckBox() {
        checkBoxAccident.click();
    }

    public void clickIllnessCheckBox() {
        checkBoxIllness.click();
    }

    //Clicks the checkbox to refresh the page after changing the slider position.
    public void refreshClick() {
        checkBoxAccident.click();
    }

    //Clicks the price to refresh the page after setting checks.
    public void clickFinalPrice() {
        finalPrice.click();
    }

    public String getMonthlyPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(monthlyPrice));
        return monthlyPrice.getText();
    }

    public PersonalInformationPage clickHireInsuranceButton() {
        buttonHireInsurance.click();
        return new PersonalInformationPage(driver);
    }

}