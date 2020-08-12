package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class AirPodsPage extends BasePage{

    @FindBy(xpath = "//input[@class='form-control form-control-max']")
    private WebElement maxPriceField;

    @FindBy(xpath = "//div[contains(@class,'form-group')]//span[@class='filter-tooltip-inner']")
    private WebElement showResultOfFilteringTooltip;

    @FindBy(xpath = "//div[@class='prod-cart__prise-new']")
    private List<WebElement> elementPrisesList;

    @FindBy(xpath = "//a[contains(@class,'prod-cart__buy')]")
    private List<WebElement> addToCartButtonsList;

    public AirPodsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getShowResultOfFilteringTooltip(){
        return showResultOfFilteringTooltip;
    }

    public void enterValueIntoMaxPriceField(String maxPrice){
        maxPriceField.clear();
        maxPriceField.sendKeys("value", maxPrice);
        maxPriceField.sendKeys(ENTER);
    }

    public void clickOnShowResultOfFilteringTooltip(){
        showResultOfFilteringTooltip.click();
    }

    public List<WebElement> getElementPrisesList(){
        return elementPrisesList;
    }

    public List<WebElement> getAddToCartButtonsList() {
        return addToCartButtonsList;
    }


}
