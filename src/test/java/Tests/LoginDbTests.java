package Tests;

import ObjectModel.NegativeLoginModel;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.SearchPage;
import Utils.Tools;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;


public class LoginDbTests extends BaseTest {

    @DataProvider(name = "mysql")
    public Iterator<Object[]> mysqlDpCollection() throws Exception {
        System.out.println("Use dbHostname:" + dbHostname);
        System.out.println("Use dbUser:" + dbUser);
        System.out.println("Use dbPort:" + dbPort);
        System.out.println("Use dbSchema:" + dbSchema);

        Collection<Object[]> dp = new ArrayList<>();

        Connection connection = DriverManager.getConnection("jdbc:mysql://" + dbHostname + ":" + dbPort +
                "/" + dbSchema, dbUser, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM negative_login.login_negative;");
        while (resultSet.next()) {
            NegativeLoginModel lm = new NegativeLoginModel(getEscapedElement(resultSet, "emailAddress"),
                    getEscapedElement(resultSet, "password"),
                    getEscapedElement(resultSet, "emailAddressErr"),
                    getEscapedElement(resultSet, "passwordErr"));

            dp.add(new Object[]{lm});
        }
        return dp.iterator();
    }

    @Test(dataProvider = "mysql")
    public void loginWithSQLAsDataSource (NegativeLoginModel lm) {
        loginLm(lm);
    }

    //   login with loginModel
    private void loginLm(NegativeLoginModel lm) {
        System.out.println(lm);
        login(lm.getAccount().getEmailAddress(), lm.getAccount().getPassword(), lm.getEmailAddressErr(), lm.getPasswordErr());
    }

    private void login(String emailAddress, String password, String emailAddressErr, String passwordErr) {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(emailAddress, password);
        Assert.assertEquals(loginPage.geUsernameErr(),emailAddressErr);
        Assert.assertEquals(loginPage.getPassErr(),passwordErr);
    }

    private String getEscapedElement(ResultSet resultSet, String element) throws SQLException {
        return Tools.replaceElements(resultSet.getString(element), "''", "");
    }
}
