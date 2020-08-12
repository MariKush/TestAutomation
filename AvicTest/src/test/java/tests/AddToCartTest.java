package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class AddToCartTest extends BaseTest {

    private static final String EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART = "1";
    private static final String TOTAL_PAYABLE_TITLE = "Всего к оплате";
    private static final String CART_IS_EMPTY_LABEL = "Корзина пустая!";

    @Test(priority = 4)
    public void checkAddToCart() {
        getHomePage().clickCatalogueButton();
        getHomePage().clickAppleStoreButton();
        getAppleStorePage().clickIphoneButton();
        getBasePage().waitForPageReadyState(30);
        getIphonePage().clickOnAddToCartButton();
        getBasePage().waitForElementVisibility(30, getPopupCartComponent().getCartPopup());
        getPopupCartComponent().clickOnContinueShoppingButton();

        //I added a scroll up, because without it at my screen size (less than standard) this test fell
        getBasePage().scrollToElement(getHeaderComponent().getAmountOfProductsInCartElement());

        assertEquals(getHeaderComponent().getAmountOfProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART);
    }

    @Test
    public void checkRemovalFromCart() {
        getHomePage().clickCatalogueButton();
        getHomePage().clickAppleStoreButton();
        getBasePage().waitForPageReadyState(30);
        getAppleStorePage().clickIphoneButton();
        getBasePage().waitForPageReadyState(30);
        getIphonePage().clickOnAddToCartButton();
        getBasePage().waitForElementVisibility(30, getPopupCartComponent().getCartPopup());

        assertTrue(getPopupCartComponent().getTotalPayableTitle().contains(TOTAL_PAYABLE_TITLE));

        getPopupCartComponent().clickOnDeleteItemButton();
        getBasePage().waitForElementVisibility(30, getPopupCartComponent().getEmptyCartLabel());

        assertEquals(getPopupCartComponent().getEmptyCartLabel().getText(), CART_IS_EMPTY_LABEL);
    }

    @Test
    public void checkAmountAfterChangingQuantityOfGoods() {
        getHomePage().clickCatalogueButton();
        getHomePage().clickAppleStoreButton();
        getAppleStorePage().clickIphoneButton();
        getBasePage().waitForPageReadyState(30);
        getIphonePage().clickOnAddToCartButton();
        getBasePage().waitForElementVisibility(30, getPopupCartComponent().getCartPopup());
        getPopupCartComponent().clickOnIncrementItemButton();

        String pricePerUnit = getPopupCartComponent().getPricePerUnitLabel().replaceAll("[^\\d.]", "");
        String countOfUnits = getPopupCartComponent().getCountOfUnitsInput().getAttribute("value");
        String expectedPricePerTwoUnits = new BigInteger(pricePerUnit).multiply(new BigInteger(countOfUnits)).toString();

        getBasePage().waitForElementTextBePresented(30, getPopupCartComponent().getTotalPriceLabel(), expectedPricePerTwoUnits);

        String actualPriceForTwoUnits = getPopupCartComponent().getTotalPriceLabel().getText().replaceAll("[^\\d.]", "");

        assertEquals(actualPriceForTwoUnits, expectedPricePerTwoUnits);
    }

    @Test
    public void checkAbilityToAddDifferentItemsToCart() {
        getHomePage().clickAirPodsButton();
        getBasePage().waitForPageReadyState(10);
        List<WebElement> addToCartButtons = getAirPodsPage().getAddToCartButtonsList();
        for (WebElement webElement : addToCartButtons) {
            getBasePage().scrollToElement(webElement);
            webElement.click();
            getBasePage().waitForElementVisibility(30, getPopupCartComponent().getCartPopup());
            getPopupCartComponent().clickOnContinueShoppingButton();
        }

        getBasePage().scrollToElement(getHeaderComponent().getAmountOfProductsInCartElement());

        assertEquals(getHeaderComponent().getAmountOfProductsInCart(), String.valueOf(addToCartButtons.size()));

    }

}
