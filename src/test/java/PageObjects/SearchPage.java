package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".main-content .note-msg")
    public WebElement noResults;

    @FindBy(css = ".products-grid li.item:first-of-type .product-box .product-name a")
    public WebElement firstSearchElement;

    @FindBy(css = ".products-grid li.item:first-of-type a.link-wishlist")
    public WebElement wishlistButton;

    @FindBy(css = ".ajaxcart-modal-dialog .ajaxcart-modal-body h4")
    public WebElement wishlistAuthenticationText;

    @FindAll(
            @FindBy(css = ".products-grid li")
    )
    public List<WebElement> products;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.of(15, ChronoUnit.SECONDS));
        PageFactory.initElements(driver, this);
    }

    public Boolean resultsAreDisplayed() {
        return products.size() > 0;
    }

}
