package com.demoblaze.tests.ui;

import com.demoblaze.datareader.PropertyReader;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.pages.ContactUsPage;
import com.demoblaze.tests.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ContactUsPageTest extends BaseTest {

    @BeforeClass
    public void setUpClassContactUs() {
        email = PropertyReader.getProperty("email");
        name = PropertyReader.getProperty("name");
        message = PropertyReader.getProperty("message");
    }

    @Test(groups = {"Regression"})
    public void contactUsTest() {
       String msg = new ContactUsPage(DriverManager.getDriver())
               .openContactForm()
               .fillContactForm(email, name, message)
               .getAlertMessage();

       assert msg.equals("Thanks for the message!!");
    }

    //this is negative test case and it will fail because email is mandatory field
    @Test(groups = {"Regression", "Negative"})
    public void contactUsWithoutEmailTest() {

        String msg = new ContactUsPage(DriverManager.getDriver())
                .openContactForm()
                .fillContactForm("", name, message)
                .getAlertMessage();

        assert msg.equals("Please fill out Email");
    }

    //this is negative test case and it will fail because email is mandatory field
    @Test(groups = {"Regression", "Negative"})
    public void contactUsWithoutNameTest() {
        String msg = new ContactUsPage(DriverManager.getDriver())
                .openContactForm()
                .fillContactForm(email,"", message)
                .getAlertMessage();

        assert msg.equals("Please fill out Name");
    }

    //this is negative test case and it will fail because email is mandatory field
    @Test(groups = {"Regression", "Negative"})
    public void contactUsWithoutMessageTest() {

        String msg = new ContactUsPage(DriverManager.getDriver())
                .openContactForm()
                .fillContactForm(email, name, "")
                .getAlertMessage();

        assert msg.equals("Please fill out Message");
    }

    @Test(groups = {"Regression", "Negative"})
    public void contactUsAllFieldsEmptyTest() {

        String msg = new ContactUsPage(DriverManager.getDriver())
                .openContactForm()
                .fillContactForm("", "", "")
                .getAlertMessage();

        assert msg.equals("Please fill out required fields");
    }

    @Test(groups = {"Regression", "Negative"})
    public void contactUsInvalidEmailTest() {

        String msg = new ContactUsPage(DriverManager.getDriver())
                .openContactForm()
                .fillContactForm("ahmed@", name, message)
                .getAlertMessage();

        assert msg.equals("Please enter valid email");
    }
}
