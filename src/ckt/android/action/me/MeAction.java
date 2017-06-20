package ckt.android.action.me;

import ckt.App.Util.VP;
import ckt.android.action.MainAction;
import ckt.android.page.me.MePage;

public class MeAction extends VP{
	/**
	 * click-直播标题
	 *
	 * @param Null
	 */
	public static void clickLiveSetting_LiveTitle(){
		clickById(MePage.live_title_id);
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
