import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

public class test {

    private IOSDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        String filePath;
       // filePath=test.class.getResource("../sneakers_management.app").getPath();
     //   System.out.println(filePath);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "iPhone 8 Plus");
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("platformVersion", "14.1");
        desiredCapabilities.setCapability("app", "sneakers_management.app");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("automationName", "XCUITest");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new IOSDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void sampleTest() {
        MobileElement el1 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");
        el1.sendKeys("1712043@test.com");
        MobileElement el2 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField");
        el2.sendKeys("VuHoang123~");
        MobileElement el3 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Login\"]");
        el3.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

