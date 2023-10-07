package testexample.stepdefs;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testexample.pages.CartPageObject;
import testexample.utils.AppiumBase;

import java.net.MalformedURLException;

public class CartStepDef {

    AndroidDriver driver;
    CartPageObject cartPageObject;

    public CartStepDef() throws MalformedURLException {
        this.driver = AppiumBase.getDriver();
        cartPageObject = new CartPageObject(driver);
    }


    @Then("I should be in the cart page")
    public void iShouldBeInTheCartPage() {
        cartPageObject.checkInCartPage();
    }

    @Then("I should see total items amount")
    public void iShouldSeeTotalItemsAmount() {
        cartPageObject.calculateTotalItemAmount();
    }

    @When("I click complete purchase button")
    public void iClickCompletePurchaseButton() {
        cartPageObject.clickPurchaseButton();

    }

    @Then("I should be in the web view page")
    public void iShouldBeInTheWebViewPage() throws InterruptedException {
        cartPageObject.checkPurchaseCompleteWithWebView();
    }
}
