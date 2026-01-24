package com.demoblaze.pages;

import com.demoblaze.actions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class productPage extends BasePage {

    private final WebDriver driver;

    public productPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public productPage openProductById(String productId) {
        By product = By.xpath("//a[contains(@href,'idp_=" + productId + "')]");
        new ElementActions(driver).click(product);
        return this;
    }

    public productPage addToCart() {
        By addToCartButton = By.xpath("//a[text()='Add to cart']");
        new ElementActions(driver).click(addToCartButton);
        return this;
    }

}
