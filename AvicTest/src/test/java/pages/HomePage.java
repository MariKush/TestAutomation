package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ENTER;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@class='sidebar-item']")
    private WebElement catalogueProductButton;

    @FindBy(xpath = "//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'apple-store')]")
    private WebElement appleStoreButton;

    @FindBy(xpath = "//div[@class='top-links__left flex-wrap']//div[@class='top-links__box'][1]/a")
    private WebElement airPodsButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(String keyword) {
        searchInput.sendKeys(keyword, ENTER);
    }

    public void clickCatalogueButton() {
        catalogueProductButton.click();
    }

    public void clickAppleStoreButton() {
        appleStoreButton.click();
    }

    public void clickAirPodsButton() {
        airPodsButton.click();
    }


}
