package com.demoblaze.listeners;

import com.demoblaze.utils.LogsManager;
import org.testng.ISuiteListener;

public class TestNGListeners implements ISuiteListener {

    @Override
    public void onStart(org.testng.ISuite suite) {
        LogsManager.info("Method onStart: Test Suite execution started: " + suite.getName());
    }

    @Override
    public void onFinish(org.testng.ISuite suite) {
       LogsManager.info("Method onFinish: Test Suite execution finished: " + suite.getName());
    }


}
