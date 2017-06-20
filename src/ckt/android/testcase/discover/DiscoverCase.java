package ckt.android.testcase.discover;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ckt.App.Util.Draw;
import ckt.App.Util.VP;
import ckt.android.action.AccountAction;
import ckt.android.action.DiscoverAction;
import ckt.android.action.MainAction;

public class DiscoverCase extends VP{
	@BeforeMethod
	@Parameters({ "port", "udid" ,"address","username","password"})
	public void setup(String port, String udid,String address,String username,String password){
		startAppiumDriver(address,port,udid,username,password);
		AccountAction.inLogin();
	}
	@AfterMethod
	public void teadDown(){
		stopAppiumDriver();
	}
	@Test(invocationCount = 20)
	public void testPlayRecommandVideo(){
		MainAction.clickDiscover();
		DiscoverAction.clickRecommand();
		swipeToUp(1000, getRandom());

		DiscoverAction.playRcommandVideo();
		DiscoverAction.waitVideoLoading();
		Draw.takeScreenShot();
		pressBack(1);
	}
	@Test  (invocationCount = 5)
	public void testPlayNewestVideo(){
		MainAction.clickDiscover();
		DiscoverAction.clickNewest();
		swipeToUp(1000, getRandom());

		DiscoverAction.playNewsetVideo();
		DiscoverAction.waitVideoLoading();
		Draw.takeScreenShot();
		pressBack(1);
	}
	@Test (invocationCount = 5)
	public static void testRecommandSwip(){
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
		MainAction.clickDiscover();
		DiscoverAction.clickSearch();
		DiscoverAction.inputSearchString("a");
		DiscoverAction.waitSearchLoading();
		Draw.takeScreenShot();
		swipeToUp(1000, getRandom());
		DiscoverAction.clickSearchResultAddFollow();
		Draw.takeScreenShot();
	}
}
