package ckt.android.test.me;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ckt.App.Util.VP;
import ckt.android.action.AccountAction;

public class AppiumTest  extends VP{
	@BeforeSuite
	@Parameters({ "port", "udid" ,"address","username","password","apk","automationName"})
	public void beforeSuite(String port, String udid,String address,String username,String password,String apk,String automationName){
		startAppiumDriver(address,port,udid,username,password,apk,automationName);
	}
	@AfterSuite
	public void teadDown(){
		stopAppiumDriver();
	}
	@BeforeMethod
	public void BeforeMethod(){
		reStartApp();
	}
	@Test
	public void testA(){
		//WebElement sound = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"推荐\")");
		getDriver().findElementByAndroidUIAutomator("new UiSelector().text(\"推荐\")").click();
		getDriver().findElementByAndroidUIAutomator("new UiSelector().text(\"最新\")").click();
		
		swipeToDown(1000, 5);
		
		swipeToUp(1000, 5);
	}
	@Test
	public void testB(){
		//WebElement sound = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"推荐\")");
		getDriver().findElementByAndroidUIAutomator("new UiSelector().text(\"推荐\")").click();
		getDriver().findElementByAndroidUIAutomator("new UiSelector().text(\"最新\")").click();
	}
}
