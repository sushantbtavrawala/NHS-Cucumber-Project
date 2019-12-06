package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class BrowserFactory extends BrowserConstants {
    protected static WebDriver apply() {
        String browser = System.getProperty("browser");
        int chosenBrowser;
        if (browser == null) { chosenBrowser = HEADLESSCHROME; } else {
            chosenBrowser = convert(browser);
        }
        String os = System.getProperty("os.name").substring(0,3).toLowerCase();
        switch (chosenBrowser) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/main/java/utils/drivers/" + os + "/geckodriver");
                return new FirefoxDriver();
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/main/java/utils/drivers/" + os + "/chromedriver");
                return new ChromeDriver();
            case HEADLESSCHROME:
                System.setProperty("webdriver.chrome.driver", "src/main/java/utils/drivers/" + os + "/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                return new ChromeDriver(chromeOptions);
            case HTMLUNIT:
                return new HtmlUnitDriver();
            default:
                System.setProperty("webdriver.chrome.driver", "src/main/java/utils/drivers/" + os + "/chromedriver");
                return new ChromeDriver();
        }
    }
}
