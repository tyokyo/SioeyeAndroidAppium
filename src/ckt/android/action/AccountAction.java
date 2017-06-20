package ckt.android.action;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import ckt.App.Util.VP;
import ckt.android.action.me.MeAction;
import ckt.android.page.AccountPage;
import ckt.android.page.MainPage;

public class AccountAction  extends VP{

	/**
	 * 点击账号登录
	 *
	 * @param Null
	 */
	public static void clickSignUp(){
		clickById(AccountPage.login_sign_up_id);
	}
	
	/**
	 * 点击QQ登录
	 *
	 * @param Null
	 */
	public static void clickQQ(){
		clickById(AccountPage.login_QQ_id);
	}
	/**
	 * 点击微信登录
	 *
	 * @param Null
	 */
	public static void clickWebChat(){
		clickById(AccountPage.login_webchat_id);
	}
	/**
	 * 点击微博登录
	 *
	 * @param Null
	 */
	public static void clickWeibo(){
		clickById(AccountPage.login_weibo_id);
	}
	/**
	 * 点击关闭登录
	 *
	 * @param Null
	 */
	public static void clickCloseLogin(){
		clickById(AccountPage.login_close_id);
	}
	/**
	 * 输入用户名
	 *
	 * @param str 用户名
	 */
	public static void inputUsername(String userName){
		clickById(AccountPage.input_username_id);
		log("inputUsername-"+userName);
		getElementById(AccountPage.input_username_id).sendKeys(userName);
		wait(5);
	}
	/**
	 * 输入密码
	 *
	 * @param str 密码
	 */
	public static void inputPassword(String password){
		clickById(AccountPage.input_password_id);
		log("inputPassword-"+password);
		getElementById(AccountPage.input_password_id).sendKeys(password);
		wait(5);
	}
	/**
	 * 输入邮箱地址
	 *
	 * @param str 邮箱
	 */
	public static void inputEmail(String email){
		log("inputEmail-"+email);
		getElementById(AccountPage.input_email_id).sendKeys(email);
	}
	/**
	 * 输入电话号码
	 *
	 * @param str 电话号码
	 */
	public static void inputPhone(String phone){
		log("inputPhone-"+phone);
		getElementById(AccountPage.input_phone_id).sendKeys(phone);
	}
	/**
	 * 点击继续按钮
	 *
	 * @param Null
	 */
	public static void clickNext(){
		clickById(AccountPage.next_continue_id);
	}
	/**
	 * 点击登录按钮
	 *
	 * @param Null
	 */
	public static void clickLoginbtn(){
		clickByText("登录");
	}
	/**
	 *
	 * @param Null
	 * @return boolean 是否处于登录状态
	 */
	public static boolean  isLogin(){
		if (existByText("立即体验")) {
			clickByText("立即体验");
		}
		MainAction.clickMe();
		wait(3);
		boolean isLogIn = false;
		if (existById(MainPage.me_id)) {
			isLogIn=true;
		}else {
			log("Account logout");
		}
		return isLogIn;
	}
	public static void inLogin(){
		try {
			if (isLogin()) {
				log("Account 处于登录状态 ");
			}else {
				reStartApp();
				loginAccount();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void loginAccount(){
		if (existByText("立即体验")) {
			clickByText("立即体验");
		}
		MainAction.clickMe();
		clickLoginbtn();
		inputUsername(getBean().getUsername());
		inputPassword(getBean().getPassword());
		clickSignUp();
		waitUntilByFind(By.id(MainPage.me_id), 20);
	}
	public static void logOutAccount(){
		reStartApp();
		MeAction.navToAccountSecurity();
		MeAction.clickAccountSecurity_LogOut();
		MeAction.clickAccountSecurity_LogOut_OK();
		wait(3);
	}
}
