package com.demoblaze.datareader;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    private Workbook workbook;
    private Sheet sheet;
    private DataFormatter formatter;

    // constructor
    public ExcelReader(String excelPath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            formatter = new DataFormatter();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load excel file: " + excelPath, e);
        }
    }

    public String getCellDataWithoutHeader(int rowIndex, int columnIndex) {


        Row row = sheet.getRow(rowIndex + 1);
        if (row == null) return "";

        Cell cell = row.getCell(columnIndex);
        if (cell == null) return "";

        return formatter.formatCellValue(cell);
    }

    /**
     * Specific method for productID column (column 0)
     */
    public String getProductId(int index) {
        return getCellDataWithoutHeader(index, 0);
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public void close() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}