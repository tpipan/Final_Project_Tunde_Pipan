package Tests;

import ObjectModel.RegisterModel;
import PageObjects.MainPage;
import PageObjects.RegisterPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
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

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.firstname.sendKeys(lm.getAccount().getFirstName());
        registerPage.lastname.sendKeys(lm.getAccount().getLastName());
        registerPage.email_address.sendKeys(lm.getAccount().getEmailAddress());
        registerPage.password.sendKeys(lm.getAccount().getPassword());
        registerPage.confirmation.sendKeys(lm.getAccount().getConfirmPassword());
        registerPage.confirmationButton.click();

        TimeUnit.SECONDS.sleep(1);


        Assert.assertEquals(registerPage.getEmailError(), lm.getEmailError());
        Assert.assertEquals(registerPage.getInvalidEmailError(), lm.getInvalidEmailError());
    }
}
