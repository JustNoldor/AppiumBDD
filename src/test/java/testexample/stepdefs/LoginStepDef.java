package testexample.stepdefs;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testexample.pages.LoginPageObject;
import testexample.utils.AppiumBase;

import java.net.MalformedURLException;

public class LoginStepDef {

    private AppiumDriver driver;
    private LoginPageObject loginPageObject;

    public LoginStepDef() throws MalformedURLException {
        this.driver = AppiumBase.getDriver();
        loginPageObject =  new LoginPageObject(driver);
    }


    @Given("I go to the Login Page")
    public void iGoToTheLoginPage() {
        // Launch app
    }

    @When("I select to shopping region")
    public void iSelectToShoppingRegion() {
        loginPageObject.selectShoppingRegion();
    }

    @When("I log in with valid credentials")
    public void iLogInWithValidCredentials() {
        loginPageObject.inputUserValues();
    }

    @Then("I should be in the products page")
    public void iShouldBeInTheProductsPage() {
        loginPageObject.checkIsInProductsPage();
    }
}
