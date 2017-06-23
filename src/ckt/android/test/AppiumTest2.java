package ckt.android.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ckt.App.Util.BaseAppium;
import ckt.android.action.AccountAction;

public class AppiumTest2  extends BaseAppium{
	@BeforeSuite
	@Parameters({ "port", "udid" ,"address","username","password","apk","automationName"})
	public void beforeSuite(String port, String udid,String address,String username,String password,String apk,String automationName){
		startAppiumDriver(address,port,udid,username,password,apk,automationName);
	}
	@BeforeMethod
	public void beforeMethod(){
		AccountAction.inLogin();
	}
	@AfterSuite
	public void teadDown(){
		stopAppiumDriver();
	}
	@Test
	public void testCa(){
		//WebElement sound = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"推荐\")");
		getDriver().findElementByAndroidUIAutomator("new UiSelector().text(\"推荐\")").click();
		getDriver().findElementByAndroidUIAutomator("new UiSelector().text(\"最新\")").click();
	}
	@Test
	public void testCb(){
		//WebElement sound = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"推荐\")");
		getDriver().findElementByAndroidUIAutomator("new UiSelector().text(\"推荐\")").click();
		getDriver().findElementByAndroidUIAutomator("new UiSelector().text(\"最新\")").click();
	}
}
