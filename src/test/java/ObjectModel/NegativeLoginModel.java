package ObjectModel;

import javax.xml.bind.annotation.XmlRootElement;


    @XmlRootElement
    public class NegativeLoginModel {

        private AccountModel account;
        private String emailAddressErr;
        private String passwordErr;


        public NegativeLoginModel(String emailAddress, String password, String emailAdressErr, String passwordErr) {
            AccountModel accountM = new AccountModel();
            accountM.setPassword(password);
            accountM.setEmailAddress(emailAddress);

            this.account = accountM;
            this.emailAddressErr = emailAdressErr;
            this.passwordErr = passwordErr;
        }

        @Override
        public String toString() {
            return "LoginData{" +
                    "account={username:" + account.getEmailAddress() + ",password:" + account.getPassword() +
                    "}, emailAddressErr='" + emailAddressErr + '\'' +
                    ", passwordError='" + passwordErr + '\'' +
                    '}';
        }

        public AccountModel getAccount() {
            return account;
        }

        public void setAccount(AccountModel account) {
            this.account = account;
        }

        public String getEmailAddressErr() {
            return emailAddressErr;
        }

        public void setEmailAddressErr(String emailAddressError) {
            this.emailAddressErr = emailAddressError;
        }

        public String getPasswordErr() {
            return passwordErr;
        }

        public void setPasswordErr(String passwordError) {
            this.passwordErr = passwordError;
        }
    }

