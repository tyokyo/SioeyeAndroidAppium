package ckt.App.Util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import ckt.App.Listeners.AppiumEventListener;
import ckt.App.Listeners.TestngListener;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;

public class BaseAppium {
	private static  AndroidDriver<?> driver;
	private static  AppiumBean  bean;;
	public static AppiumBean getBean() {
		return bean;
	}
	public static void setBean(AppiumBean bean) {
		BaseAppium.bean = bean;
	}
	@SuppressWarnings("rawtypes")
	public static void startAppiumDriver(String address,String port,String udid,String username,String password,String apk){
		AppiumBean bean = new AppiumBean();
		bean.setAddress(address);
		bean.setPort(port);
		bean.setUdid(udid);
		bean.setUsername(username);
		bean.setPassword(password);
		bean.setApk(apk);
		setBean(bean);
		
		int  TimeUnitSECONDS = 10;
		 // set up appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName",udid);
        //capabilities.setCapability("platformVersion", "6.0.1");
        
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("sessionOverride", true);
        //if no need install don't add this
        capabilities.setCapability("app", apk);
        //capabilities.setCapability("app", "/Users/Qiang.Zhang/Desktop/software/apk/Sioeye2.0_APP_S11A_100-2.0.68.apk");
        capabilities.setCapability("appPackage", "cn.sioeye.sioeyeapp");
        //support Chinese 
        capabilities.setCapability("unicodeKeyboard" ,"True");
        capabilities.setCapability("resetKeyboard", "True");
        //no need sign
       // capabilities.setCapability("noSign", "false");
       //capabilities.setCapability("appActivity", ".main.MainActivity");
        try {
        	driver = new AndroidDriver(new URL(String.format("http://%s:%s/wd/hub", address,port)), capabilities);
        	//添加监听器
        	 EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
             //注册事件
             eventDriver.register(new AppiumEventListener());
             
        	/*EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new AppiumEventListener());*/
        	
        	driver.manage().timeouts().implicitlyWait(TimeUnitSECONDS,TimeUnit.SECONDS);
        	
        	TestngListener.setDriver(driver);
        	log("start to initialize appium driver");
        	log(String.format("udid=%s,address=%s,port=%s", udid,address,port));
        	
        	//reset app  删除以前的账号信息
        	//driver.resetApp();
        	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 /**
     * This method use to close the appium driver
     *
     * @param void
     * @return  void
     */
	public static void stopAppiumDriver(){
		log("quit appium driver");
		try {
			getDriver().quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void log(String message){
		Log.info(message);
	}
	public static int getMaxRunCount(){
		String configPath = "";
		return Integer.parseInt(Property.getValueByKey(configPath, "retryCount"));
	}
	public static AndroidDriver<?> getDriver() {
		return driver;
	}
	public static void setDriver(AndroidDriver<?> driver) {
		driver = driver;
	}
}
