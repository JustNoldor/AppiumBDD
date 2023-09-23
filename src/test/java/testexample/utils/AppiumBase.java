package testexample.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBase {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() throws MalformedURLException, InterruptedException {
        if (driver == null) {

            // Setup Driver and Device
            URL appiumURL = new URL("http://127.0.0.1:4723");
            UiAutomator2Options options = getUiAutomator2Options();
            driver = new AppiumDriver(appiumURL, options);
            Thread.sleep(10000);
        }
        return driver;
    }

    private static UiAutomator2Options getUiAutomator2Options() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("MertsEmulator");
        options.setApp("//Users//user//Desktop//Personal//AppiumBDD//src//test//resources//App//General-Store.apk");
        return options;
    }
}
