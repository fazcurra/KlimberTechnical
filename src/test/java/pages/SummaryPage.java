package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage extends BasePage {

    @FindBy(xpath = "//div[@class='title' and contains(text(),'Este es el resumen de tu póliza.')]")
    private WebElement summaryTitle;

    @FindBy(id = "chkTC")
    private WebElement checkboxTermsAndConditions;

    @FindBy(id = "btnSummarySubmit")
    private WebElement nextButton;

    public SummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public String getTitle() {
        return summaryTitle.getText();
    }

    public void clickCheckBoxTermsAndConditions() {
        checkboxTermsAndConditions.click();
    }

    public CongratulationsPage clickNextButton() {
        nextButton.click();
        return new CongratulationsPage(driver);
    }

}
