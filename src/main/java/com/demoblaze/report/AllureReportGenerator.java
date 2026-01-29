package com.demoblaze.report;

import com.demoblaze.utils.FileUtils;
import com.demoblaze.utils.LogsManager;
import com.demoblaze.utils.TimeManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AllureReportGenerator {

    public static void generateReports(boolean isSingleFile) {

        Path outputFolder = isSingleFile
                ? AllureConstants.REPORT_PATH
                : AllureConstants.FULL_REPORT_PATH;


        try {
            Files.createDirectories(outputFolder);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create report directory", e);
        }

        // paths absolute بدون أي quotes
        String resultsPath = AllureConstants.RESULTS_FOLDER.toAbsolutePath().toString();
        String outputPath  = outputFolder.toAbsolutePath().toString();

        List<String> command = new ArrayList<>(List.of(
                "C:\\Users\\midoh\\AppData\\Roaming\\npm\\allure.cmd",
                "generate",
                resultsPath,
                "-o",
                outputPath
        ));

        if (isSingleFile) command.add("--single-file");

        TerminalUtils.executeTerminalCommand(command.toArray(new String[0]));
    }
    //rename report file to AllureReport_timestamp.html
    public static String renameReport() {
        String newFileName = AllureConstants.REPORT_PREFIX + TimeManager.getTimestamp() + AllureConstants.REPORT_EXTENSION; // AllureReport_20250720_211230.html
        FileUtils.renameFile(AllureConstants.REPORT_PATH.resolve(AllureConstants.INDEX_HTML).toString(), newFileName);
        return newFileName;
    }

    // Open Allure report in browser using npx allure open
    public static void openReport(String reportDir) {
        if (reportDir == null) return;

        Path reportPath = AllureConstants.REPORT_PATH.resolve(reportDir);

        System.out.println("Pathhhh"+reportPath);
        switch (OSUtils.getCurrentOS()) {
            case WINDOWS -> {

                List<String> command = List.of(
                        "C:\\Users\\midoh\\AppData\\Roaming\\npm\\allure.cmd",
                        "open",
                        "test-output/full-report"
                );
                TerminalUtils.executeTerminalCommand(command.toArray(new String[0]));
            }
            case MAC, LINUX -> {
                List<String> command = List.of(
                        "C:\\Users\\midoh\\AppData\\Roaming\\npm\\allure.cmd",
                        "open",
                        reportPath.toAbsolutePath().toString()
                );

                TerminalUtils.executeTerminalCommand(command.toArray(new String[0]));
            }
            default -> System.out.println("Opening Allure Report is not supported on this OS.");
        }
    }


    // Copy history folder to results folder
    public static void copyHistory() {
        try {
            org.apache.commons.io.FileUtils.copyDirectory(
                    AllureConstants.HISTORY_FOLDER.toFile(),
                    AllureConstants.RESULTS_HISTORY_FOLDER.toFile()
            );
        } catch (Exception e) {
            System.out.println("Error copying history files: " + e.getMessage());
        }
    }
}
