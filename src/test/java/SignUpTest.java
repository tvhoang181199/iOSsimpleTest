import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SignUpTest {

    private IOSDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "iPhone 8 Plus");
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("platformVersion", "14.2");
        desiredCapabilities.setCapability("app", "/Users/huonglam/Documents/HCMUS/HK1-4/Kiểm thử/Deadline/iOSsimpleTest/src/test/sneakers_management.app");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("automationName", "XCUITest");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");


        driver = new IOSDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void SignUp() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        MobileElement el1 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Sign Up\"]");
        el1.click();
        List<MobileElement> els1 = (List<MobileElement>) driver.findElementsById("Last Name");
        els1.get(0).sendKeys("Huong");
        MobileElement el3 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]");
        el3.sendKeys("Lam");
        MobileElement el4 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[3]");
        el4.sendKeys("11111111");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\" Female\"]");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[4]");
        el6.sendKeys("1712069@abc.com");
        MobileElement el7 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField[1]");
        el7.sendKeys("Lqh@1234");
        MobileElement el8 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField[2]");
        el8.sendKeys("Lqh@1234");
        MobileElement el9 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\" Standard\"]");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Sign Up\"]");
        el10.click();
        try{
            MobileElement el2 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"SCLAlertView\"]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText");
            Assert.assertTrue(el2.getAttribute("name").equals("Success"));
        } catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void ReSignUp() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        MobileElement el1 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Sign Up\"]");
        el1.click();
        List<MobileElement> els1 = (List<MobileElement>) driver.findElementsById("Last Name");
        els1.get(0).sendKeys("Huong");
        MobileElement el3 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]");
        el3.sendKeys("Lam");
        MobileElement el4 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[3]");
        el4.sendKeys("11111111");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\" Female\"]");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[4]");
        el6.sendKeys("1712069@abc.com");
        MobileElement el7 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField[1]");
        el7.sendKeys("Lqh@1234");
        MobileElement el8 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField[2]");
        el8.sendKeys("Lqh@1234");
        MobileElement el9 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\" Standard\"]");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Sign Up\"]");
        el10.click();
        try{
            MobileElement el2 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"SCLAlertView\"]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText");
            Assert.assertTrue(el2.getAttribute("name").equals("Success"));
        } catch (Exception e){
            Assert.fail();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}