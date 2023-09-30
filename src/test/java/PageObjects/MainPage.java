package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class MainPage {

    public static boolean registerButtonIsDisplayed;

    WebDriver driver;
    WebDriverWait wait;


    @FindBy(id = "search")
    public WebElement searchInput;
    @FindBy(css = "#search_mini_form .button")
    public WebElement submitButton;

    @FindBy(css = ".breadcrumbs")
    public WebElement breadcrumbs;
    @FindBy(css = ".page-header .mini-account i")
    public static WebElement myAccountIcon;

    @FindBy(css = ".mini-account a.login-btn")
    public WebElement loginButton;
    @FindBy(css = ".mini-account a#noaccount")
    public WebElement registerButton;

    @FindBy(id = "firstname")
    public WebElement firstname;

    @FindBy(id = "lastname")
    public WebElement lastname;

    @FindBy(id = "email_address")
    public WebElement email_address;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "confirmation")
    public WebElement confirmation;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.of(15, ChronoUnit.SECONDS));
        PageFactory.initElements(driver, this);
    }

    public boolean searchInputIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        return searchInput.isDisplayed();
    }

    public boolean myAccountIconIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(myAccountIcon));
        return myAccountIcon.isDisplayed();
    }

    public void searchFor(String items) {

        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(items);
        submitButton.click();
    }

//    public String breadcrumbText() {
//        return breadcrumbs.getText();
//    }

}
