package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BeneficiaryPage extends BasePage {

    @FindBy(xpath = "//div[@class='form-group title']")
    private WebElement title;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement nextButton;


    public BeneficiaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public SummaryPage clickNextButton() {
        nextButton.click();
        return new SummaryPage(driver);
    }
}
