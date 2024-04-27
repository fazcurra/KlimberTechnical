package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import pages.PricingPage;

public class BaseTest {

    public static WebDriver driver;
    public static Actions actions;
    public static PricingPage page;
    public static String url = "https://purchase-testing.klimber.com/ar/GroupLife/Index";

    public static WebDriverWait shortWait;
    public static WebDriverWait longWait;

    @BeforeMethod
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("src/main/resources/chrome-win64/chrome.exe");
        System.setProperty("org.testng.test.timeout", "600");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterTest
    public void afterClass() {
        driver.quit();
    }

}