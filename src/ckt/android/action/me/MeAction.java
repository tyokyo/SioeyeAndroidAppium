package ckt.android.action.me;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ckt.App.Util.VP;
import ckt.android.action.MainAction;
import ckt.android.page.me.MePage;

public class MeAction extends VP{

	/**
	 * 获取-位置
	 *
	 * @param Null
	 */
	public static WebElement getLocationName(){
		return getElementById(MePage.location_name_id);
	}
	/**
	 * click-性别
	 *
	 * @param Null
	 */
	public static void clickSex(){
		//getDriver().findElementByAndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", "昵称")).click();;
		clickById(MePage.sex_id);
	}
	/**
	 * click-性别-male
	 *
	 * @param Null
	 */
	public static void clickSex_Male(){
		//getDriver().findElementByAndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", "昵称")).click();;
		clickById(MePage.sex_male_id);
	}
	/**
	 * click-性别-female
	 *
	 * @param Null
	 */
	public static void clickSex_FeMale(){
		//getDriver().findElementByAndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", "昵称")).click();;
		clickById(MePage.se_female_id);
	}
	/**
	 * 性别内容
	 *
	 * @param Null
	 */
	public static String getSexContent(){
		return getElementById(MePage.sex_id).findElement(By.id(MePage.live_content_id)).getText();
	}
	/**
	 * click-性别-保密
	 *
	 * @param Null
	 */
	public static void clickSex_Other(){
		//getDriver().findElementByAndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", "昵称")).click();;
		clickById(MePage.sex_other_id);
	}

	/**
	 * click-位置
	 *
	 * @param Null
	 */
	public static void clickLocation(){
		//getDriver().findElementByAndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", "昵称")).click();;
		clickById(MePage.location_id);
	}
	/**
	 * click-位置
	 *
	 * @param Null
	 */
	public static WebElement getLocationSearchElement(){
		return getElementById(MePage.location_search_id);
	}
	/**
	 * click-爱好
	 *
	 * @param Null
	 */
	public static void clickInterest(){
		//getDriver().findElementByAndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", "昵称")).click();;
		clickById(MePage.interest_id);
	}
	public static void clickDisplayInterest(){
		//getDriver().findElementByAndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", "昵称")).click();;
		clickById(MePage.interest_display_id);
	}
	public static void clickAddInterest(){
		clickById(MePage.interest_add_id);
	}
	public static WebElement getInterestAddElement(){
		return getElementById(MePage.interest_add_content_id);
	}
	public static void deleteAllDisplayInterest(){
		List<WebElement> elements =(List<WebElement>) getDriver().findElements(By.id(MePage.interest_display_id));
		int size=elements.size();
		log("deleteAllDisplayInterest-"+size);
		for (int i = 0; i < size; i++) {
			clickDisplayInterest();
			wait(2);
		}
	}
	public static void allAllRecommandInterest(){
		List<WebElement> elements =(List<WebElement>) getDriver().findElements(By.id(MePage.interest_recommand_id));
		for (WebElement webElement : elements) {
			webElement.click();
			wait(2);
		}
	}
	public static void addInterest(String interest){
		clickAddInterest();
		setText(getInterestAddElement(), getRandomString(4));
	}
	/**
	 * click-个性签名
	 *
	 * @param Null
	 */
	public static void clickAbout(){
		//getDriver().findElementByAndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", "昵称")).click();;
		clickById(MePage.about_id);
	}
	/**
	 * click-昵称
	 *
	 * @param Null
	 */
	public static void clickNickName(){
		//getDriver().findElementByAndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", "昵称")).click();;
		clickById(MePage.nickname_id);
	}
	/**
	 * 获取-昵称对象
	 *
	 * @param Null
	 */
	public static WebElement getNickNameElement(){
		//getDriver().findElementByAndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", "昵称")).click();;
		return getElementById(MePage.live_title_content_id);
	}
	/**
	 * 昵称内容
	 *
	 * @param Null
	 */
	public static String getNickNameContent(){
		return getElementById(MePage.nickname_id).findElement(By.id(MePage.live_content_id)).getText();
	}
	/**
	 * click-直播标题
	 *
	 * @param Null
	 */
	public static void clickLiveSetting_LiveTitle(){
		//clickByText("直播标题");
		//getDriver().findElementByAndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", "直播标题")).click();;
		clickById(MePage.live_title_id);
	}
	/**
	 * click-直播标题-修改-(确认)
	 *
	 * @param Null
	 */
	public static void clickSure(){
		clickById(MePage.sure_id);
		wait(3);
	}
	/**
	 * click--修改-(保存)
	 *
	 * @param Null
	 */
	public static void clickDone(){
		clickById(MePage.done_id);
	}
	/**
	 * 直播标题内容
	 *
	 * @param Null
	 */
	public static WebElement getLiveTitleElement(){
		return getElementById(MePage.live_title_content_id);
	}
	/**
	 * 直播标题内容
	 *
	 * @param Null
	 */
	public static String getLiveTitleContent(){
		return getElementById(MePage.live_title_id).findElement(By.id(MePage.live_content_id)).getText();
	}
	/**
	 * 直播-谁可以看我的直播
	 *
	 * @param Null
	 */
	public static String getLiveWhoCanView(){
		return getElementById(MePage.live_privacy_id).findElement(By.id(MePage.live_content_id)).getText();
	}

	/**
	 * click-谁可以看我的直播
	 *
	 * @param Null
	 */
	public static void clickLiveSetting_LivePrivacy(){
		clickById(MePage.live_privacy_id);
	}
	/**
	 * click-谁可以看我的直播-公开
	 *
	 * @param Null
	 */
	public static void clickLiveSetting_LivePrivacy_public(){
		clickByText("公开");
	}
	/**
	 * click-谁可以看我的直播-密码
	 *
	 * @param Null
	 */
	public static void clickLiveSetting_LivePrivacy_private(){
		clickByText("私密");
	}
	/**
	 * click-谁可以看我的直播-部分可见
	 *
	 * @param Null
	 */
	public static void clickLiveSetting_LivePrivacy_personal(){
		clickByText("部分可见");
	}
	/**
	 * click-谁可以看我的直播-部分可见-选择好友
	 *
	 * @param Null
	 */
	public static void clickLiveSetting_LivePrivacy_personal_selectpeople(){
		if (existById(MePage.live_personal_selected_id)) {
			MeAction.clickDone();
			waitUntilByGone(By.id(MePage.done_id), 20);
			MeAction.clickSure();
			waitUntilByGone(By.id(MePage.sure_id), 20);
		}else {
			clickById(MePage.live_personal_select_id);
			MeAction.clickDone();
			waitUntilByGone(By.id(MePage.done_id), 20);
			MeAction.clickSure();
			waitUntilByGone(By.id(MePage.sure_id), 20);
		}
	}
	/**
	 * click-同步直播到
	 *
	 * @param Null
	 */
	public static void clickLiveSetting_LiveTo(){
		clickById(MePage.live_to_id);
	}
	/**
	 * click-相机-添加设备
	 *
	 * @param Null
	 */
	public static void clickCamera_AddDevice(){
		clickById(MePage.camera_add_device_id);
	}
	/**
	 * click-相机-了解sioeye相机
	 *
	 * @param Null
	 */
	public static void clickCamera_LearnDevice(){
		clickById(MePage.camera_learn_device_id);
	}
	/**
	 * click-设置-允许在移动网络下直播
	 *
	 * @param Null
	 */
	public static void clickSetting_3g_network(){
		clickById(MePage.setting_3g_network_id);
	}
	/**
	 * click-设置-推送通知
	 *
	 * @param Null
	 */
	public static void clickSetting_PushMessage(){
		clickByText("推送通知");
	}
	/**
	 * click-设置-账号与安全
	 *
	 * @param Null
	 */
	public static void clickSetting_AccountSecurity(){
		clickByText("账号与安全");
	}
	/**
	 * click-设置-意见反馈
	 *
	 * @param Null
	 */
	public static void clickSetting_Feedback(){
		clickByText("意见反馈");
	}
	/**
	 * click-设置-检查更新
	 *
	 * @param Null
	 */
	public static void clickSetting_checkUpdate(){
		clickByText("检查更新");
	}
	/**
	 * click-设置-帮助中心
	 *
	 * @param Null
	 */
	public static void clickSetting_HelpCenter(){
		clickByText("帮助中心");
	}
	/**
	 * click-设置-关于Sioeye
	 *
	 * @param Null
	 */
	public static void clickSetting_AboutSioeye(){
		clickByText("关于Sioeye");
	}

	/**
	 * click-粉丝-添加关注
	 *
	 * @param Null
	 */
	public static void clickFans_AddFollow(){
		clickById(MePage.fans_add_id);
	}
	/**
	 * click-账号与安全-退出登录
	 *
	 * @param Null
	 */
	public static void clickAccountSecurity_LogOut(){
		clickByText("退出登录");
	}
	/**
	 * click-账号与安全-退出登录-确定
	 *
	 * @param Null
	 */
	public static void clickAccountSecurity_LogOut_OK(){
		clickByText("确定");
	}
	/**
	 * click-账号与安全-手机号码
	 *
	 * @param Null
	 */
	public static void clickAccountSecurity_PhoneNumber(){
		clickByText("手机号码");
	}
	/**
	 * click-账号与安全-邮箱地址
	 *
	 * @param Null
	 */
	public static void clickAccountSecurity_EmailAddress(){
		clickByText("邮箱地址");
	}
	/**
	 * click-账号与安全-修改密码
	 *
	 * @param Null
	 */
	public static void clickAccountSecurity_ModifyPassword(){
		clickByText("修改密码");
	}
	public static void navToPuhNotification(){
		MainAction.clickMe();
		MeMainAction.clickSetting();
		MeAction.clickSetting_PushMessage();
	}
	public static void navToAccountSecurity(){
		MainAction.clickMe();
		MeMainAction.clickSetting();
		MeAction.clickSetting_AccountSecurity();
	}
	public static void navToFeedback(){
		MainAction.clickMe();
		MeMainAction.clickSetting();
		MeAction.clickSetting_Feedback();
	}
	public static void navToCheckUpdate(){
		MainAction.clickMe();
		MeMainAction.clickSetting();
		MeAction.clickSetting_checkUpdate();
	}
	public static void navToHelpCenter(){
		MainAction.clickMe();
		MeMainAction.clickSetting();
		MeAction.clickSetting_HelpCenter();
	}
	public static void navToAboutSioeye(){
		MainAction.clickMe();
		MeMainAction.clickSetting();
		MeAction.clickSetting_AboutSioeye();
	}
}
