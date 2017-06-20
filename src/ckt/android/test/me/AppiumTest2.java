package ckt.android.test.me;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ckt.App.Util.BaseAppium;

public class AppiumTest2  extends BaseAppium{
	@BeforeSuite
	@Parameters({ "port", "udid" ,"address","username","password"})
	public void setup(String port, String udid,String address,String username,String password){
		startAppiumDriver(address,port,udid,username,password);
	}
	@AfterSuite
	public void teadDown(){
		stopAppiumDriver();
	}
	@BeforeTest
	public void BeforeTest(){
		getDriver().resetApp();
	}
	@Test
	public void testC(){
		//WebElement sound = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"推荐\")");
		getDriver().findElementByAndroidUIAutomator("new UiSelector().text(\"推荐\")").click();
		getDriver().findElementByAndroidUIAutomator("new UiSelector().text(\"最新\")").click();
	}
	@Test
	public void testD(){
		//WebElement sound = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"推荐\")");
		getDriver().findElementByAndroidUIAutomator("new UiSelector().text(\"推荐\")").click();
		getDriver().findElementByAndroidUIAutomator("new UiSelector().text(\"最新\")").click();
	}
}
