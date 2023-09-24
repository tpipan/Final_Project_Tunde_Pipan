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

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".page-title.product-name h1")
    public WebElement productTitle;

    @FindBy(id = "product-addtocart-button")
    public WebElement addToCartButton;

    @FindBy(css = "#configurable_swatch_marime li:first-of-type")
    public WebElement selectSizeButton;

    @FindBy(css = ".ajaxcart-modal-dialog .btn-checkout")
    public WebElement navigateToCartButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.of(15, ChronoUnit.SECONDS));
        PageFactory.initElements(driver, this);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

}
