package ObjectModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegisterModel {
    private AccountModel account;
    private String emailError;

    private String invalidEmailError;




    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }


    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getInvalidEmailError() {
        return invalidEmailError;
    }


    @Override
    public String toString() {
        return "RegisterData{" +
                "account={firstName:" + account.getFirstName() + ",lastName:" + account.getLastName() +
                ",emailAddress:" + account.getEmailAddress() + ",password:" + account.getPassword() +
                ",confirmPassword:" + account.getConfirmPassword() +
                "}, emailError='" + emailError + '\'' +
                ", invalidEmailError='" + invalidEmailError + '}';
    }
}

