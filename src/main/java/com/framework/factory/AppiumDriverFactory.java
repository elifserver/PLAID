package com.framework.factory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import com.framework.utilities.Utils;

public class AppiumDriverFactory implements DriverFactory {

    @Override
    public AndroidDriver createDriver()  {
        Utils utils = new Utils();
        Properties props = utils.getAppPropertiesFile();
        URL urlInconfigFile = null;
        try {
            urlInconfigFile = new URL(props.getProperty("url"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String platform = props.getProperty("platformName");
        String device = props.getProperty("deviceName");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
        caps.setCapability(MobileCapabilityType.APP, props.getProperty("androidApp"));
        return new AndroidDriver<MobileElement>(urlInconfigFile, caps);
    }
}
