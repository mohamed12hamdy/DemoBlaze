package com.demoblaze.tests.ui;
import com.demoblaze.datareader.JsonReader;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.drivers.UITest;
import com.demoblaze.pages.RegisterPage;

import com.demoblaze.tests.BaseTest;
import com.demoblaze.utils.TimeManager;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Authentication")
@Feature("UI User Management")
@Story("User Registration")
@Severity(SeverityLevel.CRITICAL)
@Owner("Mohamed Hamdy")
@UITest
public class RegisterTest extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public void setUpClassRegister() {
        validregisterdata = new JsonReader("Validregister-data");
        Invalidregisterdata = new JsonReader("Invalidregister-data");
    }

    @Description("Valid user registration scenario.")
    @Test(groups = {"Regression","Smoke"})
    public void validRegisterTest() {

       String alertText = new RegisterPage(DriverManager.getDriver()).signup(
                validregisterdata.getJsonData("name") + TimeManager.getSimpleTimestamp(),
                validregisterdata.getJsonData("password")).getAlertMessage();


        Assert.assertEquals(alertText, "Sign up successful.");
    }

    @Description("Invalid user registration scenario.")
    @Test(groups = {"Regression","Smoke"})
    public void invalidRegisterTest() {

        String alertText = new RegisterPage(DriverManager.getDriver()).signup(
                Invalidregisterdata.getJsonData("name"),
                Invalidregisterdata.getJsonData("password")
        ).getAlertMessage();

        Assert.assertEquals(alertText, "This user already exist.");
    }
}