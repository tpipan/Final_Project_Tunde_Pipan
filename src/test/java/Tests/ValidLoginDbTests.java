package Tests;

import ObjectModel.NegativeLoginModel;
import ObjectModel.ValidLoginModel;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.MyAccountPage;
import Utils.Tools;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;


public class ValidLoginDbTests extends BaseTest {

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
        ResultSet resultSet = statement.executeQuery("SELECT * FROM negative_login.login_valid;");
        while (resultSet.next()) {
            ValidLoginModel lm = new ValidLoginModel(
                    getEscapedElement(resultSet, "emailAddress"),
                    getEscapedElement(resultSet, "password")
            );

            dp.add(new Object[]{lm});
        }
        return dp.iterator();
    }

    @Test(dataProvider = "mysql")
    public void loginWithSQLAsDataSource (ValidLoginModel lm) throws InterruptedException {
        loginLm(lm);
    }

    //   login with loginModel
    private void loginLm(ValidLoginModel lm) throws InterruptedException {
        System.out.println(lm);
        login(lm.getAccount().getEmailAddress(), lm.getAccount().getPassword());
    }

    private void login(String emailAddress, String password) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(emailAddress, password);
        TimeUnit.SECONDS.sleep(1);

        MyAccountPage myAccountPage = new MyAccountPage(driver);

        Assert.assertEquals(myAccountPage.welcomeMessage.getText(), "BUNĂ, TUNDE PIPAN!");
    }

    private String getEscapedElement(ResultSet resultSet, String element) throws SQLException {
        return Tools.replaceElements(resultSet.getString(element), "''", "");
    }
}
