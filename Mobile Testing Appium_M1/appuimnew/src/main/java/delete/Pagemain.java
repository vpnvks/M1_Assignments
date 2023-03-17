package delete;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;


public class Pagemain {
	
	public MobileBy locationcurrentoption = (MobileBy) MobileBy.AccessibilityId("Search At Current Location Button");
	public MobileBy enterlocation = (MobileBy) MobileBy.AccessibilityId("Enter Address Button");
	
    public void openApp(AndroidDriver<MobileElement> driver) {
    	
      driver.manage().timeouts().implicitlyWait(18,TimeUnit.SECONDS); 
	  MobileElement el1 = (MobileElement) driver.findElementById("com.grubhub.android:id/welcome_button");
	  el1.click();
		 
	  MobileElement el2 = (MobileElement) driver.findElementById("com.grubhub.android:id/address_bar");
	  el2.click();
	  driver.findElement(locationcurrentoption).click();
	  MobileElement locationapproval = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_one_time_button");
	  locationapproval.click();
	  
	  String textval = driver.findElementById("com.grubhub.android:id/search_query_text_fused").getAttribute("text");
	  Assert.assertEquals(textval, "Search");
}
    @SuppressWarnings("rawtypes")
	public void Searchitem(AndroidDriver<MobileElement> driver) throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(18,TimeUnit.SECONDS); 
    driver.findElementById("com.grubhub.android:id/search_query_text_fused").click();
     
    Thread.sleep(5000);
    TouchAction<?> taction1 = new TouchAction<>(driver);
    taction1.tap(new TapOptions().withPosition(new PointOption().withCoordinates(282,491))).perform();
	Thread.sleep(5000);
		
    }
    
    @SuppressWarnings("rawtypes")
	public void additem(AndroidDriver<MobileElement> driver) throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(18,TimeUnit.SECONDS);
	TouchAction<?> taction1 = new TouchAction<>(driver);
	taction1.tap(new TapOptions().withPosition(new PointOption().withCoordinates(522,727))).perform();
	  
	  System.out.println("reached to last line");
	  taction1.tap(new TapOptions().withPosition(new PointOption().withCoordinates(367,1764))).perform();
	  Thread.sleep(3000);
	  taction1.tap(new TapOptions().withPosition(new PointOption().withCoordinates(100,1750))).perform();
	  Thread.sleep(3000);
	  taction1.tap(new TapOptions().withPosition(new PointOption().withCoordinates(570,1888))).perform();
		 
	  driver.findElementById("com.grubhub.android:id/add_button").click();
	  Thread.sleep(3000);
	  driver.findElementById("com.grubhub.android:id/order_button_bg").click();	
	  Thread.sleep(3000);
	  
    }
    @SuppressWarnings("rawtypes")
    
	public void removeitem(AndroidDriver<MobileElement> driver) throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(18,TimeUnit.SECONDS);
	TouchAction<?> taction1 = new TouchAction<>(driver);
	 taction1.tap(new TapOptions().withPosition(new PointOption().withCoordinates(526,840))).perform();
	 Thread.sleep(3000);
	 System.out.println("inside the last line");
	 taction1.tap(new TapOptions().withPosition(new PointOption().withCoordinates(942,840))).perform();
	 System.out.println("outside the last-1 line");
	 driver.findElementById("com.grubhub.android:id/cookbook_button_bar_primary_button").click();
    	 	
    }
}
