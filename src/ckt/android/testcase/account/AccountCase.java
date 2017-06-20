package ckt.android.testcase.account;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ckt.App.Util.VP;
import ckt.android.action.AccountAction;

public class AccountCase extends VP{
	@BeforeMethod
	@Parameters({ "port", "udid" ,"address","username","password"})
	public void setup(String port, String udid,String address,String username,String password){
		startAppiumDriver(address,port,udid,username,password);
		AccountAction.inLogin();
	}
	@AfterMethod
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
