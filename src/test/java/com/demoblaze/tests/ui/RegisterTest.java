package com.demoblaze.tests.ui;
import com.demoblaze.datareader.JsonReader;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.pages.RegisterPage;

import com.demoblaze.tests.BaseTest;
import com.demoblaze.utils.TimeManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    private JsonReader validregisterdata;

    private JsonReader Invalidregisterdata;

    @BeforeClass
    public void setUpClassRegister() {
        validregisterdata = new JsonReader("Validregister-data");
        Invalidregisterdata = new JsonReader("Invalidregister-data");
    }

    @Test(groups = {"Regression"})
    public void validRegisterTest() {

       String alertText = new RegisterPage(DriverManager.getDriver()).signup(
                validregisterdata.getJsonData("name") + TimeManager.getSimpleTimestamp(),
                validregisterdata.getJsonData("password")).getAlertMessage();


        Assert.assertEquals(alertText, "Sign up successful.");
    }

    @Test(groups = {"Regression"})
    public void invalidRegisterTest() {

        String alertText = new RegisterPage(DriverManager.getDriver()).signup(
                Invalidregisterdata.getJsonData("name"),
                Invalidregisterdata.getJsonData("password")
        ).getAlertMessage();

        Assert.assertEquals(alertText, "This user already exist.");
    }
}