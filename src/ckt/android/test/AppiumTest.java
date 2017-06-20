package ckt.android.test;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidElement;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import ckt.App.Util.Draw;
import ckt.App.Util.VP;
import ckt.App.Util.VP2;
import ckt.android.action.DiscoverAction;
import ckt.android.action.MainAction;
import ckt.android.page.DiscoverPage;

public class AppiumTest  extends VP{
	@BeforeSuite
	@Parameters({ "port", "udid" ,"address","username","password"})
	public void setup(String port, String udid,String address,String username,String password){
		startAppiumDriver(address,port,udid,username,password);
	}
	@AfterSuite
	public void teadDown(){
		stopAppiumDriver();
	}
	@BeforeMethod
	public void BeforeTest(){
		reStartApp();
	}
	@Test
	public void testAa() throws InterruptedException{
		//WebElement sound = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"推荐\")");
		
		clickByText("推荐");
		clickByText("最新");
		//waitUntilByGone(By.id(DiscoverPage.recommend_list_id), 20);
		clickByText("推荐");
		wait(3);
		//waitUntilByFind(By.id(DiscoverPage.recommend_list_id), 20);
		//Thread.sleep(5000);
		for (int i = 0; i < 1; i++) {
			VP2.swipOnElement((AndroidElement) getElementById(DiscoverPage.recommend_list_id),"LEFT", 100);
			//swipeTo(getElementById(DiscoverPage.recommend_list_id), "LEFT");
			wait(3);
		}
		DiscoverAction.closeRecommandList();
		//swipeToUp(600, 20);
		MainAction.clickDiscover();
		MainAction.clickLive();
	}
	//@Test
	public void testA4() throws InterruptedException{
		//WebElement sound = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"推荐\")");
		Draw.takeScreenShotWithDraw("this is my firest with this is my firest with1234567890qwertyuiopasdfghjklzxcvbnmthis is my firest with this is my firest with1234567890qwertyuiopasdfghjklzxcvbnm");
		clickByText("最新");
		clickByText("远s程");
		//waitUntilByGone(By.id(DiscoverPage.recommend_list_id), 20);
		wait(3);
	}
}
