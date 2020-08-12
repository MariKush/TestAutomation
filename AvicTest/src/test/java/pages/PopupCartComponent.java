package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopupCartComponent extends BasePage {


    @FindBy(id = "js_cart")
    private WebElement cartPopup;


    @FindBy(xpath = "//div[@class='item-total']/span[1]")
    private WebElement totalPayableTitle;

    @FindBy(xpath = "//div[@class='item']//i[contains(@class,'js-btn-close')]")
    private WebElement deleteItemButton;

    @FindBy(xpath = "//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//div[@id='js_cart']//b")
    private WebElement emptyCartLabel;

    @FindBy(xpath = "//div[@class='quantity-h']//span[contains(text(),'+')]")
    private WebElement incrementItemButton;

    @FindBy(xpath = "//div[@class='item']//span[@class='prise']")
    private WebElement pricePerUnitLabel;

    @FindBy(xpath = "//input[contains(@class,'count')]")
    private WebElement countOfUnitsInput;

    @FindBy(xpath = "//div[@class='item-total']//span[@class='prise']")
    private WebElement totalPriceLabel;


    public PopupCartComponent(WebDriver driver) {
        super(driver);
    }

    public void clickOnDeleteItemButton() {
        deleteItemButton.click();
    }

    public String getTotalPayableTitle() {
        return totalPayableTitle.getText();
    }

    public void clickOnContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickOnIncrementItemButton() {
        incrementItemButton.click();
    }

    public WebElement getCartPopup() {
        return cartPopup;
    }

    public WebElement getEmptyCartLabel() {
        return emptyCartLabel;
    }

    public String getPricePerUnitLabel() {
        return pricePerUnitLabel.getText();
    }

    public WebElement getCountOfUnitsInput() {
        return countOfUnitsInput;
    }

    public WebElement getTotalPriceLabel(){
        return totalPriceLabel;
    }

}
