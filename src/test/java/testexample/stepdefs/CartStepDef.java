package testexample.stepdefs;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testexample.pages.CartPageObject;
import testexample.utils.AppiumBase;

import java.net.MalformedURLException;

public class CartStepDef {

    AppiumDriver driver;

    CartPageObject cartPageObject;
    public CartStepDef() throws MalformedURLException {
        this.driver= AppiumBase.getDriver();
        cartPageObject = new CartPageObject(driver);
    }

    @Given("I go to the Products Page")
    public void iGoToTheProductsPage() {
        cartPageObject.checkInProductsPage();
    }

    @When("I add a product to cart")
    public void iAddAProductToCart() {
        cartPageObject.addProductItem();
    }

    @Then("I should see cart button value increased")
    public void iShouldSeeCartButtonValueIncreased() {
        cartPageObject.checkProductCounter();
    }
}
