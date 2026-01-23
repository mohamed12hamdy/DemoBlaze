package com.demoblaze.listeners;

import org.testng.ISuiteListener;

public class TestNGListeners implements ISuiteListener {

    @Override
    public void onStart(org.testng.ISuite suite) {
        System.out.println("Suite started: " + suite.getName());
    }

    @Override
    public void onFinish(org.testng.ISuite suite) {
        System.out.println("Suite finished: " + suite.getName());
    }
}
