package com.demoblaze.drivers;
import com.demoblaze.datareader.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {
        WebDriver driver;

        String executionType = PropertyReader.getProperty("executionType");
        switch (browser.toLowerCase()) {
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                if ("LocalHeadless".equalsIgnoreCase(executionType)) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--disable-gpu");
                }
                driver = new ChromeDriver(chromeOptions);
            }

            case "edge" -> {
                EdgeOptions edgeOptions = new EdgeOptions();
                if ("LocalHeadless".equalsIgnoreCase(executionType)) {
                    edgeOptions.addArguments("--headless=new");
                    edgeOptions.addArguments("--disable-gpu");
                }
                driver = new EdgeDriver(edgeOptions);
            }

            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        return driver;
    }
}