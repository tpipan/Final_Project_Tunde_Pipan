package Tests;

import PageObjects.MainPage;
import PageObjects.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WishlistTest extends BaseTest {

    @Test
    public void Wishlist() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.searchInputIsDisplayed());
        mainPage.searchFor("pantaloni");

        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(searchPage.resultsAreDisplayed());
        searchPage.wishlistButton.click();
        TimeUnit.SECONDS.sleep(1);
        Assert.assertEquals(searchPage.wishlistAuthenticationText.getText(), "Pentru a putea adauga produse in lista de dorinte, te rog sa te autentifici.");

    }
}


