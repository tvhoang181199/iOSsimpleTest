import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SigninTest {
   private IOSDriver driver;

   // Input
   private XSSFWorkbook wb;
   private XSSFSheet sheet;
   private FileInputStream fis;


   // Output
    private XSSFWorkbook wbOut;
    private XSSFSheet sheetOut;
    private FileOutputStream fos;
    private int rowCount;

   @Before
   public void setUp() throws IOException {
       File src = new File("/Users/huonglam/Documents/HCMUS/HK1-4/Kiểm thử/Deadline/iOSsimpleTest/Book1.xlsx");
       File src2 = new File("/Users/huonglam/Documents/HCMUS/HK1-4/Kiểm thử/Deadline/iOSsimpleTest/Book2.xlsx");
       fis = new FileInputStream(src);
       fos = new FileOutputStream(src2);
       wb = new XSSFWorkbook(fis);
       sheet = wb.getSheetAt(0);

       wbOut = new XSSFWorkbook();
       sheetOut = wbOut.createSheet("Result");
       rowCount = 0;

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
  public void Signin() throws IOException {
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

      Row rowHeader = sheetOut.createRow(0);
      rowHeader.createCell(0).setCellValue("STT");
      rowHeader.createCell(1).setCellValue("Experted Result");
      rowHeader.createCell(2).setCellValue("Actual Result");
      rowHeader.createCell(3).setCellValue("Status");

      for(int i = 1; i < 4; ++i){
          driver.resetApp();
          String data1 = sheet.getRow(i).getCell(0).getStringCellValue();
          MobileElement el = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");
          el.sendKeys(data1);
          String data2 = sheet.getRow(i).getCell(1).getStringCellValue();
          MobileElement e2 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField");
          e2.sendKeys(data2);
          MobileElement e3 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Login\"]");
          e3.click();
          boolean res = false;
          try{
              MobileElement e4 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sneakers Management\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage");
              res = true;
          } catch(Exception e){
              res = false;
          } finally {
              Row row = sheetOut.createRow(++rowCount);

              Cell cell0 = row.createCell(0);
              cell0.setCellValue(i);

              Boolean rowBoolean = sheet.getRow(i).getCell(2).getBooleanCellValue();
              Cell cell1 = row.createCell(1);
              cell1.setCellValue(rowBoolean);

              Cell cell2 = row.createCell(2);
              cell2.setCellValue(res);

              Cell cell3 = row.createCell(3);
              cell3.setCellValue((rowBoolean == res)?"Passed":"Failed");
          }
      }
      wbOut.write(fos);
  }

  @After
  public void tearDown() throws IOException {
      driver.quit();
      fis.close();
      fos.close();
  }

}
