package ckt.android.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ckt.App.Util.Draw;
import ckt.App.Util.VP;
import ckt.android.action.DiscoverAction;
import ckt.android.action.MainAction;

public class Seledroid extends VP{
	@BeforeSuite
	@Parameters({ "port", "udid" ,"address","username","password","apk","automationName"})
	public void beforeSuite(String port, String udid,String address,String username,String password,String apk,String automationName){
		startAppiumDriver(address,port,udid,username,password,apk,automationName);
	}
	@AfterSuite
	public void afterSuite(){
		stopAppiumDriver();
	}
	@Test(invocationCount = 20)
	public void testPlayRecommandVideo(){
		initializeScript();

		MainAction.clickDiscover();
		Draw.takeScreenShotWithDraw("Discover");
		DiscoverAction.clickRecommand();
		swipeToUp(200, getRandom());

		DiscoverAction.playRcommandVideo();
		DiscoverAction.waitVideoLoading();
		Draw.takeScreenShotWithDraw("waitVideoLoading");
		pressBack(1);
	}
	@Test  (invocationCount = 20)
	public void testPlayNewestVideo(){
		initializeScript();

		MainAction.clickDiscover();
		Draw.takeScreenShotWithDraw("Discover");
		DiscoverAction.clickNewest();
		swipeToUp(1000, getRandom());
		Draw.takeScreenShotWithDraw("最新");
		
		DiscoverAction.playNewsetVideo();
		DiscoverAction.waitVideoLoading();
		Draw.takeScreenShotWithDraw("waitVideoLoading");
		pressBack(1);
	}
}
