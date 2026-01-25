package com.demoblaze.tests.ui;

import com.demoblaze.datareader.JsonReader;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.tests.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    private  JsonReader validlogindata;

    @BeforeClass
    public void setUpClassProduct() {
        validlogindata = new JsonReader("validLogin-data");


    }
    //TODO implement THIS
    @Test
    public void addItemToCart() {

        new LoginPage(DriverManager.getDriver()).login(
                validlogindata.getJsonData("name"),
                validlogindata.getJsonData("password")
        );

//        String msg = new productPage(DriverManager.getDriver())
//                .openProductById(productId)
//                .addToCart()
//                .getAlertMessage();

//        Assert.assertEquals(msg, "Product added.", "Product not added to cart.");

    }



}
