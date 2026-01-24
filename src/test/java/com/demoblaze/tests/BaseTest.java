package com.demoblaze.tests;

import com.demoblaze.datareader.JsonReader;
import com.demoblaze.datareader.PropertyReader;
import com.demoblaze.drivers.DriverFactory;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.utils.LogsManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private String browser;

    private String baseUrl;

    @BeforeClass
    public void setUpClass() {

        browser = PropertyReader.getProperty("browser");
        baseUrl = PropertyReader.getProperty("baseUrl");
    }

    @BeforeMethod
    public void setUpMethod() {
        WebDriver driver = DriverFactory.createDriver(browser);
        DriverManager.setDriver(driver);
        driver.get(baseUrl);
        LogsManager.info("Navigated to base URL");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        DriverManager.quitDriver();
        LogsManager.info("Driver quit successfully");
    }
}