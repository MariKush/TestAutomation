package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    private static final String SEARCH_RESULT = "query=iPhone";
    private static final String SEARCH_KEYWORD = "iPhone 11";
    private static final int EXPECTED_PRODUCTS_AMOUNT = 12;

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        assertTrue(getDriver().getCurrentUrl().contains(SEARCH_RESULT));
    }


    @Test(priority = 2)
    public void checkElementsAmountOnSearchPage() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getBasePage().implicitlyWait(30);
        int actualElementsSize = getSearchResultPage().getSearchResultsList().size();
        assertEquals(actualElementsSize, EXPECTED_PRODUCTS_AMOUNT);
    }

    @Test(priority = 3)
    public void checkThatSearchResultsContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        for (WebElement webElement : getSearchResultPage().getSearchResultsList()) {
            assertTrue(webElement.getText().contains(SEARCH_KEYWORD));
        }
    }
}
