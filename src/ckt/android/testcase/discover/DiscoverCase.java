package ckt.android.testcase.discover;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ckt.App.Util.Draw;
import ckt.App.Util.VP;
import ckt.App.Util.VP2;
import ckt.android.action.DiscoverAction;
import ckt.android.action.MainAction;

public class DiscoverCase extends VP{
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
	@Test (invocationCount = 5)
	public static void testRecommandSwip(){
		initializeScript();

		MainAction.clickDiscover();
		DiscoverAction.clickRecommand();
		for (int i = 0; i < 20; i++) {
			swipeToUp(1000, getRandom());
			swipeToDown(1000, getRandom());
		}
		Draw.takeScreenShot();
	}
	@Test (invocationCount = 5)
	public static void testNewestSwip(){
		initializeScript();

		MainAction.clickDiscover();
		DiscoverAction.clickNewest();
		for (int i = 0; i < 20; i++) {
			swipeToUp(1000, getRandom());
			swipeToDown(1000, getRandom());
		}
		Draw.takeScreenShot();
	}
	@Test(invocationCount = 5)
	public static void testCloseRecommand(){
		initializeScript();

		MainAction.clickDiscover();
		for (int i = 0; i < 10; i++) {
			swipeToDown(1000, 3);
			waitUntilTextFind("你可能感兴趣", 30);
			DiscoverAction.clickRecommand();
		}
		Draw.takeScreenShot();
	}
	@Test(invocationCount = 5)
	public void testRecommandNewest(){
		initializeScript();

		MainAction.clickDiscover();
		for (int i = 0; i < 5; i++) {
			DiscoverAction.clickNewest();
			swipeToUp(1000, 3);
			DiscoverAction.clickRecommand();
			swipeToUp(1000, 3);
		}
		for (int i = 0; i < 5; i++) {
			DiscoverAction.clickNewest();
			swipeToDown(1000, getRandom());
			DiscoverAction.clickRecommand();
			swipeToDown(1000, getRandom());
		}
		Draw.takeScreenShot();
	}
	@Test(invocationCount = 5)
	public void testSearch(){
		initializeScript();

		MainAction.clickDiscover();
		DiscoverAction.clickSearch();
		DiscoverAction.inputSearchString("b");
		DiscoverAction.waitSearchLoading();
		DiscoverAction.clickVideo();
		DiscoverAction.clickUser();
		Draw.takeScreenShot();
	}
	@Test(invocationCount = 5)
	public void testSearchThenClear(){
		initializeScript();

		MainAction.clickDiscover();
		DiscoverAction.clickSearch();
		DiscoverAction.inputSearchString("a");
		DiscoverAction.waitSearchLoading();
		DiscoverAction.clickClearResult();
		DiscoverAction.clickVideo();
		DiscoverAction.clickUser();
		Draw.takeScreenShot();
	}
	@Test(invocationCount = 5)
	public void testSearchThenViewVideo(){
		initializeScript();

		MainAction.clickDiscover();
		DiscoverAction.clickSearch();
		DiscoverAction.inputSearchString("a");
		DiscoverAction.waitSearchLoading();
		DiscoverAction.clickVideo();
		DiscoverAction.playVideoInSearchList();
		DiscoverAction.waitVideoLoading();
		Draw.takeScreenShot();
		pressBack(2);
	}
	@Test(invocationCount = 5)
	public void testAddFollow(){
		initializeScript();

		MainAction.clickDiscover();
		DiscoverAction.clickSearch();
		DiscoverAction.inputSearchString("a");
		DiscoverAction.waitSearchLoading();
		Draw.takeScreenShot();
		swipeToUp(1000, getRandom());
		DiscoverAction.clickSearchResultAddFollow();
		Draw.takeScreenShot();
	}
	public void test(){
		initializeScript();

		MainAction.clickDiscover();
		for (int i = 0; i < 50; i++) {
			VP2.swipeToUp(1000, 5);
		}
	}
}
