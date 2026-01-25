package com.demoblaze.tests.ui;

import com.demoblaze.datareader.JsonReader;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.pages.LogoutPage;
import com.demoblaze.tests.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    private JsonReader validlogindata;

    @BeforeClass
    public void setUpClassLogout() {
        validlogindata = new JsonReader("validLogin-data");
    }

    @Test(groups = {"Regression"})
    public void logoutTest() {
       new LoginPage(DriverManager.getDriver()).login(validlogindata.getJsonData("name"),
               validlogindata.getJsonData("password"));

        Assert.assertTrue(
                new LogoutPage(DriverManager.getDriver())
                        .logout()
                        .isLoggedOut(),
                "User is not logged out successfully"
        );

    }
}
