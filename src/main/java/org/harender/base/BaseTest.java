package org.harender.base;

import org.harender.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver
        driver = WebDriverFactory.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        // Quit WebDriver
        if (driver != null) {
            driver.quit();
        }
    }
}
