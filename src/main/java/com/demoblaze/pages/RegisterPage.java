package com.demoblaze.pages;

import com.demoblaze.actions.AlertActions;
import com.demoblaze.actions.ElementActions;
import com.demoblaze.datareader.JsonReader;
import com.demoblaze.utils.LogsManager;
import com.demoblaze.utils.TimeManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private final  WebDriver driver;

    private final JsonReader validregisterdata;

    private final JsonReader Invalidregisterdata;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;

        validregisterdata = new JsonReader("Validregister-data");

        Invalidregisterdata = new JsonReader("Invalidregister-data");
    }

    private final By SignupPage = By.id("signin2");

    private final By UsernameField = By.cssSelector("#sign-username");

    private final By PasswordField = By.cssSelector("#sign-password");

    private final By SignupButton = By.cssSelector("button[onclick='register()']");


    public RegisterPage signup(String name, String password) {
        LogsManager.info("Registering user: " + name);

        new ElementActions(driver)
                .click(SignupPage)
                .type(UsernameField, name)
                .type(PasswordField, password)
                .click(SignupButton);

        return this;
    }

    public String getAlertText() {
        return new AlertActions(driver).getAlertText();
    }

}
