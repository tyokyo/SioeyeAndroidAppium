package ckt.android.action;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ckt.App.Util.Draw;
import ckt.App.Util.VP;
import ckt.android.page.AccountPage;
import ckt.android.page.DiscoverPage;

public class DiscoverAction extends VP{
	 /**
     * 用户
     * @param void
     * @return  void
     */
	public static void clickUser(){
		String xpath = String.format("//android.widget.RadioButton[@text='%s']", "用户");
		clickByXpath(xpath);
	}
	 /**
     * 视频
     * @param void
     * @return  void
     */
	public static void clickVideo(){
		String xpath = String.format("//android.widget.RadioButton[@text='%s']", "视频");
		clickByXpath(xpath);
	}
	 /**
     * 推荐
     * @param void
     * @return  void
     */
	public static void clickRecommand(){
		clickById(DiscoverPage.recommend_id);
	}
	 /**
     * 最新
     * @param void
     * @return  void
     */
	public static void clickNewest(){
		clickById(DiscoverPage.newest_id);
	}
	 /**
     * 搜索按钮
     * @param void
     * @return  void
     */
	public static void clickSearch(){
		getDriver().findElementByClassName("android.widget.ImageView").click();
	}
	 /**
     * 清除搜索框内容
     * @param void
     * @return  void
     */
	public static void clickClearResult(){
		clickById(DiscoverPage.search_result_list_clear_id);
	}
	/**
	 *关闭推荐列表
	 *
	 * @param Null
	 */
	public static void closeRecommandList(){
		int y = getElementByText("你可能感兴趣").getLocation().getY();
		int x = getDriver().manage().window().getSize().width-10;
		click(x, y);
	}
	 /**
     * dismiss 按钮 评论@对方互动
     * @param void
     * @return  void
     */
	public static void clickDismiss(){
		clickById(DiscoverPage.dismiss_id);
	}
	/**
	 *观看推荐视频
	 *
	 * @param Null
	 */
	public static void playRcommandVideo(){
		WebElement swip = getElementById(DiscoverPage.swip_recommand_lit_id);
		List<WebElement> elements = swip.findElements(By.className("android.widget.RelativeLayout"));
		int size = elements.size();
		log("Video count is "+size);
		for (WebElement element : elements) {
			boolean find = false;
			try {
				element.findElement(By.id(DiscoverPage.media_avatar_id));
				element.findElement(By.className("android.view.View"));
				log("find avatar");
				find=true;
			} catch (Exception e) {
				// TODO: handle exception
				log("not find avatar");
			}
			if (find) {
				List<WebElement> textViewElements =element.findElements(By.className("android.widget.TextView"));
				for (WebElement textViewElement : textViewElements) {
					log(textViewElement.getText());
				}
				log("CLICK ELEMENT- PLAY VIDEO");
				clickElement(element);
				if (existById(DiscoverPage.dismiss_id)) {
					clickDismiss();
				}
				wait(3);
				Draw.takeScreenShotWithDraw("playVideo");
				break;
			}
		}
	}
	/**
	 *观看推荐视频
	 *
	 * @param Null
	 */
	public static void playNewsetVideo(){
		WebElement swip = getElementById(DiscoverPage.swip_newest_id);
		List<WebElement> elements = swip.findElements(By.className("android.widget.RelativeLayout"));
		int size = elements.size();
		log("Video count is "+size);
		for (WebElement element : elements) {
			boolean find = false;
			try {
				element.findElement(By.id(DiscoverPage.media_avatar_id));
				element.findElement(By.className("android.view.View"));
				log("find avatar");
				find=true;
			} catch (Exception e) {
				// TODO: handle exception
				log("not find avatar");
			}
			if (find) {
				List<WebElement> textViewElements =element.findElements(By.className("android.widget.TextView"));
				for (WebElement textViewElement : textViewElements) {
					log(textViewElement.getText());
				}
				log("CLICK ELEMENT- PLAY VIDEO");
				clickElement(element);
				if (existById(DiscoverPage.dismiss_id)) {
					clickDismiss();
				}
				wait(3);
				Draw.takeScreenShotWithDraw("playVideo");
				break;
			}
		}
	}
	public static void waitVideoLoading(){
		//wait(30);
		//waitUntilByFind(By.id(DiscoverPage.speak_some_id), 300);
		String  xpath = String.format("//android.widget.TextView[contains(@text,'%s')]", "正在连接聊天室");
		waitUntilByNotFind(By.xpath(xpath), 60);
		clickById(DiscoverPage.speak_some_id);
		setText(getElementById(DiscoverPage.speak_some_edit_id), "来了");
	}
	/**
	 * 输入搜索内容
	 *
	 * @param str 
	 */
	public static void inputSearchString(String name){
		clickById(DiscoverPage.search_filter_id);
		log("input:-"+name);
		setText(getElementById(DiscoverPage.search_filter_id), name);
		wait(5);
	}
	/**
	 * 播放搜索列表里边的视频
	 *
	 * @param str 
	 */
	public static void playVideoInSearchList(){
		getElementById(DiscoverPage.search_result_media_list).findElements(By.className("android.widget.LinearLayout")).get(0).click();
	}
	/**
	 * 等待搜索完成
	 *
	 * @param str 
	 */
	public static void waitSearchLoading(){
		wait(3);
		waitUntilByFind(By.id(DiscoverPage.search_result_list_id), 30);
	}
	/**
	 * 搜索用户-添加关注
	 *
	 * @param Null 
	 */
	public static void clickSearchResultAddFollow(){
		clickById(DiscoverPage.search_result_user_follow);
	}
	
}
