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

    private WaitManager waitManager;

    @BeforeClass
    public void setUpClassLogin() {
       validlogindata = new JsonReader("validLogin-data");
    }

    @Test
    public void validLoginTestCase() {

        String username = validlogindata.getJsonData("name");
        String password = validlogindata.getJsonData("password");

        String ActualName = new LoginPage(DriverManager.getDriver()).login(username, password)
                          .getLoggedUserName();

        Assert.assertTrue(ActualName.contains(username), "Logged in username does not match.");
    }
}
