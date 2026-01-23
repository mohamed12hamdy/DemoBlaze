package com.demoblaze.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LogsManager {

    private static final Logger logger =
            LogManager.getLogger(LogsManager.class);


    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message, String eMessage) {
        logger.error(message);
    }
}
