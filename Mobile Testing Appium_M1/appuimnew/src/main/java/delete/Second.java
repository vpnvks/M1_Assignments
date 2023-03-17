package delete;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Second {

  private AndroidDriver<MobileElement> driver;

  @BeforeClass
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("appium:deviceName", "sdk_gphone64_x86_64");
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("appium:platformVersion", "13");
    desiredCapabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
    desiredCapabilities.setCapability("appium:appPackage", "io.appium.android.apis");
    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub/");

    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
  }

  @org.testng.annotations.Test
  
  public void sampleTest() {
    MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Views");
    el1.click();
    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Chronometer");
    el2.click();
    MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Stop");
    el3.click();
    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("Start");
    el4.click();
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}

