package com.demoblaze.pages;

import com.demoblaze.actions.ElementActions;
import com.demoblaze.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {

    private final WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By ContactButton = By.cssSelector("[data-toggle='modal'][data-target='#exampleModal']");

    // Method to open contact form only
    public ContactUsPage openContactForm() {
        new ElementActions(DriverManager.getDriver()).click(ContactButton);
        return this;
    }

    public ContactUsPage fillContactForm(String email, String name, String message) {

        By EmailField = By.id("recipient-email");
        By NameField = By.id("recipient-name");
        By MessageField = By.id("message-text");
        By SendMessageButton = By.cssSelector("button[onclick='send()']");

        new ElementActions(driver)
                .type(EmailField, email)
                .type(NameField, name)
                .type(MessageField, message)
                .click(SendMessageButton);
        return this;
    }

}
