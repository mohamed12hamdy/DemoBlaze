package com.demoblaze.pages;

import com.demoblaze.actions.ElementActions;
import com.demoblaze.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage {

    private final WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By userCart = By.id("cartur");

    By placeOrderButton = By.xpath("//button[text()='Place Order']");

    By totalBeforePlaceOrderForm = By.id("totalp");

    By totalInPlaceOrderForm = By.id("totalm"); //total :

    By nameField = By.id("name");

    By countryField = By.id("country");

    By cityField = By.id("city");

    By creditCardField = By.id("card");

    By monthField = By.id("month");

    By yearField = By.id("year");

    By purchaseButton = By.xpath("//button[text()='Purchase']");

    By thankYouMessage = By.xpath("//h2[text()='Thank you for your purchase!']");

    public CheckoutPage openCart() {
        new ElementActions(driver)
                .click(userCart);
        return this;

    }

    public CheckoutPage placeOrder() {
        new ElementActions(driver)
                .click(placeOrderButton);
        return this;
    }

    public CheckoutPage verifyTotalAmount() {

        String totalBefore = new ElementActions(driver)
                .findElement(totalBeforePlaceOrderForm)
                .getText()
                .replaceAll("[^0-9.]", "")
                .trim();


        String totalAfter = DriverManager.getDriver()
                .findElement(totalInPlaceOrderForm)
                .getText()
                .replaceAll("[^0-9.]", "")
                .trim();

        assert Double.parseDouble(totalBefore) == Double.parseDouble(totalAfter)
                : "Totals do not match! Before: " + totalBefore + ", After: " + totalAfter;

        return this;
    }


    public CheckoutPage fillPlaceOrderForm(String name, String country, String city,
                                           String creditCard, String month, String year) {
        new ElementActions(driver)
                .type(nameField, name)
                .type(countryField, country)
                .type(cityField, city)
                .type(creditCardField, creditCard)
                .type(monthField, month)
                .type(yearField, year);
        return this;
    }

    public CheckoutPage purchase() {
        new ElementActions(driver)
                .click(purchaseButton);
        return this;
    }

    public CheckoutPage verifyThankYouMessage() {
        String actualMessage = new ElementActions(driver)
                .findElement(thankYouMessage)
                .getText();
        Assert.assertEquals(actualMessage, "Thank you for your purchase!", "Thank you message does not match!");
        return this;
    }



}
