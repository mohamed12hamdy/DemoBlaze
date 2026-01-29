package com.demoblaze.tests.ui;

import com.demoblaze.datareader.PropertyReader;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.pages.ContactUsPage;
import com.demoblaze.tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("UI Customer Interaction")
@Feature("Contact Us Form")
@Owner("Mohamed Hamdy")
public class ContactUsPageTest extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public void setUpClassContactUs() {
        email = PropertyReader.getProperty("email");
        name = PropertyReader.getProperty("name");
        message = PropertyReader.getProperty("message");
    }

    @Description("Verify that a user can successfully submit the contact us form with valid email, name, and message.")
    @Test(groups ="Regression")
    public void contactUsTest() {
       String msg = new ContactUsPage(DriverManager.getDriver())
               .openContactForm()
               .fillContactForm(email, name, message)
               .getAlertMessage();

       assert msg.equals("Thanks for the message!!");
    }

    @Description("Fail when email is empty")
    @Test(groups = "Regression")
    public void contactUsWithoutEmailTest() {

        String msg = new ContactUsPage(DriverManager.getDriver())
                .openContactForm()
                .fillContactForm("", name, message)
                .getAlertMessage();

        assert msg.equals("Please fill out Email");
    }

    //this is negative test case and it will fail because email is mandatory field
    @Description("Fail when name is empty")
    @Test(groups = "Regression")
    public void contactUsWithoutNameTest() {
        String msg = new ContactUsPage(DriverManager.getDriver())
                .openContactForm()
                .fillContactForm(email,"", message)
                .getAlertMessage();

        assert msg.equals("Please fill out Name");
    }

    //this is negative test case and it will fail because email is mandatory field
    @Description("Fail when message is empty")
    @Test(groups = "Regression")
    public void contactUsWithoutMessageTest() {

        String msg = new ContactUsPage(DriverManager.getDriver())
                .openContactForm()
                .fillContactForm(email, name, "")
                .getAlertMessage();

        assert msg.equals("Please fill out Message");
    }

    @Description("Fail when all fields are empty")
    @Test(groups = "Regression")
    public void contactUsAllFieldsEmptyTest() {

        String msg = new ContactUsPage(DriverManager.getDriver())
                .openContactForm()
                .fillContactForm("", "", "")
                .getAlertMessage();

        assert msg.equals("Please fill out required fields");
    }

    @Description("Fail when email is invalid")
    @Test(groups = "Regression")
    public void contactUsInvalidEmailTest() {

        String msg = new ContactUsPage(DriverManager.getDriver())
                .openContactForm()
                .fillContactForm("ahmed@", name, message)
                .getAlertMessage();

        assert msg.equals("Please enter valid email");
    }
}
