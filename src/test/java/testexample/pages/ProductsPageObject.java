package testexample.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import testexample.utils.AppiumBase;

import java.net.MalformedURLException;

public class ProductsPageObject {

    AndroidDriver driver;

    CommonObjects commonObjects;

    public ProductsPageObject(AndroidDriver driver) throws MalformedURLException {
        this.driver=AppiumBase.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonObjects = new CommonObjects(driver);
        commonObjects.waitElementExistence("com.androidsample.generalstore:id/toolbar_title");
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    WebElement Title;
    public void checkInProductsPage(){
        commonObjects.waitElementExistence("com.androidsample.generalstore:id/toolbar_title");
        String actualTitle = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
        Assert.assertEquals("Products",actualTitle);
    }

    public void addProductItem(){
        driver.findElement(By.xpath("//android.widget.TextView[2][@text='ADD TO CART']")).click();
    }

    public void addTwoProductItem(){
        driver.findElement(By.xpath("//android.widget.TextView[2][@text='ADD TO CART']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[2][@text='ADD TO CART'][1]")).click();
    }

    public void checkProductCounter(){
        String counterValue = driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).getText();
        Assert.assertEquals("1",counterValue);
    }

    public void checkTwoProductCounter(){
        String counterValue = driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).getText();
        Assert.assertEquals("2",counterValue);
    }

    public void clickCartPage(){
       driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    }



}
