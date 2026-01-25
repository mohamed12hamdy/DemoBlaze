package com.demoblaze.datareader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderHelper {

    public static String[] getOrderData(String csvFilePath, int rowIndex) {
        String line = "";
        String cvsSplitBy = ",";
        int currentIndex = -1;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                currentIndex++;
                if (currentIndex == rowIndex) {
                    return line.split(cvsSplitBy);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
