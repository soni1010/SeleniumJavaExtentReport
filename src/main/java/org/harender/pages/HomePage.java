package org.harender.pages;

import org.harender.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By welcomeMessage = By.id("welcomeMessage");
    private final By logoutButton = By.id("logoutButton");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isWelcomeMessageDisplayed() {
        return driver.findElement(welcomeMessage).isDisplayed();
    }

    public void logout() {
        driver.findElement(logoutButton).click();
    }
}
