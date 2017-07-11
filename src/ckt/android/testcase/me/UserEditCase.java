package ckt.android.testcase.me;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ckt.App.Util.Draw;
import ckt.App.Util.VP;
import ckt.android.action.me.MeAction;
import ckt.android.action.me.MeMainAction;
import ckt.android.page.me.MePage;

public class UserEditCase extends VP{
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
	public void testEditNickNameEn(){
		initializeScript();

		MeMainAction.navToUserEdit();
		MeAction.clickNickName();
		String expect = getRandomString(7);
		setText(MeAction.getNickNameElement(),expect );
		MeAction.clickSure();
		String active = MeAction.getNickNameContent();
		Assert.assertEquals(active, expect,"修改昵称");
		Draw.takeScreenShotWithDraw("修改昵称");
	}
	@Test
	public void testEditNickNameCn(){
		initializeScript();

		MeMainAction.navToUserEdit();
		MeAction.clickNickName();
		String expect = "扛把子";
		setText(MeAction.getNickNameElement(),expect );
		MeAction.clickSure();
		waitUntilByFind(By.id(MePage.nickname_id), 5);
		String active = MeAction.getNickNameContent();
		Assert.assertEquals(active, expect,"修改昵称");
		Draw.takeScreenShotWithDraw("修改昵称");
	}
	@Test
	public void testEditSexMale(){
		initializeScript();

		MeMainAction.navToUserEdit();
		MeAction.clickSex();
		MeAction.clickSex_Male();
		waitUntilByFind(By.id(MePage.sex_id), 5);
		reStartApp();

		MeMainAction.navToUserEdit();
		String active = MeAction.getSexContent();
		Assert.assertEquals(active, "男","修改性别");
		Draw.takeScreenShotWithDraw("修改性别");
	}
	@Test
	public void testEditSexFeMale(){
		initializeScript();

		MeMainAction.navToUserEdit();
		MeAction.clickSex();
		MeAction.clickSex_FeMale();
		waitUntilByFind(By.id(MePage.sex_id), 5);
		reStartApp();

		MeMainAction.navToUserEdit();
		String active = MeAction.getSexContent();
		Assert.assertEquals(active, "女","修改性别");
		Draw.takeScreenShotWithDraw("修改性别");
	}
	@Test
	public void testEditSexSecert(){
		initializeScript();

		MeMainAction.navToUserEdit();
		MeAction.clickSex();
		MeAction.clickSex_Other();
		waitUntilByFind(By.id(MePage.sex_id), 5);
		reStartApp();

		MeMainAction.navToUserEdit();
		String active = MeAction.getSexContent();
		Assert.assertEquals(active, "保密","修改性别");
		Draw.takeScreenShotWithDraw("修改性别");
	}
	@Test
	public void testLocation(){
		initializeScript();

		MeMainAction.navToUserEdit();
		MeAction.clickLocation();
		MeAction.getLocationName().click();
		waitUntilByTextContains("当前位置", 30);
		Draw.takeScreenShotWithDraw("定位");
	}
	@Test
	public void testLocationSearch(){
		initializeScript();
		MeMainAction.navToUserEdit();
		MeAction.clickLocation();
		setText(MeAction.getLocationSearchElement(), "北京");
		//getDriver().removeApp("io.appium.android.ime");
		MeAction.getLocationSearchElement().click();
		wait(3);
		//MeAction.getLocationName().click();
		//waitUntilByTextContains("当前位置", 30);
		//Draw.takeScreenShotWithDraw("定位");
	}
	@Test
	public void testDeleteAllInterest(){
		initializeScript();
		
		MeMainAction.navToUserEdit();
		MeAction.clickInterest();
		MeAction.deleteAllDisplayInterest();
		
		MeAction.clickSure();
		
		boolean idDeleClearexpected=existById(MePage.interest_display_id);
		Assert.assertEquals(false, idDeleClearexpected);
	}
	@Test
	public void testAddAllRecomandInterest(){
		initializeScript();
		MeMainAction.navToUserEdit();
		MeAction.clickInterest();
		MeAction.deleteAllDisplayInterest();
		MeAction.allAllRecommandInterest();
		MeAction.clickSure();
	}
}
