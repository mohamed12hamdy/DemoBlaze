package com.demoblaze.pages;

import com.demoblaze.actions.ElementActions;
import com.demoblaze.datareader.JsonReader;
import com.demoblaze.utils.LogsManager;
import com.demoblaze.utils.TimeManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    private JsonReader jsonReader;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        jsonReader = new JsonReader("Validregister-data");
    }

    private final By SignupPage = By.id("signin2");

    private final By UsernameField = By.cssSelector("#sign-username");

    private final By PasswordField = By.cssSelector("#sign-password");

    private final By SignupButton = By.cssSelector("button[onclick='register()']");


    public RegisterPage signup() {

        String name = jsonReader.getJsonData("name") + TimeManager.getSimpleTimestamp();
        String password = jsonReader.getJsonData("password");

        LogsManager.info("Registering with username: " + name + " and password: " + password);

        new ElementActions(driver).click(SignupPage)
                .type(UsernameField, name)
                .type(PasswordField, password)
                .click(SignupButton);

        return this;
    }
}
