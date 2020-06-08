package PagePackage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Base {

    IOSDriver driver;

    public IOSDriver capabilities() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 8");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"IOS");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/juan.camargo/Library/Developer/Xcode/DerivedData/UICatalog-broiyvrzkmazoaacibqyqvzenpih/Build/Products/Debug-iphonesimulator/UICatalog.app");
        capabilities.setCapability("simpleIsVisibleCheck",true);
        driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public IOSDriver browserCapabilities() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"safari");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13.5");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 8");
        driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://gmail.com");
        return driver;
    }

    public IOSDriver realDeviceCapabilities() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"safari");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13.5");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 8");
        capabilities.setCapability("xcodeOrgId","89PA3NYMJK");//Membership developer.apple.com
        capabilities.setCapability("xcodeSigningId","iPhone Developer");
        capabilities.setCapability("udid","00008020-0016518C21D1002E");
        capabilities.setCapability("updateWDABundleId","");
        driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public void scroll(String elementLabel){
        RemoteWebElement parent=(RemoteWebElement)driver.findElement(By.className("XCUIElementTypeTable"));
        String parentID=parent.getId();
        HashMap<String,String> scrollObject=new HashMap<String, String>();
        scrollObject.put("element",parentID);
        scrollObject.put("predicateString","label == '"+elementLabel+"'");
        driver.executeScript("mobile:scroll",scrollObject);
    }

}
