package ckt.android.action.me;

import org.openqa.selenium.By;

import ckt.App.Util.VP;
import ckt.android.action.MainAction;
import ckt.android.page.me.MePage;

public class MeMainAction extends VP{
	/**
	 * click-编辑按钮
	 *
	 * @param Null
	 */
	public static void clickUserEdit(){
		clickById(MePage.user_edit_id);
	}
	/**
	 * click-直播按钮
	 *
	 * @param Null
	 */
	public static void clickLive(){
		getElementById(MePage.page_navigate_id).findElements(By.className("android.widget.LinearLayout")).get(0).click();
	}
	/**
	 * click-关注按钮
	 *
	 * @param Null
	 */
	public static void clickFollow(){
		getElementById(MePage.page_navigate_id).findElements(By.className("android.widget.LinearLayout")).get(1).click();
	}
	/**
	 * click-粉丝按钮
	 *
	 * @param Null
	 */
	public static void clickFans(){
		getElementById(MePage.page_navigate_id).findElements(By.className("android.widget.LinearLayout")).get(2).click();
	}
	/**
	 * to-直播配置
	 *
	 * @param Null
	 */
	public static void navToLiveConfig(){
		MainAction.clickMe();
		clickLiveConfig();
	}
	/**
	 * to-我的二维码
	 *
	 * @param Null
	 */
	public static void navToMyQRCode(){
		MainAction.clickMe();
		clickMyQrCode();
	}
	/**
	 * to-消息
	 *
	 * @param Null
	 */
	public static void navToMessage(){
		MainAction.clickMe();
		clickMessage();
	}
	/**
	 * to-相机
	 *
	 * @param Null
	 */
	public static void navToCamera(){
		MainAction.clickMe();
		clickCamera();
	}
	/**
	 * to-设置
	 *
	 * @param Null
	 */
	public static void navToSettings(){
		MainAction.clickMe();
		clickSetting();
	}
	/**
	 * to-设置
	 *
	 * @param Null
	 */
	public static void navToUserEdit(){
		MainAction.clickMe();
		clickUserEdit();
	}
	/**
	 * click-直播配置
	 *
	 * @param Null
	 */
	public static void clickLiveConfig(){
		clickByText("直播配置");
		wait(2);
		waitUntilByFind(By.id(MePage.live_title_id), 10);
	}
	/**
	 * click-我的二维码
	 *
	 * @param Null
	 */
	public static void clickMyQrCode(){
		clickByText("我的二维码");
	}
	/**
	 * click-消息
	 *
	 * @param Null
	 */
	public static void clickMessage(){
		clickByText("消息");
	}
	/**
	 * click-相机
	 *
	 * @param Null
	 */
	public static void clickCamera(){
		clickByText("相机");
	}
	/**
	 * click-设置
	 *
	 * @param Null
	 */
	public static void clickSetting(){
		clickByText("设置");
	}
	/**
	 * click-分享
	 *
	 * @param Null
	 */
	public static void clickShare(){
		clickByClassName("android.widget.ImageView");
	}
	/**
	 *Get-用户名
	 *
	 *@param Null
    * @return  用户名
	 *@
	 */
	public static void getUserName(){
		getElementById(MePage.username_id).getText();
	}
	/**
	 *Get-sioeye id
	 *
	 *@param Null
    * @return  sioeye id
	 *@
	 */
	public static void getUserId(){
		getElementById(MePage.user_sioyeye_id).getText();
	}
}
