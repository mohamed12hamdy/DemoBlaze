package com.demoblaze.report;

import com.demoblaze.utils.LogsManager;

import java.io.IOException;

public class TerminalUtils {

    public static void executeTerminalCommand(String... commandParts) {
        try {
            ProcessBuilder builder = new ProcessBuilder(commandParts);
            builder.inheritIO();
            Process process = builder.start();
            int exitCode = process.waitFor();
            System.out.println("EXIT CODE = " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}