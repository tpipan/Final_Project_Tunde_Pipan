package ObjectModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegisterModel {
    private AccountModel account;
    private String emailError;

    private String invalidEmailError;


//    public RegisterModel(String firstName, String lastName, String emailAddress, String password, String confirmPassword, String emailError) {
//        AccountModel accountM = new AccountModel();
//        accountM.setFirstName(firstName);
//        accountM.setLastName(lastName);
//        accountM.setEmailAddress(emailAddress);
//        accountM.setPassword(password);
//        accountM.setConfirmPassword(confirmPassword);
//
//        this.account = accountM;
//        this.emailError = emailError;
//    }

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

