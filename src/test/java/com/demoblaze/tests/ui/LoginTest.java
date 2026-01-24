package com.demoblaze.tests.ui;

import com.demoblaze.datareader.JsonReader;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.tests.BaseTest;
import com.demoblaze.utils.WaitManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private JsonReader validlogindata;

    private JsonReader invalidloginNameData;

    private JsonReader invalidLoginPasswordData;

    private JsonReader invalidLoginBothData;

    private WaitManager waitManager;

    @BeforeClass
    public void setUpClassLogin() {
        validlogindata = new JsonReader("validLogin-data");
        invalidloginNameData = new JsonReader("InvalidLoginName-data");
        invalidLoginPasswordData = new JsonReader("InvalidLoginPassword-data");
        invalidLoginBothData = new JsonReader("InvalidLoginBoth-data");
    }

    @Test
    public void validLoginTestCase() {

        String username = validlogindata.getJsonData("name");
        String password = validlogindata.getJsonData("password");

        String ActualName = new LoginPage(DriverManager.getDriver()).login(username, password)
                .getLoggedUserName();

        Assert.assertTrue(ActualName.contains(username), "Logged in username does not match.");
    }

    @Test
    public void invalidLoginNameTestCase() {

        String username = invalidloginNameData.getJsonData("name");
        String password = invalidloginNameData.getJsonData("password");

        String alertMessage = new LoginPage(DriverManager.getDriver()).login(
                username,
                password
         ).getAlertMessage();

        Assert.assertEquals("User does not exist.", alertMessage);
    }

    @Test
    public void invalidLoginPasswordTestCase() {

        String username = invalidLoginPasswordData.getJsonData("name");
        String password = invalidLoginPasswordData.getJsonData("password");

        String alertMessage = new LoginPage(DriverManager.getDriver()).login(
                username,
                password
        ).getAlertMessage();

        Assert.assertEquals("Wrong password.", alertMessage);
    }

    @Test
    public void invalidLoginBothTestCase() {

        String username = invalidLoginBothData.getJsonData("name");
        String password = invalidLoginBothData.getJsonData("password");

        String alertMessage = new LoginPage(DriverManager.getDriver()).login(
                username,
                password
        ).getAlertMessage();

        Assert.assertEquals("User does not exist.", alertMessage);
    }

}