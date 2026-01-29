package com.demoblaze.listeners;

import com.demoblaze.datareader.PropertyReader;
import com.demoblaze.drivers.DriverFactory;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.drivers.UITest;
import com.demoblaze.drivers.WebDriverProvider;
import com.demoblaze.drivers.WebDriverProvider;
import com.demoblaze.media.ScreenshotsManager;
import com.demoblaze.report.AllureAttachmentManager;
import com.demoblaze.report.AllureConstants;
import com.demoblaze.report.AllureEnvironmentManager;
import com.demoblaze.report.AllureReportGenerator;
import com.demoblaze.utils.FileUtils;
import com.demoblaze.utils.LogsManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;


public class TestNGListeners implements ISuiteListener, IExecutionListener, IInvokedMethodListener, ITestListener {

    public void onExecutionStart() {
        LogsManager.info("Test Execution started");
        cleanTestOutputDirectories();
        LogsManager.info("Directories cleaned");
        createTestOutputDirectories();
        LogsManager.info("Directories created");
        PropertyReader.loadProperties();
        LogsManager.info("Properties loaded");
        AllureEnvironmentManager.setEnvironmentVariables();
        LogsManager.info("Allure environment set");
    }

    public void onExecutionFinish() {

        AllureReportGenerator.generateReports(false);
        //AllureReportGenerator.generateReports(true);
        AllureReportGenerator.openReport(AllureReportGenerator.renameReport());
        LogsManager.info("Test Execution Finished");
    }


    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {

            LogsManager.info("Test Case " + testResult.getName() + " started");
        }
    }

//    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
//        WebDriver driver = null;
//
//        if (method.isTestMethod()) {
//
//            if (testResult.getInstance() instanceof UITest) {
//
//                if (testResult.getInstance() instanceof WenDriverProvider provider) {
//                    driver = provider.getWebDriver();
//                }
//
//                // Screenshot ONLY if test FAILED
//                if (testResult.getStatus() == ITestResult.FAILURE) {
//                    ScreenshotsManager.takeFullPageScreenshot(
//                            driver,
//                            "failed-" + testResult.getName()
//                    );
//                }
//            }
//            AllureAttachmentManager.attachLogs();
//        }
//    }



    public void onTestSuccess(ITestResult result) {
        LogsManager.info("Test Case " + result.getName() + " passed");
    }


    public void onTestSkipped(ITestResult result) {
        LogsManager.info("Test Case " + result.getName() + " skipped");
    }


    public void onTestFailure(ITestResult testResult) {

        Object instance = testResult.getInstance();

        if (instance instanceof WebDriverProvider provider) {

            WebDriver driver = provider.getWebDriver();

            try {
                Alert alert = driver.switchTo().alert();
                LogsManager.info("Alert found with text: " + alert.getText());
                alert.accept();
            } catch (NoAlertPresentException e) {
                LogsManager.info("NO ALERT");
            }

            try {
                ScreenshotsManager.takeFullPageScreenshot(
                        driver,
                        "failed-" + testResult.getName()
                );
            } catch (Exception e) {
                LogsManager.error("Failed to take screenshot", e.getMessage());
            }
        }

        AllureAttachmentManager.attachLogs();
    }


    // cleaning and creating dirs (logs, screenshots, recordings,allure-results)
    private void cleanTestOutputDirectories() {
        // Implement logic to clean test output directories
        FileUtils.cleanDirectory(AllureConstants.RESULTS_FOLDER.toFile());
        FileUtils.cleanDirectory(AllureConstants.FULL_REPORT_PATH.toFile());
        FileUtils.cleanDirectory(new File(ScreenshotsManager.SCREENSHOTS_PATH));
        FileUtils.forceDelete(new File(LogsManager.LOGS_PATH +"logs.log"));
    }

    private void createTestOutputDirectories() {
        // Implement logic to create test output directories
        FileUtils.createDirectory(ScreenshotsManager.SCREENSHOTS_PATH);
    }
}