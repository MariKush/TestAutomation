package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FilterTest extends BaseTest{

    private static final int MAX_PRICE = 1000;

    @Test
    public void checkFilterForPrice() {
        getHomePage().clickAirPodsButton();

        getAirPodsPage().enterValueIntoMaxPriceField(String.valueOf(MAX_PRICE));

        getBasePage().waitForElementVisibility(5, getAirPodsPage().getShowResultOfFilteringTooltip());

        getAirPodsPage().clickOnShowResultOfFilteringTooltip();

        for (WebElement webElement : getAirPodsPage().getElementPrisesList()) {
            assertTrue(Integer.parseInt(webElement.getText().replaceAll("[^\\d.]", "")) < MAX_PRICE);
        }
    }
}
