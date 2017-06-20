package ckt.android.action;

import org.openqa.selenium.By;

import ckt.App.Util.VP;
import ckt.android.page.FollowPage;

public class FollowAction extends VP{
	/**
	 * click-搜索
	 *
	 * @param Null
	 */
	public static void clickSearch(){
		clickById(FollowPage.search_id);
	}
	
	/**
	 * click-搜索-添加关注
	 *
	 * @param Null
	 */
	public static void clickAddFollow(){
		clickById(FollowPage.search_user_add_user_follow_id);
	}
	/**
	 * input-搜索-内容
	 *
	 * @param Null
	 */
	public static void inputSearchFilter(String content){
		getElementById(FollowPage.search_filter_input_id).sendKeys(content);
	}
	/**
	 * click-取消
	 *
	 * @param Null
	 */
	public static void clickSearch_Cancel(String content){
		clickByText("取消");
	}
}
