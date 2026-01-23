package com.demoblaze.tests;

import com.demoblaze.datareader.PropertyReader;
import com.demoblaze.drivers.DriverFactory;
import com.demoblaze.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {

    private String browser;

    @BeforeClass
    public void setUpClass() {
        PropertyReader.loadProperties();
        browser = PropertyReader.getProperty("browser");
    }

    @BeforeMethod
    public void setUpMethod() {
        WebDriver driver = DriverFactory.createDriver(browser);
        DriverManager.setDriver(driver);
    }

    @Test
    public void testDummy() {
        DriverManager.getDriver().get(PropertyReader.getProperty("baseUrl"));
        System.out.println("Page title is: " + DriverManager.getDriver().getTitle());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
