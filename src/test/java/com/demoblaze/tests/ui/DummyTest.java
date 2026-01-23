package com.demoblaze.tests.ui;
import com.demoblaze.utils.LogsManager;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test
public class DummyTest {

    @BeforeSuite
    public void beforeSuite() {
       LogsManager.info("Before Suite: Initialize resources");
    }

    @Test
    public void dummyTest() {
        LogsManager.info("Dummy Test executed successfully");
    }

}
