package com.demoblaze.tests.ui;

import com.demoblaze.actions.AlertActions;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.pages.RegisterPage;

import com.demoblaze.tests.BaseTest;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void validRegisterTestCase() {

        new RegisterPage(DriverManager.getDriver()).signup();

        String alertText = new AlertActions(DriverManager.getDriver()).getAlertText();

        assert alertText.equals("Sign up successful.");
    }
}