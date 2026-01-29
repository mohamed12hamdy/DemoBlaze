package com.demoblaze.tests.ui;

import com.demoblaze.datareader.JsonReader;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.drivers.UITest;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.pages.LogoutPage;
import com.demoblaze.tests.BaseTest;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Authentication")
@Feature("UI User Management")
@Story("User Logout")
@Severity(SeverityLevel.CRITICAL)
@Owner("Mohamed Hamdy")
@UITest
public class LogoutTest extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public void setUpClassLogout() {
        validlogindata = new JsonReader("validLogin-data");
    }


    @Description("Valid user logout scenario.")
    @Test(groups = {"Regression","Smoke"})
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
