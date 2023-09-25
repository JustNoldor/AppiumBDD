package testexample.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import testexample.pages.HomePageObject;
import testexample.utils.AppiumBase;

import java.net.MalformedURLException;

public class HomeScreenSteps {

    String expectedTitle = "General Store";
    private AppiumDriver driver;
    private HomePageObject homePageObject;

    public HomeScreenSteps() throws MalformedURLException {
        this.driver = AppiumBase.getDriver(); // Initialize your driver here
        homePageObject = new HomePageObject(driver);
    }

    @Given("I open the app")
    public void iOpenTheApp() {
        // driver.launchApp();
    }

    @Then("I should see the home screen with the main title")
    public void iShouldSeeTheHomeScreenWithTitle() {
        String actualTitle = homePageObject.getHomeScreenTitleText();
        Assert.assertEquals(expectedTitle, actualTitle);
        System.out.println(actualTitle);
        System.out.println(expectedTitle);
    }
}
