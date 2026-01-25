package com.demoblaze.tests.ui;

import com.demoblaze.datareader.CSVReaderHelper;
import com.demoblaze.datareader.ExcelDataHelper;
import com.demoblaze.datareader.JsonReader;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.pages.CheckoutPage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.pages.productPage;
import com.demoblaze.tests.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    private JsonReader validlogindata;
    private String productId;

    private String[]orderData;

    @BeforeClass
    public void setUpClassProduct() {
        validlogindata = new JsonReader("validLogin-data");
        productId = ExcelDataHelper.getProductId(2);
        orderData = CSVReaderHelper.getOrderData("src/test/resources/test-data/placeOrderData.csv", 0);
    }

    // Helper method for login and add to cart
    private void loginAndAddItemToCart() {
        new LoginPage(DriverManager.getDriver()).login(
                validlogindata.getJsonData("name"),
                validlogindata.getJsonData("password")
        );
        new productPage(DriverManager.getDriver())
                .openProductById(productId)
                .addToCart().validateAddToCart();
    }

    @Test(groups = {"Smoke", "Regression"})
    public void addItemToCart() {
        loginAndAddItemToCart();
    }


    @Test(groups = {"Smoke", "Regression"})
    public void checkoutE2E() {
        loginAndAddItemToCart();
        new CheckoutPage(DriverManager.getDriver())
                .openCart()
                .placeOrder()
                .verifyTotalAmount()
                .fillPlaceOrderForm(orderData[0], orderData[1], orderData[2],
                        orderData[3], orderData[4], orderData[5])
                .purchase()
                .verifyThankYouMessage();
    }
}
