package com.demoblaze.utils;

import com.demoblaze.datareader.PropertyReader;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    private static final String USER_DIR = PropertyReader.getProperty("user.dir")+ File.separator;

    private FileUtils() {

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

    //force delete
    public static void forceDelete(File file) {
        try {
            org.apache.commons.io.FileUtils.forceDeleteOnExit(file);
            LogsManager.info("File deleted: " + file.getAbsolutePath());
        } catch (IOException e) {
            LogsManager.error("Failed to delete file: " + file.getAbsolutePath(), e.getMessage());
        }
    }

    // cleaning Directory
    public static void cleanDirectory(File file)
    {
        try {
            org.apache.commons.io.FileUtils.deleteQuietly(file); //in use > skip
        }
        catch (Exception e) {
            LogsManager.error("Failed to clean directory: " + file.getAbsolutePath(), e.getMessage());
        }
    }

    //check if the file exists
    public static boolean isFileExists( String fileName) {
        String filePath = USER_DIR + "/src/test/resources/downloads/" ;
        File file = new File(filePath+ fileName);
        return file.exists();
    }






}
