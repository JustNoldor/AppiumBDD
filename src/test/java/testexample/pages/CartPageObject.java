package testexample.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import testexample.utils.AppiumBase;
import io.appium.java_client.remote.SupportsContextSwitching;

import java.net.MalformedURLException;
import java.util.Set;

public class CartPageObject {

    AndroidDriver driver;

    CommonObjects commonObjects;
    public CartPageObject(AndroidDriver driver) throws MalformedURLException {
        this.driver= AppiumBase.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        commonObjects = new CommonObjects(this.driver);
        commonObjects.waitElementExistence("com.androidsample.generalstore:id/toolbar_title");
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    WebElement Title;

    public void checkInCartPage(){
        commonObjects.waitElementExistence("com.androidsample.generalstore:id/toolbar_title");
        String actualTitle = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
        Assert.assertEquals("Cart",actualTitle);
    }

    public void calculateTotalItemAmount(){
        String actualAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Assert.assertEquals("$ 280.97",actualAmount);
    }

    public void clickPurchaseButton(){
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
    }


    public void checkPurchaseCompleteWithWebView() throws InterruptedException {

        //Wait for page
        //commonObjects.waitElementExistence("hplogo");
        Thread.sleep(5000);


        //Listing App Contexts
        Set<String> contextNames = ((SupportsContextSwitching) driver).getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextNames); //prints out something like NATIVE_APP \n WEBVIEW_1
        }

        //Select Webview Context
        ((SupportsContextSwitching) driver).context((String) contextNames.toArray()[1]);
        ((SupportsContextSwitching) driver).context("WEBVIEW_com.androidsample.generalstore");// chrome driver

        //Complete Purchase Phase
        driver.findElement(By.name("q")).sendKeys("Purchase Complete With Webview!");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }


}
