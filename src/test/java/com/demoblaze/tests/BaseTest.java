package com.demoblaze.tests;
import com.demoblaze.datareader.CSVReaderHelper;
import com.demoblaze.datareader.ExcelDataHelper;
import com.demoblaze.datareader.JsonReader;
import com.demoblaze.datareader.PropertyReader;
import com.demoblaze.drivers.DriverFactory;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.drivers.WebDriverProvider;
import com.demoblaze.utils.LogsManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest implements WebDriverProvider {

    protected static String browser;
    protected static String baseUrl;

    protected String email;

    protected String name;

    protected String message;

    protected  JsonReader validlogindata;

    protected JsonReader invalidloginNameData;

    protected JsonReader invalidLoginPasswordData;

    protected JsonReader invalidLoginBothData;

    protected String productId;

    protected String[]orderData;


    protected JsonReader validregisterdata;

    protected JsonReader Invalidregisterdata;

    protected  WebDriver driver;
    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {
        browser = PropertyReader.getProperty("browser");
        baseUrl = PropertyReader.getProperty("baseUrl");
        LogsManager.info("Properties loaded: browser=" + browser + ", baseUrl=" + baseUrl);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() {
       driver = DriverFactory.createDriver(browser);
        DriverManager.setDriver(driver);
        driver.get(baseUrl);
        LogsManager.info("Navigated to base URL");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
        LogsManager.info("Driver quit successfully");
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
