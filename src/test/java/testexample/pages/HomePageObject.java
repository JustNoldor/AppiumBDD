package testexample.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
    private AppiumDriver driver;

    public HomePageObject(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    private WebElement homeScreenTitle;

    public String getHomeScreenTitleText() {
        return homeScreenTitle.getText();
    }

}
