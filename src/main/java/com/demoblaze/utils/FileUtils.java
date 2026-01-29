package com.demoblaze.utils;

import com.demoblaze.datareader.PropertyReader;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.copyFile;

//to be used with Allure reports - screenshots
public class FileUtils {

    private static final String USER_DIR = PropertyReader.getProperty("user.dir")+ File.separator;

    private FileUtils() {

    }

    // Renaming
    public static void renameFile(String oldName, String newName) {
        try {
            var targetFile = new File(oldName);
            String targetDirectory = targetFile.getParentFile().getAbsolutePath();
            File newFile = new File(targetDirectory + File.separator + newName);
            if (!targetFile.getPath().equals(newFile.getPath())) {
                copyFile(targetFile, newFile);
                org.apache.commons.io.FileUtils.deleteQuietly(targetFile);
                LogsManager.info("Target File Path: \"" + oldName + "\", file was renamed to \"" + newName + "\".");
            } else {
                LogsManager.info(("Target File Path: \"" + oldName + "\", already has the desired name \"" + newName + "\"."));
            }
        } catch (IOException e) {
            LogsManager.error(e.getMessage());
        }
    }
    public static void createDirectory(String path) {
        try {
            File file = new File(USER_DIR + path);
            if (!file.exists())
            {
                file.mkdirs();
                LogsManager.info("Directory created: " + path);
            }
        }
        catch (Exception e) {
            LogsManager.error("Failed to create directory: " + path, e.getMessage());
        }
    }

    public static void forceDelete(File file) {
        try {
            org.apache.commons.io.FileUtils.forceDeleteOnExit(file);
            LogsManager.info("in force delete");
            LogsManager.info("File deleted: " + file.getAbsolutePath());
        } catch (IOException e) {
            LogsManager.error("Failed to delete file: " + file.getAbsolutePath(), e.getMessage());
        }
    }


    public static void cleanDirectory(File file)
    {
        try {
            org.apache.commons.io.FileUtils.deleteQuietly(file); //in use > skip
        }
        catch (Exception e) {
            LogsManager.error("Failed to clean directory: " + file.getAbsolutePath(), e.getMessage());
        }
    }


    public static void deleteAllureResultsFolder() {
        File allureResultsDir =
                new File(System.getProperty("user.dir")
                        + File.separator
                        + "test-output"
                        + File.separator
                        + "allure-results");

        if (allureResultsDir.exists()) {
            try {
                org.apache.commons.io.FileUtils.deleteDirectory(allureResultsDir);
                System.out.println("Allure results folder deleted successfully");
            } catch (IOException e) {
                throw new RuntimeException(
                        "Failed to delete allure-results folder", e
                );
            }
        }
    }


    //check if the file exists
    public static boolean isFileExists( String fileName) {
        String filePath = USER_DIR + "/src/test/resources/downloads/" ;
        File file = new File(filePath+ fileName);
        return file.exists();
    }
}
