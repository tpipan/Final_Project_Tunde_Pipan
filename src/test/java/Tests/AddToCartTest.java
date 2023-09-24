package Tests;

import PageObjects.CartPage;
import PageObjects.MainPage;
import PageObjects.ProductPage;
import PageObjects.SearchPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddToCartTest extends BaseTest {
    MainPage mainPage;
    @Test
    public void addToCartTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.searchInputIsDisplayed());
        mainPage.searchFor("body");

        SearchPage searchPage = new SearchPage(driver);
        String productTitle = searchPage.firstSearchElement.getText();

        Assert.assertTrue(searchPage.resultsAreDisplayed());

        searchPage.firstSearchElement.click();

        ProductPage productPage = new ProductPage(driver);

        // verificam daca titlul produsului din lista de produse este acelasi cu titlul produsului din pagina lui
        Assert.assertEquals(productPage.getProductTitle(), productTitle);

        productPage.selectSizeButton.click();
        productPage.addToCartButton.click();
        TimeUnit.SECONDS.sleep(1);
        productPage.navigateToCartButton.click();


        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.firstProductTitle.getText(), productTitle);
        Assert.assertEquals(cartPage.getFirstItemQuantity(), "1");
    }

    @Test
    public void removeFromCartTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.searchInputIsDisplayed());
        mainPage.searchFor("body");

        SearchPage searchPage = new SearchPage(driver);
        String productTitle = searchPage.firstSearchElement.getText();

        Assert.assertTrue(searchPage.resultsAreDisplayed());

        searchPage.firstSearchElement.click();

        ProductPage productPage = new ProductPage(driver);

        Assert.assertEquals(productPage.getProductTitle(), productTitle);

        productPage.selectSizeButton.click();
        productPage.addToCartButton.click();
        TimeUnit.SECONDS.sleep(1);
        productPage.navigateToCartButton.click();


        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.firstProductTitle.getText(), productTitle);
        Assert.assertEquals(cartPage.getFirstItemQuantity(), "1");

        cartPage.firstProductRemoveButton.click();


        TimeUnit.SECONDS.sleep(1);
        Assert.assertTrue(cartPage.itemHasBeenRemoved());

    }

}
