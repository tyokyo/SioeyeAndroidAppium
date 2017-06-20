package ckt.android.action;

import ckt.App.Util.Draw;
import ckt.App.Util.VP;
import ckt.android.page.MainPage;

public class MainAction extends VP{
	/**
	 * 发现
	 *
	 * @param Null
	 */
	public static void clickDiscover(){
		clickById(MainPage.discover_id);
	}
	/**
	 * 关注
	 *
	 * @param Null
	 */
	public static void clickLive(){
		clickById(MainPage.live_id);
	}
	/**
	 * 我
	 *
	 * @param Null
	 */
	public static void clickMe(){
		clickById(MainPage.me_id);
	}
	/**
	 * 远程
	 *
	 * @param Null
	 */
	public static void clickRemote(){
		clickById(MainPage.remote_id);
	}
}
