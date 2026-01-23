package com.demoblaze.drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {

        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "edge":
                driver = new EdgeDriver();
                break;

            case "chrome":
            default:
                driver = new ChromeDriver();
                break;
        }

        driver.manage().window().maximize();
        return driver;
    }
}
