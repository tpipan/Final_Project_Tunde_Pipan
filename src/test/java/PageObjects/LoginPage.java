package PageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "email")
    public WebElement emailInput;
    @FindBy(id = "pass")
    public WebElement passwordInput;

    @FindBy(css = "button[title='Logare']")
    public WebElement loginButton;

    @FindBy(id = "advice-required-entry-email")
    public WebElement emailError;

    @FindBy(id = "advice-required-entry-pass")
    public WebElement passwordError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.of(15, ChronoUnit.SECONDS));
        PageFactory.initElements(driver, this);
    }




    public void login(String emailAddress, String pass) {
        emailInput.clear();
        emailInput.sendKeys(emailAddress);
        passwordInput.clear();
        passwordInput.sendKeys(pass);
        loginButton.click();
    }

    public String getPassErr() {
        try {
            return passwordError.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String geUsernameErr() {
        try {
            return emailError.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

}
