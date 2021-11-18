package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import util.WebDriverListener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
     public static WebDriver driver;
    public static EventFiringWebDriver e_driver;
    public  static WebDriverListener webDriverListener;
    public static Properties prop;

    public TestBase() throws IOException {
        prop = new Properties();
        FileInputStream file = new FileInputStream("/home/test/Desktop/frontEndSite/src/main/java/config/config.properities");
        prop.load(file);
    }

    public static void initialization(String browser) throws IOException {
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            driver = new ChromeDriver();

        }
        else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
            driver = new FirefoxDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        webDriverListener = new WebDriverListener();
        e_driver.register(webDriverListener);
        driver = e_driver;

        driver.get(prop.getProperty("URL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

}
