package delete;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

@SuppressWarnings("deprecation")
public class Appiumthird {
	
	AndroidDriver driver;
	DesiredCapabilities desiredcap = new DesiredCapabilities();
	
	@BeforeClass
	public void setdevice() throws MalformedURLException {
		desiredcap.setCapability("deviceName", "sdk_gphone64_x86_64");
		desiredcap.setCapability("platformName", "Android");
		desiredcap.setCapability("platformVersion", "13");
		desiredcap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		desiredcap.setCapability("appPackage", "io.appium.android.apis");
		
		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub/");

	    driver = new AndroidDriver(remoteUrl, desiredcap);
	}
	
	@Test
	public void checkbutton() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Buttons\"]")).click();
		//Thread.sleep(2000);
		scrollscreen(408,1809,502);
		scrollscreen(408,1809,502);
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Seek Bar\"]")).click();
		Thread.sleep(1000);
		TouchAction<?> taction1 = new TouchAction<>(driver);
		
		taction1.tap(new TapOptions().withPosition(new PointOption().withCoordinates(736,348))).perform();
		
		taction1.press(new PointOption().withCoordinates(540,238))
		.moveTo(new PointOption().withCoordinates(833, 238)).release().perform();
		Thread.sleep(2000);
	}
	
	public void scrollscreen(int xaxis, int yaxisdown, int yaxisup) {
		@SuppressWarnings("deprecation")
		TouchAction taction = new TouchAction(driver);
		taction.press(new PointOption().withCoordinates(xaxis, yaxisdown))
		.moveTo(new PointOption().withCoordinates(xaxis, yaxisup))
		.release();
		taction.perform();
	}
	
	@AfterClass
	public void quite() {
		driver.quit();
	}
}
