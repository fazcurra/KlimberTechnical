package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//div[@class='title']")
    private WebElement title;

    @FindBy(xpath = "//input[@id='Name']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@id='Surname']")
    private WebElement inputSurname;

    @FindBy(xpath = "//input[@class='form-control dni']")
    private WebElement inputId;

    @FindBy(xpath = "//span[@id='select2-Gender-container']")
    private WebElement sexSelector;

    @FindBy(xpath = "//li[@class='select2-results__option'][2]")//Hardcoded index since id in HTML is dynamic.
    private WebElement maleSexSelection;

    @FindBy(xpath = "//span[@id='select2-IdentificationGenderType-container']")
    private WebElement genderSelector;

    @FindBy(xpath = "//li[@class='select2-results__option'][2]")//Hardcoded index since id in HTML is dynamic.
    private WebElement maleGenderSelection;

    @FindBy(xpath = "//span[@id='select2-CivilStatus-container']")
    private WebElement civilStatusSelector;

    @FindBy(xpath = "//li[@class='select2-results__option'][2]")//Hardcoded index since id in HTML is dynamic.
    private WebElement singleCivilStatusSelection;

    @FindBy(id = "txtEmail")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPassword;

    @FindBy(id = "Street")
    private WebElement inputStreet;

    @FindBy(id = "HouseNumber")
    private WebElement inputHouseNumber;

    @FindBy(id = "zipCode")
    private WebElement inputZipCode;

    @FindBy(xpath = "//button")
    private WebElement buttonNext;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public void fillNameInput(String name) {
        inputName.sendKeys(name);
    }

    public void fillSurnameInput(String surname) {
        inputSurname.sendKeys(surname);
    }

    public void fillIdInput(String id) {
        inputId.sendKeys(id);
    }

    public void clickSexSelector() {
        sexSelector.click();
    }

    public void selectMaleSex() {
        maleSexSelection.click();
    }

    public void clickGenderSelector() {
        genderSelector.click();
    }

    public void selectMaleGender() {
        maleGenderSelection.click();
    }

    public void clickCivilStatusSelector() {
        civilStatusSelector.click();
    }

    public void selectSingleCivilStatus() {
        singleCivilStatusSelection.click();
    }

    public void fillEmailInput(String email) {
        inputEmail.sendKeys(email);
    }


    public void fillPasswordInput(String password) {
        inputPassword.sendKeys(password);
    }

    public void fillStreetInput(String street) {
        inputStreet.sendKeys(street);
    }

    public void fillHouseNumberInput(String houseNumber) {
        inputHouseNumber.sendKeys(houseNumber);
    }

    public void fillZipCodeInput(String zipCode) {
        inputZipCode.sendKeys(zipCode);
    }

    public AdditionalInformationPage clickNextButton() {
        actions.scrollToElement(buttonNext).perform();
        buttonNext.click();
        return new AdditionalInformationPage(driver);
    }

}