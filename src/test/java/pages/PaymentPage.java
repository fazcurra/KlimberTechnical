package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {

    @FindBy(xpath = "//div[@class='form-group title']")
    private WebElement title;

    @FindBy(xpath = "//input[@id='CardNumber']")
    private WebElement inputCardNumber;

    @FindBy(id = "btnSubmitStep4")
    private WebElement buttonNext;

    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public void fillCardNumber(String cardNumber) {
        inputCardNumber.sendKeys(cardNumber);
    }

    public BeneficiaryPage clickNextButton() {
        buttonNext.click();
        return new BeneficiaryPage(driver);
    }

}
