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
	@Parameters({ "port", "udid" ,"address","username","password","apk"})
	public void beforeSuite(String port, String udid,String address,String username,String password,String apk){
		startAppiumDriver(address,port,udid,username,password,apk);
	}
	@AfterSuite
	public void afterSuite(){
		stopAppiumDriver();
	}

	@Test
	public void testModifyTitle(){
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
	public void testLivePrivacyPublic(){
		MeMainAction.navToLiveConfig();
		MeAction.clickLiveSetting_LivePrivacy();
		MeAction.clickLiveSetting_LivePrivacy_public();;
		MeAction.clickSure();
		//等待保存完成
		waitUntilByGone(By.id(MePage.sure_id), 20);
		reStartApp();
		MeMainAction.navToLiveConfig();
		MeAction.clickLiveSetting_LivePrivacy();
		String active =MeAction.getLiveWhoCanView();
		Assert.assertEquals(active, "公开", "公开");
	}
	@Test
	public void testLivePrivacyPrivate(){
		MeMainAction.navToLiveConfig();
		MeAction.clickLiveSetting_LivePrivacy();
		MeAction.clickLiveSetting_LivePrivacy_private();
		MeAction.clickSure();
		//等待保存完成
		waitUntilByGone(By.id(MePage.sure_id), 20);
		reStartApp();
		MeMainAction.navToLiveConfig();
		MeAction.clickLiveSetting_LivePrivacy();
		String active =MeAction.getLiveWhoCanView();
		Assert.assertEquals(active, "秘密", "秘密");
	}
	@Test
	public void testLivePrivacyPersonal(){
		MeMainAction.navToLiveConfig();
		MeAction.clickLiveSetting_LivePrivacy();
		MeAction.clickLiveSetting_LivePrivacy_personal();
		//选择可见的好友
		MeAction.clickLiveSetting_LivePrivacy_personal_selectpeople();
		reStartApp();
		MeMainAction.navToLiveConfig();
		MeAction.clickLiveSetting_LivePrivacy();
		
		String active =MeAction.getLiveWhoCanView();
		Assert.assertEquals(active, "部分可见", "部分可见");
	}
}
