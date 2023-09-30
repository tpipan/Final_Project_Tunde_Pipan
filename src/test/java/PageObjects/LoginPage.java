package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "email")
    public WebElement emailInput;
    @FindBy(id = "pass")
    public WebElement passwordInput;

    @FindBy(css = "button.validation-passed")
    public WebElement loginButton;

    @FindBy(id = "advice-validate-email-email")
    public WebElement emailError;

    @FindBy(id = "advice-required-entry-pass")
    public WebElement passwordError;






    public void login(String emailAddress, String pass) {

        emailInput.clear();
        emailInput.sendKeys(emailAddress);
        passwordInput.clear();
        passwordInput.sendKeys(pass);
        loginButton.click();
    }





}
