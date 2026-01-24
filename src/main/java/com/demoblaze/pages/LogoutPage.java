package com.demoblaze.pages;

import com.demoblaze.actions.ElementActions;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.utils.LogsManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {

    private final WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By LogoutButton = By.id("logout2");
    By LoginButton = By.id("login2");

    public LogoutPage logout() {
        new ElementActions(driver)
                .click(LogoutButton);
        LogsManager.info("Clicked logout button");
        return this;
    }

    public boolean isLoggedOut() {
        try {
            return new ElementActions(DriverManager.getDriver()).findElement(LoginButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
