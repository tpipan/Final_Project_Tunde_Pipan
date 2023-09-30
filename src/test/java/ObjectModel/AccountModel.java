package ObjectModel;
import javax.xml.bind.annotation.XmlElement;



public class AccountModel {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String confirmPassword;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

//    @Override
//    public String toString() {
//        return "AccountModel{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", emailAddress='" + emailAddress + '\'' +
//                ", password='" + password + '\'' +
//                ", confirmPassword='" + confirmPassword + '\'' +
//                '}';
//    }
}
