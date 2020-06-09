package PagePackage;

import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;

public class RealDeviceTesting extends Base{



    public RealDeviceTesting() {super();}

    public static void main(String[] args) throws MalformedURLException {
        RealDeviceTesting realDevice=new RealDeviceTesting();
        IOSDriver driver=realDevice.realDeviceCapabilities();
    }
}
