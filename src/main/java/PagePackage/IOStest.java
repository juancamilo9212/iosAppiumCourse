package PagePackage;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.util.HashMap;

public class IOStest extends Base{

    public IOStest() {
        super();
    }

    public static void main(String[] args) throws MalformedURLException {
        IOStest ioStest=new IOStest();
        IOSDriver<IOSElement> driver=ioStest.capabilities();
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByXPath("//*[@value='Text Entry']").click();
        //driver.findElementByClassName("XCUIElementTypeTextField").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("Hello");
        driver.findElementByAccessibilityId("OK").click();
        driver.navigate().back();
        //-------------------------------------
        ioStest.scroll("Steppers");
        driver.findElementByAccessibilityId("Steppers").click();
        driver.findElementsByXPath("//*[@name='Increment']").get(0).click();
        driver.findElementsByXPath("//*[@name='Increment']").get(0).click();
        String number =driver.findElementsByClassName("XCUIElementTypeStaticText").get(1).getText();
        System.out.println("The number is " + number);
        //-------------------------------------
        driver.navigate().back();
        driver.findElementByAccessibilityId("Picker View").click();
        driver.findElementByAccessibilityId("Green color component value").sendKeys("220");
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).sendKeys("50");
        driver.findElementByXPath("//*[@name='Blue color component value']").sendKeys("130");


    }
}
