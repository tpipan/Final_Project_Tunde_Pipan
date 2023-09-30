package Tests;

import ObjectModel.RegisterModel;
import PageObjects.MainPage;
import PageObjects.RegisterPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class RegisterNegativeJsonTest extends BaseTest {


    @DataProvider(name = "jsonDp")
    public Iterator<Object[]> jsonDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src\\test\\resources\\Data\\testdata.json");

        RegisterModel[] lms = objectMapper.readValue(file, RegisterModel[].class);

        for (RegisterModel lm : lms)
            dp.add(new Object[]{lm});
        System.out.println(dp);

        return dp.iterator();
    }

    @Test(dataProvider = "jsonDp")
    public void registerWithJsonAsDataSource(RegisterModel lm) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.myAccountIconIsDisplayed();
        mainPage.myAccountIcon.click();
        mainPage.registerButton.isDisplayed();
        mainPage.registerButton.click();
        System.out.println(lm);

        mainPage.firstname.sendKeys(lm.getAccount().getFirstName());
        mainPage.lastname.sendKeys(lm.getAccount().getLastName());
        mainPage.email_address.sendKeys(lm.getAccount().getEmailAddress());
        mainPage.password.sendKeys(lm.getAccount().getPassword());
        mainPage.confirmation.sendKeys(lm.getAccount().getConfirmPassword());

//        RegisterPage registerPage = new RegisterPage();
//        TimeUnit.SECONDS.sleep(1);
//        registerPage.newsletterCheckbox.click();
//        registerPage.gdpr.click();
//        registerPage.createAccount.click();


//        System.out.println("Account + " + lm.getAccount());
//        System.out.println("Email + " + lm.getAccount().getEmailAddress());

    }




}
