package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HeaderComponent extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'js_cart_count')]")
    private WebElement amountOfProductsInCart;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public String getAmountOfProductsInCart() {
        return amountOfProductsInCart.getText();
    }

    public WebElement getAmountOfProductsInCartElement() {
        return amountOfProductsInCart;
    }


}
