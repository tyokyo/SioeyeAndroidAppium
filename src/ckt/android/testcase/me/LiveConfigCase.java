package ckt.android.testcase.me;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ckt.App.Util.VP;
import ckt.android.action.me.MeAction;
import ckt.android.action.me.MeMainAction;
import ckt.android.page.me.MePage;

public class LiveConfigCase extends VP{
	@BeforeSuite
	@Parameters({ "port", "udid" ,"address","username","password","apk","automationName"})
	public void beforeSuite(String port, String udid,String address,String username,String password,String apk,String automationName){
		startAppiumDriver(address,port,udid,username,password,apk,automationName);
	}
	@AfterSuite
	public void afterSuite(){
		stopAppiumDriver();
	}

	@Test
	public void testModifyTitleEn(){
		initializeScript();
		
		MeMainAction.navToLiveConfig();
		MeAction.clickLiveSetting_LiveTitle();
		String expectLiveTitle=getRandomString(15);
		setText(MeAction.getLiveTitleElement(),expectLiveTitle);
		MeAction.clickSure();
		//等待保存完成
		waitUntilByGone(By.id(MePage.sure_id), 20);
		reStartApp();
		MeMainAction.navToLiveConfig();
		String activeLiveTitle=MeAction.getLiveTitleContent();
		Assert.assertEquals(activeLiveTitle, expectLiveTitle, "修改直播标题");
	}
	@Test
	public void testModifyTitleCn(){
		initializeScript();
		
		MeMainAction.navToLiveConfig();
		MeAction.clickLiveSetting_LiveTitle();
		String expectLiveTitle="2017俄罗斯世界杯";
		setText(MeAction.getLiveTitleElement(),expectLiveTitle);
		MeAction.clickSure();
		//等待保存完成
		waitUntilByGone(By.id(MePage.sure_id), 20);
		reStartApp();
		MeMainAction.navToLiveConfig();
		String activeLiveTitle=MeAction.getLiveTitleContent();
		Assert.assertEquals(activeLiveTitle, expectLiveTitle, "修改直播标题");
	}
	@Test
	public void testLivePrivacyPublic(){
		initializeScript();
		
		MeMainAction.navToLiveConfig();
		MeAction.clickLiveSetting_LivePrivacy();
		MeAction.clickLiveSetting_LivePrivacy_public();;
		MeAction.clickSure();
		//等待保存完成
		waitUntilByGone(By.id(MePage.sure_id), 20);
		reStartApp();
		MeMainAction.navToLiveConfig();
		String active =MeAction.getLiveWhoCanView();
		Assert.assertEquals(active, "公开", "公开");
	}
	@Test
	public void testLivePrivacyPrivate(){
		initializeScript();
		
		MeMainAction.navToLiveConfig();
		MeAction.clickLiveSetting_LivePrivacy();
		MeAction.clickLiveSetting_LivePrivacy_private();
		MeAction.clickSure();
		//等待保存完成
		waitUntilByGone(By.id(MePage.sure_id), 20);
		reStartApp();
		MeMainAction.navToLiveConfig();
		String active =MeAction.getLiveWhoCanView();
		Assert.assertEquals(active, "私密", "私密");
	}
	@Test
	public void testLivePrivacyPersonal(){
		initializeScript();
		
		MeMainAction.navToLiveConfig();
		MeAction.clickLiveSetting_LivePrivacy();
		MeAction.clickLiveSetting_LivePrivacy_personal();
		//选择可见的好友
		MeAction.clickLiveSetting_LivePrivacy_personal_selectpeople();
		reStartApp();
		MeMainAction.navToLiveConfig();
		String active =MeAction.getLiveWhoCanView();
		Assert.assertEquals(active, "部分可见", "部分可见");
	}
}
