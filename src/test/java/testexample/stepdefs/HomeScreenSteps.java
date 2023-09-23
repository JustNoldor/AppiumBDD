package testexample.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import testexample.pages.HomePage;
import testexample.utils.AppiumBase;

import java.net.MalformedURLException;

public class HomeScreenSteps {

    String expectedTitle = "General Store";
    private AppiumDriver driver;
    private HomePage homePage;

    public HomeScreenSteps() throws MalformedURLException, InterruptedException {
        this.driver = AppiumBase.getDriver(); // Initialize your driver here
        homePage = new HomePage(driver);
    }

    @Given("I open the app")
    public void iOpenTheApp() {
        // driver.launchApp();
    }

    @Then("I should see the home screen with the main title")
    public void iShouldSeeTheHomeScreenWithTitle() {
        String actualTitle = homePage.getHomeScreenTitleText();
        Assert.assertEquals(expectedTitle, actualTitle);
        System.out.println(actualTitle);
        System.out.println(expectedTitle);
    }
}
