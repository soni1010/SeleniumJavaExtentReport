package org.harender.tests;

import org.harender.base.BasePage;
import org.harender.pages.HomePage;
import org.harender.pages.LoginPage;
import org.harender.utils.ConfigReader;
import org.testng.annotations.Test;

public class TestClass1 extends BasePage {

   @Test
    public void loginTest() {
        String baseUrl = ConfigReader.getProperty("app.url");
        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("username", "password");

        // Add assertions or further test steps
        // Example:
        HomePage homePage = new HomePage(driver);
        // Assert.assertTrue(homePage.isHomePageLoaded(), "Home page not loaded after login");
    }
}
