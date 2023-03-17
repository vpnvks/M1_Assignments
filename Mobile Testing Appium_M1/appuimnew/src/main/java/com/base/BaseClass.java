package com.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.utils.Constant;
import com.utils.Propertyreadr;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	public AndroidDriver<MobileElement> driver;
	Propertyreadr	prrdr = new Propertyreadr();	
	
@BeforeSuite
public void setdevice() throws MalformedURLException, InterruptedException {
	DesiredCapabilities desiredcap = new DesiredCapabilities();
	
	desiredcap.setCapability(Constant.deviceName, prrdr.getproperty(Constant.deviceName));
	desiredcap.setCapability(Constant.platFormName, prrdr.getproperty(Constant.platFormName));
	desiredcap.setCapability(Constant.platFormVersion, prrdr.getproperty(Constant.platFormVersion));
	//desiredcap.setCapability(Constant.appActivity, "io.appium.android.apis.ApiDemos");
	//desiredcap.setCapability(Constant.appPackage, "io.appium.android.apis");
	desiredcap.setCapability(Constant.app, prrdr.getproperty(Constant.app));
	URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub/");

    driver = new AndroidDriver<>(remoteUrl, desiredcap);
    Thread.sleep(10000);
}

@AfterSuite
public void quite() {
	driver.quit();
}

}
