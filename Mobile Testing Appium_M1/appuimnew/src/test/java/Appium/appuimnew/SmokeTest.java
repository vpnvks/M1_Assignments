package Appium.appuimnew;

import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pages.Pagemainnew;

public class SmokeTest extends BaseClass{
	
 
@Test
  public void firstSmokeMethod() throws InterruptedException {
	
	  Pagemainnew mainpage = new Pagemainnew();
	 
	   mainpage.openApp(driver);
	   mainpage.Searchitem(driver);
	   mainpage.additem(driver);
	   mainpage.removeitem(driver);


  }
}
