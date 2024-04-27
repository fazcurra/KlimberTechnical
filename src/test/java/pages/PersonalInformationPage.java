package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInformationPage extends BasePage {

    @FindBy(id = "txtHeight")
    private WebElement inputHeight;

    @FindBy(id = "txtWeight")
    private WebElement inputWeight;

    @FindBy(id = "btnSaveStep2")
    private WebElement buttonNext;

    public PersonalInformationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public void fillHeightInput(String height) {
        inputHeight.sendKeys(height);
    }

    public void fillWeightInput(String weight) {
        inputWeight.sendKeys(weight);
    }

    public RegistrationPage clickNextButton() {
        buttonNext.click();
        return new RegistrationPage(driver);
    }

}
