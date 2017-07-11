package ckt.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
 


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
 
public class zhiHu {
    private  AndroidDriver  driver;
 
    @BeforeMethod(alwaysRun=true)
    public void setUp() throws Exception {
        // set up appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","BBN4T17210000082");
        //capabilities.setCapability("platformVersion", "6.0.1");
        //if no need install don't add this
        capabilities.setCapability("app", "/Users/Qiang.Zhang/Desktop/software/apk/Sioeye2.0_APP_S11A_100-2.0.68.apk");
        capabilities.setCapability("appPackage", "cn.sioeye.sioeyeapp");
        //support Chinese 
        capabilities.setCapability("unicodeKeyboard" ,"True");
        capabilities.setCapability("resetKeyboard", "True");
        //no need sign
       // capabilities.setCapability("noSign", "false");
        //capabilities.setCapability("appActivity", ".main.MainActivity ");
        driver = new AndroidDriver(new URL("http://10.120.3.243:4727/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
    }
 
    @AfterMethod(alwaysRun=true)
    public void tearDown() throws Exception {
        driver.quit();
    }
 
    @Test(groups={"ZHTest"})
    public void Login(){
        //find login button
        
    	driver.findElementByAndroidUIAutomator("new UiSelector().text(\"推荐\")").click();
    	driver.findElementByClassName("android.widget.ImageView").click();
    }
}
