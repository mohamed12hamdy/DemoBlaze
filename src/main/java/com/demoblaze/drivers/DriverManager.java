package com.demoblaze.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver>threadLocal = new ThreadLocal<>();

    public static  WebDriver getDriver() {
        return threadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        threadLocal.set(driver);
    }

    public static void quitDriver() {
        WebDriver driver = threadLocal.get();
        if (driver != null) {
            driver.quit();
            threadLocal.remove();
        }
    }
}
