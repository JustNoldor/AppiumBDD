package testexample.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonObjects {

    private AndroidDriver driver;

    public CommonObjects(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void scrollToFindText(String text){
        WebElement element = (WebElement) driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
    }

    public void waitElementExistence(String locatorElement){
        Duration duration= Duration.ofSeconds(3000);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorElement)));
    }
}
