package com.demoblaze.tests.ui;

import com.demoblaze.datareader.ExcelDataHelper;
import com.demoblaze.datareader.ExcelReader;
import com.demoblaze.datareader.JsonReader;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.pages.productPage;
import com.demoblaze.tests.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    private  JsonReader validlogindata;

    private String productId;

    @BeforeClass
    public void setUpClassProduct() {
        validlogindata = new JsonReader("validLogin-data");
        productId = ExcelDataHelper.getProductId(2);

    }

    //Login and add item to cart scenario
    @Test
    public void addItemToCart() {
        new LoginPage(DriverManager.getDriver()).login(
                validlogindata.getJsonData("name"),
                validlogindata.getJsonData("password")
        );
        new productPage(DriverManager.getDriver())
                .openProductById(productId)
                .addToCart().validateAddToCart();
    }
}
