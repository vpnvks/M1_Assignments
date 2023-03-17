package com.action;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ActionMethod {

	public void clickonelement(MobileBy element, AndroidDriver<MobileElement> driver) {
		driver.findElement(element).click();
	}
	
	public void clickonelementbyfactory(AndroidElement ele) {
		ele.click();
	}
}
