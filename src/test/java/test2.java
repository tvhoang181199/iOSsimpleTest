import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

public class test2 {

    private IOSDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "iPhone 8 Plus");
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("platformVersion", "14.1");
        desiredCapabilities.setCapability("app", "/Users/huonglam/Documents/HCMUS/HK1-4/Kiểm thử/Deadline/iOSsimpleTest/src/test/sneakers_management.app");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("automationName", "XCUITest");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");


        driver = new IOSDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void sampleTest() {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
        MobileElement el1 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");
        el1.sendKeys("1712043@test.com");
        MobileElement el2 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField");
        el2.sendKeys("VuHoang123~");
        MobileElement el3 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Login\"]");
        el3.click();
        List<MobileElement> els1 = (List<MobileElement>) driver.findElementsById("Account");
        els1.get(0).click();
//        List<MobileElement> els3 = (List<MobileElement>) driver.findElementsById("Change Password");
//        els3.get(0).click();
//
//        Assert.assertEquals(true, els3.isEmpty());
//
    }

    @Test
    public void sampleTest2() {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS);
        MobileElement el1 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");
        el1.sendKeys("1712043@test.com");
        MobileElement el2 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField");
        el2.sendKeys("VuHoang123~");
        MobileElement el3 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Login\"]");
        el3.click();
        List<MobileElement> els1 = (List<MobileElement>) driver.findElementsById("Account");
        els1.get(0).click();
        MobileElement el4 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Account\"]");
        el4.click();
//        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("trinh vuhoang");
//        el5.click();

//        List<MobileElement> els3 = (List<MobileElement>) driver.findElementsById("Change Password");
//        els3.get(0).click();
//
//        Assert.assertEquals(false, els3.isEmpty());
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}