package PageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "is_subscribed")
    public WebElement newsletterCheckbox;

    @FindBy(id = "gdpr-conditions-0")
    public WebElement gdpr;

    @FindBy(css="button[title='Creează un cont']")
    public  WebElement createAccount;

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

    @FindBy(css = "button[title='Creează un cont']")
    public WebElement confirmationButton;


    @FindBy(id = "advice-required-entry-email_address")
    public WebElement emailError;

    @FindBy(id = "advice-validate-email-email_address")
    public WebElement emailInvalidError;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.of(15, ChronoUnit.SECONDS));
        PageFactory.initElements(driver, this);
    }

    public String getEmailError() {
        try {
            return emailError.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String getInvalidEmailError() {
        try {
            return emailInvalidError.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

}
