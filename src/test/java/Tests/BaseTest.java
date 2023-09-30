package Tests;


import PageObjects.MainPage;
import Utils.BrowserUtils;
import Utils.ConfigUtils;
import Utils.ConstantUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;
    String baseUrl;
    String dbHostname, dbPort, dbUser, dbPassword, dbSchema;

    @BeforeClass
    public void setUp() {
        baseUrl = ConfigUtils.getGenericElement(ConstantUtils.CONFIG_FILE, "hostname");
        System.out.println("the base " + baseUrl);
        dbHostname = ConfigUtils.getGenericElement(ConstantUtils.CONFIG_FILE, "dbHostname");
        dbPort = ConfigUtils.getGenericElement(ConstantUtils.CONFIG_FILE, "dbPort");
        dbUser = ConfigUtils.getGenericElement(ConstantUtils.CONFIG_FILE, "dbUser");
        dbPassword = ConfigUtils.getGenericElement(ConstantUtils.CONFIG_FILE, "dbPassword");
        dbSchema = ConfigUtils.getGenericElement(ConstantUtils.CONFIG_FILE, "dbSchema");
    }



    public void setUpDriver(String browserName) {
        String browser = browserName;
        if (driver != null)
            driver.quit();
        if (browser.isEmpty())
            browser = ConfigUtils.getGenericElement(ConstantUtils.CONFIG_FILE, "browser");
        System.out.println("Set up webdriver for browser:" + browser);
        driver = BrowserUtils.getBrowser(browser);
    }

    public void goToRegisterPage(){
        MainPage.myAccountIcon.click();
        Assert.assertTrue(MainPage.registerButtonIsDisplayed);

    }

    @BeforeMethod
    public void startBrowser() {
        String browserName = ConfigUtils.getGenericElement(ConstantUtils.CONFIG_FILE, "browser");
        setUpDriver(browserName);
        driver.get(baseUrl);
    }

//    @AfterMethod(alwaysRun = true)
//    public void cleanUp() {
//        if (driver != null)
//            driver.quit();
//    }


}