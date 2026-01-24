package com.demoblaze.pages;

import com.demoblaze.actions.AlertActions;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public String getAlertMessage() {
        return new AlertActions(driver).getAlertText();
    }
}

