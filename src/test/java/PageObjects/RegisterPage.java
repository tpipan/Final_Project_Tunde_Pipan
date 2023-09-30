package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {

    @FindBy(id = "is_subscribed")
    public WebElement newsletterCheckbox;

    @FindBy(id = "gdpr-conditions-0")
    public WebElement gdpr;

    @FindBy(css="button[title='Creează un cont']")
    public  WebElement createAccount;



}
