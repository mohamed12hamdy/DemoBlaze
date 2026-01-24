package com.demoblaze.pages;

import com.demoblaze.actions.AlertActions;
import com.demoblaze.actions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    private final By  LoginPage = By.id("login2");

    private final By UsernameField = By.id("loginusername");

    private final By PasswordField = By.id("loginpassword");

    private final By LoginButton = By.cssSelector("button[onclick='logIn()']");

    private final By LoggedUserName = By.id("nameofuser");


    public LoginPage login(String username, String password) {
        new ElementActions(driver).click(LoginPage)
                .type(UsernameField, username)
                .type(PasswordField, password)
                .click(LoginButton);

        return this;
    }

    public String getLoggedUserName() {
        return new ElementActions(driver)
                .findElement(LoggedUserName)
                .getText();
    }
    public String getAlertMessage() {
        return new AlertActions(driver).getAlertText();
    }
}
