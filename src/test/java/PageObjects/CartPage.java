package PageObjects;

import org.apache.xpath.operations.Bool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "#shopping-cart-table tr:first-of-type td.col-name h2.product-name")
    public WebElement firstProductTitle;

    @FindBy(css = "#shopping-cart-table tr:first-of-type + tr td.col-qty input")
    public WebElement firstProductQuantity;

    @FindBy(css = "#shopping-cart-table tr:first-of-type td.col-actions a.btn-remove")
    public WebElement firstProductRemoveButton;

    @FindBy(css = ".ajaxcart-modal-dialog .ajaxcart-modal-messages li")
    public WebElement itemRemoved;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.of(15, ChronoUnit.SECONDS));
        PageFactory.initElements(driver, this);
    }

    public String getFirstItemQuantity() {
        return firstProductQuantity.getAttribute("value");
    }

    public Boolean itemHasBeenRemoved() {
        return itemRemoved.getText().equals("Articol eliminat cu succes.");
    }

}
