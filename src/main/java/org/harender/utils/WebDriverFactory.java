package org.harender.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    private static WebDriver driver;

    private WebDriverFactory() {
        // private constructor to prevent instantiation
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    private static void initializeDriver() {
        String browser = ConfigReader.getProperty("browser");

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "ie":
            case "internetexplorer":
                System.setProperty("webdriver.ie.driver", "path/to/IEDriverServer");
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser specified in config.properties");
        }

        // Set additional WebDriver configurations as needed
        driver.manage().window().maximize();  // Replace implicitlyWait with setScriptTimeout
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

    }

}
