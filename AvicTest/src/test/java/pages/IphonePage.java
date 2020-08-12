package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IphonePage extends BasePage {

    @FindBy(xpath = "//a[@class='prod-cart__buy'][contains(@data-ecomm-cart,'White (MWL82)')]")
    private WebElement addToCartButton;

    public IphonePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

}
