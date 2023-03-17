package delete;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.action.ActionMethod;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainPageUsingPagefactory {
	
	public MainPageUsingPagefactory(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}
	
	@AndroidFindBy(accessibility = "Views")
	private AndroidElement viewlink;

	@AndroidFindBy(accessibility = "Controls")
	private AndroidElement controllink;
	
	ActionMethod actmtd = new ActionMethod();
	
	public void gotohintbox() {
		actmtd.clickonelementbyfactory(viewlink);
		actmtd.clickonelementbyfactory(controllink);
	}
}
