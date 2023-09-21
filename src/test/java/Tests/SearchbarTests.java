package Tests;

import PageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchbarTests extends BaseTest{
    MainPage mainPage;
    @Test
    public void searchFunctionalityTest() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.searchInputIsDisplayed());
        mainPage.searchFor("pantaloni bebe");

        Assert.assertEquals(mainPage.breadcrumbs.getText(), "Pagina Principală\n" + "/\n" + "Rezultate căutare pentru: 'pantaloni bebe'");

    }

}
