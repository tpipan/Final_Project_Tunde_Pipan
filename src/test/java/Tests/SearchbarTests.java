package Tests;

import PageObjects.MainPage;
import PageObjects.SearchPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchbarTests extends BaseTest {
    MainPage mainPage;
    @Test
    public void searchFunctionalityTest() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.searchInputIsDisplayed());
        mainPage.searchFor("pantaloni bebe");

        Assert.assertEquals(mainPage.breadcrumbs.getText(),
                "Pagina Principală\n" +
                "/\n" +
                "Rezultate căutare pentru: 'pantaloni bebe'"
        );

    }

    @Test
    public void invalidSearchFunctionalityTest() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.searchInputIsDisplayed());
        mainPage.searchFor("wtfgj");

        SearchPage searchPage = new SearchPage(driver);
        Assert.assertEquals(searchPage.noResults.getText(), "Căutarea dvs. nu a returnat niciun rezultat.");
    }

}
