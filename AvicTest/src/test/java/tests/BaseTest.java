package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;

public class BaseTest {

    private static final String AVIC_URL = "https://avic.ua/";
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public BasePage getBasePage() {
        return new BasePage(driver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(driver);
    }

    public AppleStorePage getAppleStorePage() {
        return new AppleStorePage(driver);
    }

    public IphonePage getIphonePage() {
        return new IphonePage(driver);
    }

    public AirPodsPage getAirPodsPage(){
        return new AirPodsPage(driver);
    }

    public HeaderComponent getHeaderComponent() {
        return new HeaderComponent(driver);
    }

    public PopupCartComponent getPopupCartComponent() {
        return new PopupCartComponent(driver);
    }

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://avic.ua/");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }


}
