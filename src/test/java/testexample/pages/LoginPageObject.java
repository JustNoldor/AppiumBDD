package testexample.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

        private CommonObjects commonObjects;
        private AppiumDriver driver;
        private String shoppingRegion="Argentina";
        public LoginPageObject(AppiumDriver driver) {
            this.driver = driver;
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
            commonObjects = new CommonObjects(driver);
            commonObjects.waitElementExistence("com.androidsample.generalstore:id/toolbar_title");
        }


    public void checkIsInLoginPage(){
        commonObjects.waitElementExistence("com.androidsample.generalstore:id/toolbar_title");
        String actualTitle = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
        Assert.assertEquals("General Store",actualTitle);
    }
    public void selectShoppingRegion(){
        commonObjects.scrollToFindText(shoppingRegion);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+shoppingRegion+"']")).click();
    }
    public void inputUserValues(){
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("TestUsername");
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

    }

    public void checkIsInProductsPage(){
        commonObjects.waitElementExistence("com.androidsample.generalstore:id/toolbar_title");
        String actualTitle = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
        Assert.assertEquals("Products",actualTitle);
    }

}
