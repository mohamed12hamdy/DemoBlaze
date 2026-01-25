package com.demoblaze.tests;
import com.demoblaze.datareader.PropertyReader;
import com.demoblaze.drivers.DriverFactory;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.utils.LogsManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected static String browser;
    protected static String baseUrl;

    protected String email;

    protected String name;

    protected String message;

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {
        browser = PropertyReader.getProperty("browser");
        baseUrl = PropertyReader.getProperty("baseUrl");
        LogsManager.info("Properties loaded: browser=" + browser + ", baseUrl=" + baseUrl);
    }

    @BeforeGroups("Negative")
    public void beforeNegativeTests() {
        LogsManager.info("Starting Negative Test Group");
        email = PropertyReader.getProperty("email");
        name = PropertyReader.getProperty("name");
        message = PropertyReader.getProperty("message");
    }

    @BeforeMethod(alwaysRun = true)
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
