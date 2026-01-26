package com.demoblaze.listeners;

import com.demoblaze.datareader.PropertyReader;
import com.demoblaze.utils.LogsManager;
import org.testng.*;

public class TestNGListeners implements ISuiteListener, IExecutionListener, IInvokedMethodListener, ITestListener {

    public void onExecutionStart() {
        LogsManager.info("Test Execution started");
//        cleanTestOutputDirectories();
        LogsManager.info("Directories cleaned");
//        createTestOutputDirectories();
        LogsManager.info("Directories created");
         PropertyReader.loadProperties();
        LogsManager.info("Properties loaded");
//        AllureEnvironmentManager.setEnvironmentVariables();
        LogsManager.info("Allure environment set");
    }

    public void onExecutionFinish() {
//        //AllureReportGenerator.copyHistory();
//        AllureReportGenerator.generateReports(false);
//        AllureReportGenerator.generateReports(true);
//        AllureReportGenerator.openReport(AllureReportGenerator.renameReport());
        LogsManager.info("Test Execution Finished");
    }


    public void onTestSuccess(ITestResult result) {
        LogsManager.info("Test Case " + result.getName() + " passed");
    }

    public void onTestFailure(ITestResult result) {
        LogsManager.info("Test Case " + result.getName() + " failed");
    }

    public void onTestSkipped(ITestResult result) {
        LogsManager.info("Test Case " + result.getName() + " skipped");
    }
}
