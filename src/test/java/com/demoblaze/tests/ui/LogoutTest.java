package com.demoblaze.tests.ui;

import com.demoblaze.datareader.JsonReader;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.pages.LogoutPage;
import com.demoblaze.tests.BaseTest;

import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    private JsonReader validlogindata;

    public LogoutTest() {
       validlogindata = new JsonReader("validLogin-data");
    }

    @Test
    public void logoutTestCase() {
       new LoginPage(DriverManager.getDriver()).login(validlogindata.getJsonData("name"),
               validlogindata.getJsonData("password"));

        new LogoutPage(DriverManager.getDriver()).logout();
    }

}
