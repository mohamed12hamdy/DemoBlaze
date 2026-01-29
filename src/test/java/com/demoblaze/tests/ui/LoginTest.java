package com.demoblaze.tests.ui;

import com.demoblaze.datareader.JsonReader;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.drivers.UITest;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.tests.BaseTest;
import com.demoblaze.utils.WaitManager;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Authentication")
@Feature("UI User Management")
@Story("User Login")
@Severity(SeverityLevel.CRITICAL)
@Owner("Mohamed Hamdy")
@UITest
public class LoginTest extends BaseTest {

    private WaitManager waitManager;

    @BeforeClass(alwaysRun = true)
    public void setUpClassLogin() {
        validlogindata = new JsonReader("validLogin-data");
        invalidloginNameData = new JsonReader("InvalidLoginName-data");
        invalidLoginPasswordData = new JsonReader("InvalidLoginPassword-data");
        invalidLoginBothData = new JsonReader("InvalidLoginBoth-data");
    }

    @Description("Verify that a user can successfully log in with valid credentials.")
    @Test(groups = {"Regression","Smoke"})
    public void validLoginTest() {

        String username = validlogindata.getJsonData("name");
        String password = validlogindata.getJsonData("password");

        String ActualName = new LoginPage(DriverManager.getDriver()).login(username, password)
                            .getLoggedUserName();

        Assert.assertTrue(ActualName.contains(username), "Logged in username does not match.");
    }

    @Description("Verify that login fails when the user enters a non-existent username and an error message is displayed.")
    @Test(groups = {"Regression","Smoke"})
    public void invalidLoginNameTest() {

        String username = invalidloginNameData.getJsonData("name");
        String password = invalidloginNameData.getJsonData("password");

        String alertMessage = new LoginPage(DriverManager.getDriver()).login(
                username,
                password
         ).getAlertMessage();

        Assert.assertEquals("User does not exist.", alertMessage);
    }

    @Description("Login fails with incorrect password.")
    @Test(groups = {"Regression","Smoke"})
    public void invalidLoginPasswordTest() {

        String username = invalidLoginPasswordData.getJsonData("name");
        String password = invalidLoginPasswordData.getJsonData("password");

        String alertMessage = new LoginPage(DriverManager.getDriver()).login(
                username,
                password
        ).getAlertMessage();

        Assert.assertEquals("Wrong password.", alertMessage);
    }

    @Description("Login fails with invalid username and password.")
    @Test(groups = {"Regression","Smoke"})
    public void invalidLoginBothTest() {

        String username = invalidLoginBothData.getJsonData("name");
        String password = invalidLoginBothData.getJsonData("password");

        String alertMessage = new LoginPage(DriverManager.getDriver()).login(
                username,
                password
        ).getAlertMessage();

        Assert.assertEquals("User does not exist.", alertMessage);
    }

}