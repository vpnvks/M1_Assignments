package delete;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Appiumfirst {

	AndroidDriver<MobileElement> driver;
	DesiredCapabilities desiredcap = new DesiredCapabilities();
	
	@Test
	public void appopen() throws MalformedURLException, InterruptedException {
		desiredcap.setCapability("deviceName", "sdk_gphone64_x86_64");
		desiredcap.setCapability("platformName", "Android");
		desiredcap.setCapability("platformVersion", "13");
		desiredcap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		desiredcap.setCapability("appPackage", "io.appium.android.apis");
		
		URL newurl = new URL("http://127.0.0.1:4723/wd/hub/");
		driver = new AndroidDriver<MobileElement>(newurl, desiredcap);
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]")).click();
		Thread.sleep(2000);
		
		//driver.fin
	}
	@AfterClass
	public void quiteit() {
		driver.quit();
	}
	
}
