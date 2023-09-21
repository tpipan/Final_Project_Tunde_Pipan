package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BrowserUtils {
    static WebDriver driver;
    static WebDriverWait wait;

    public static WebDriver getBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case ("chrome"): {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = getChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                return driver;
            }
            case ("firefox"): {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                return driver;
            }
            case ("edge"): {
                WebDriverManager.edgedriver().setup();
//                driver = new EdgeDriver(getEdgeOptions());
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                return driver;
            }
            default: {
                System.out.println("Driver is not supported.");
                return null;
            }
        }
    }


    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("incognito");
        return chromeOptions;
    }

    static void WaitFor(int seconds) {
        wait = new WebDriverWait(driver, Duration.of(seconds, ChronoUnit.SECONDS));
    }
}