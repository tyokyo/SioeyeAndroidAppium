package ckt.android.testcase.account;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ckt.App.Util.VP;
import ckt.android.action.AccountAction;

public class AccountCase extends VP{
	@BeforeSuite
	@Parameters({ "port", "udid" ,"address","username","password","apk"})
	public void setup(String port, String udid,String address,String username,String password,String apk){
		startAppiumDriver(address,port,udid,username,password,apk);
	}
	@BeforeMethod
	public void beforeMethod(){
		reStartApp();
		AccountAction.inLogin();
	}
	@AfterSuite
	public void teadDown(){
		stopAppiumDriver();
	}
	@Test
	public void testLogOut(){
		resetApp();
		AccountAction.loginAccount();
		AccountAction.logOutAccount();
	}
}
