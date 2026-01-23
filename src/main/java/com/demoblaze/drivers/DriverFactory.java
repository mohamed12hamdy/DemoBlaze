package com.demoblaze.drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {

        WebDriver driver = switch (browser.toLowerCase()) {
            case "edge" -> new EdgeDriver();
            case "chrome" -> new ChromeDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };

        driver.manage().window().maximize();
        return driver;
    }
}
