package com.demoblaze.datareader;

public class ExcelDataHelper {

    public static String getProductId(int index) {
        ExcelReader excel = new ExcelReader(
                "src/test/resources/test-data/productsData.xlsx",
                "Sheet1"
        );
        String value = excel.getProductId(index);
        excel.close();
        return value;
    }
}
