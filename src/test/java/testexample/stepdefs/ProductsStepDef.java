package testexample.stepdefs;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testexample.pages.ProductsPageObject;
import testexample.utils.AppiumBase;

import java.net.MalformedURLException;

public class ProductsStepDef {

    AndroidDriver driver;

    ProductsPageObject productsPageObject;
    public ProductsStepDef() throws MalformedURLException {
        this.driver= AppiumBase.getDriver();
        productsPageObject = new ProductsPageObject(driver);
    }

    @Given("I go to the Products Page")
    public void iGoToTheProductsPage() {
        productsPageObject.checkInProductsPage();
    }

    @When("I add a product to cart")
    public void iAddAProductToCart() {
        productsPageObject.addProductItem();
    }

    @Then("I should see cart button value increased")
    public void iShouldSeeCartButtonValueIncreased() {
        productsPageObject.checkProductCounter();
    }

    @When("I add two product to cart")
    public void iAddTwoProductToCart() {
        productsPageObject.addTwoProductItem();
    }

    @When("I click cart button")
    public void iClickCartButton() {
        productsPageObject.clickCartPage();
    }

    @Then("I should see cart button value two increased")
    public void iShouldSeeCartButtonValueTwoIncreased() {
        productsPageObject.checkTwoProductCounter();
    }
}
