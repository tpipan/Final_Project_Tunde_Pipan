package ObjectModel;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ValidLoginModel {
    private AccountModel account;


    public ValidLoginModel(String emailAddress, String password) {
        AccountModel accountM = new AccountModel();
        accountM.setPassword(password);
        accountM.setEmailAddress(emailAddress);

        this.account = accountM;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "account={username:" + account.getEmailAddress() + ",password:" + account.getPassword() + "} }";
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }

}

