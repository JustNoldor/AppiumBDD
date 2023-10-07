package testexample.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBase {
    private static AndroidDriver driver;

    @BeforeTest
    public static AndroidDriver getDriver() throws MalformedURLException {
        if (driver == null) {

            // Setup Driver and Device
            URL appiumURL = new URL("http://127.0.0.1:4723");
            UiAutomator2Options options = getUiAutomator2Options();
            driver = new AndroidDriver(appiumURL, options);
        }
        return driver;
    }

    private static UiAutomator2Options getUiAutomator2Options() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("MertsEmulator");
        options.setApp("//Users//user//Desktop//Personal//AppiumBDD//src//test//resources//App//General-Store.apk");
        options.setChromedriverExecutable("//Users//user//Desktop//Personal//AppiumBDD//src//test//resources//Driver//chromedriver");
        return options;
    }

    @AfterTest
    public static void tearDown() {
        // Close driver
        driver.close();
        driver.quit();
    }

}
