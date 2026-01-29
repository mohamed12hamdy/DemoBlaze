package com.demoblaze.tests.ui;

import com.demoblaze.datareader.CSVReaderHelper;
import com.demoblaze.datareader.ExcelDataHelper;
import com.demoblaze.datareader.JsonReader;
import com.demoblaze.drivers.DriverManager;
import com.demoblaze.pages.CheckoutPage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.pages.productPage;
import com.demoblaze.tests.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
@Epic("E-Commerce")
@Feature("Product Management & Checkout")
@Owner("Mohamed Hamdy")
public class ProductTest extends BaseTest {

    @BeforeClass(alwaysRun = true)
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

    // Helper method for login and add to cart
    private void AddItemToCart() {
       new productPage(DriverManager.getDriver())
                .openProductById(productId)
               .addToCart().validateAddToCart();
    }

    @Test(groups = "Regression")
    @Story("Add Product to Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a logged-in user can successfully add a product to the cart.")
    public void addItemToCartTest() {
        loginAndAddItemToCart();
    }

    @Test(groups = "Regression")
    @Story("End-to-End Checkout for Logged-in User")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a logged-in user can complete the full checkout process and see the thank you message.")
    public void checkoutE2ETest() {
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

    @Test(groups = "Regression")
    @Story("Checkout as Guest User")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a guest user can complete the checkout process without logging in and see " +
            "the thank you message.")
    public void CheckoutGuestUserTest() {
        AddItemToCart();
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
