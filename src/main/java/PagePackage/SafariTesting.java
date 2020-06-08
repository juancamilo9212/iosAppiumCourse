package PagePackage;

import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;

public class SafariTesting extends Base{

    public SafariTesting() {super();}

    public static void main(String[] args) throws MalformedURLException {
        SafariTesting browser=new SafariTesting();
        IOSDriver driver=browser.browserCapabilities();
        driver.findElementById("identifierId").sendKeys("juan.camargo@sofka.com.co");
        driver.findElementById("identifierNext").click();
        driver.findElementByName("password").sendKeys("Mecatronica0325");
        driver.findElementById("passwordNext").click();



    }

}
