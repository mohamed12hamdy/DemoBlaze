package com.demoblaze.pages;

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


    public void Validsignup() {

        String name = validregisterdata.getJsonData("name") + TimeManager.getSimpleTimestamp();
        String password = validregisterdata.getJsonData("password");


        LogsManager.info("Registering with username: " + name + " and password: " + password);
        new ElementActions(driver).click(SignupPage)
                .type(UsernameField, name)
                .type(PasswordField, password)
                .click(SignupButton);

    }

    public void Invalidsignup() {

        String name = Invalidregisterdata.getJsonData("name");
        String password = Invalidregisterdata.getJsonData("password");

        LogsManager.info("Registering with username: " + name + " and password: " + password);
        new ElementActions(driver).click(SignupPage)
                .type(UsernameField, name)
                .type(PasswordField, password)
                .click(SignupButton);
    }

}
