package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CongratulationsPage extends BasePage {

    @FindBy(xpath = "//div[@class='title' and contains(text(),'¡Felicitaciones!')]")
    private WebElement title;

    public CongratulationsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public String getTitle() {
        return title.getText();
    }
}
