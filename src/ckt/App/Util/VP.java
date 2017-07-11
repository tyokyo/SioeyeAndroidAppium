package ckt.App.Util;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ckt.android.action.AccountAction;
import ckt.android.page.MainPage;

public class VP extends BaseAppium{
	public static final String PACKAGE_STRING="cn.sioeye.sioeyeapp:id/";
	/**
	 * This method use to reset the Android App,and clear th account 
	 *
	 * @param void
	 * @return  void
	 */
	public static void resetApp(){
		log("RESET App");
		getDriver().resetApp();
	}
	/**
	 * This method use to reset the Android App,and clear th account 
	 *
	 * @param void
	 * @return  void
	 */
	public static void reStartApp(){
		log("CLOSE-App");
		getDriver().closeApp();
		log("LAUNCH-App");
		getDriver().launchApp();
		wait(5);
		waitUntilByFind(By.id(MainPage.discover_id), 30);
	}
	/**
	 * This method use xpath to clci element //android.widget.TextView[@text='%s' ]
	 *
	 * @param text
	 */
	public static void  clickByText(String text){
		log("CLICK-TEXT:"+text);
		String xpath = String.format("//android.widget.TextView[@text='%s']", text);
		clickByXpath(xpath);
	}
	public static void  clickByTextContains(String text){
		log("CLICK-TEXT-CONTAINS:"+text);
		String xpath = String.format("//android.widget.TextView[contains(@text,'%s')]", text);
		clickByXpath(xpath);
	}
	public static void clickById(String id){
		log("CLICK-ID::"+id);
		getElementById(id).click();
		wait(2);
	}
	public static void clickElement(WebElement webElement){
		if (webElement!=null) {
			log("CLICK-WebElement");
			log(""+webElement.getLocation().x);
			log(""+webElement.getLocation().y);
			webElement.click();
		}else {
			log("Element is Null");
		}
	}
	public static void clickByClassName(String className){
		log("CLICK-CLASSNAME:"+className);
		getElementByClassName(className).click();
	}
	//getDriver().findElementByXPath("//android.widget.TextView[contains(@text,'is xpathname')]");
	public static void clickByXpath(String xpath){
		log("CLICK-XPATH:"+xpath);
		getDriver().findElementByXPath(xpath).click();
	}
	public static void click(int x ,int y){
		log(String.format("CLICK X=%s,Y=%s",x,y));
		getDriver().tap(1, x, y, 100);
	}
	public static WebElement getElementById(String id){
		log("GET ELEMENT BY ID:"+id);
		String automationName=getBean().getAutomationName();
		if ("Selendroid".toUpperCase().equals(automationName.toUpperCase())) {
			id = id.replaceAll(PACKAGE_STRING, "");
		}
		WebElement element = getDriver().findElement(By.id(id));
		return element;
	}
	public static WebElement getElementByXpath(String xpath){
		log("GET ELEMENT BY XPATH:"+xpath);
		WebElement element = getDriver().findElementByXPath(xpath);
		return element;
	}
	public static WebElement getElementByText(String text){
		log("GET ELEMENT BY TEXT:"+text);
		String xpath = String.format("//android.widget.TextView[@text='%s']", text);
		//WebElement element = getDriver().findElementByAndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", text));
		WebElement element=getElementByXpath(xpath);
		return element;
	}
	public static WebElement getElementByTextContains(String text){
		log("GET ELEMENT BY TEXT:"+text);
		String xpath = String.format("//android.widget.TextView[contains(@text,'%s')]", text);
		//WebElement element = getDriver().findElementByAndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", text));
		WebElement element=getElementByXpath(xpath);
		return element;
	}
	/**
	 * This method use to find elements by classname
	 *
	 * @param className example android.widget.EditText
	 * @return  element list
	 */
	@SuppressWarnings("unchecked")
	public static List<WebElement> getElementsByClassName(String className){
		List<WebElement> fieldsList = (List<WebElement>) getDriver().findElementsByClassName(className);
		return fieldsList;
	}
	/**
	 * This method use to find elements by classname
	 *
	 * @param className example android.widget.EditText
	 * @return  element list
	 */
	public static WebElement getElementByClassName(String className){
		WebElement element  =getDriver().findElementByClassName(className);
		return element;
	}
	public static void wait(int time){
		log(String.format("wait-%s seconds", time));
		try {
			Thread.currentThread();
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean existByText(String text){
		boolean find = false;
		try {
			getElementByText(text);
			find = true;
		} catch (Exception e) {
			log("Can't find element with text=:"+text);
		}
		return find;
	}
	public static boolean existByTextContains(String text){
		boolean find = false;
		try {
			getElementByTextContains(text);
			find = true;
		} catch (Exception e) {
			log("Can't find element with text contans=:"+text);
		}
		return find;
	}
	public static boolean existById(String id){
		boolean find = false;
		try {
			getElementById(id);
			find = true;
		} catch (Exception e) {
			log("Can't find element with id=:"+id);
		}
		return find;
	}
	public static boolean existByClassName(String className){
		boolean find = false;
		try {
			getElementsByClassName(className);
			find = true;
		} catch (Exception e) {
			log("Can't find element with className=:"+className);
		}
		return find;
	}
	/*driver.findElement(By.className(className)).findElements(By.tagName("tagname is me")).get(i)
	driver.findElement(By.className(className)).findElements(By.id("id is me")).get(i)
	driver.findElement(By.className(className)).findElements(By.name("name is me")).get(i)
	driver.findElementByAndroidUIAutomator("new UiSelector().descriptionContains(\""+name+"\")"*/
	//during（这里是填写毫秒数，这里的 毫秒数越小 滑动的速度越快~ 一般设定在500~1000，如果你想快速滑动 那就可以设置的更加小）
	//num（是只滑动的次数，本人在做相册 翻页测试什么的 滑动  或者滑动到列表底部。就直接输入次数就行了）
	/** 
	 * 上滑 
	 *  
	 * @param iosdriver 
	 * @param during 
	 * @param num 
	 */  
	public static void swipeToUp(int during, int num) {  
		int width = getDriver().manage().window().getSize().width;  
		int height = getDriver().manage().window().getSize().height;  
		for (int i = 1; i <= num; i++) {  
			getDriver().swipe(width / 2, height * 5/ 6, width / 2, height *2/ 6, during);  
			//iosdriver.swipe(width / 2, height * 3/ 4, width / 2, height *1/ 4, during);  
			Log.info("swipeToUp-"+i);
			wait(1);  
		}  
	}  
	public static int getRandom(){
		Random random=new java.util.Random();// 定义随机类
		int result=random.nextInt(30);// 返回[0,10)集合中的整数，注意不包括10
		log("random:"+result);
		return result+1;
	}
	/** 
	 * 下拉 
	 *  
	 * @param during 
	 * @param num 
	 */  
	public static void swipeToDown(int during, int num) {  
		int width = getDriver().manage().window().getSize().width;  
		int height = getDriver().manage().window().getSize().height;  
		for (int i = 1; i <= num; i++) {  
			getDriver().swipe(width / 2, height*3 / 6, width / 2, height * 4 / 6, during);  
			Log.info("swipeToDown-"+i);
			wait(1);  
		}  
	}  

	/** 
	 * 向左滑动 
	 *   
	 * @param driver 
	 * @param during 
	 * @param num 
	 */  
	public static void swipeToLeft(int during, int num) {  
		int width = getDriver().manage().window().getSize().width;  
		int height = getDriver().manage().window().getSize().height;  
		for (int i = 1; i <= num; i++) {  
			getDriver().swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);  
			Log.info("swipeToLeft-"+i);
			wait(3);  
		}  
	}  

	/** 
	 * 向右滑动 
	 *  
	 * @param driver 
	 * @param during 
	 * @param num 
	 */  
	public static void swipeToRight(int during, int num) {  
		int width = getDriver().manage().window().getSize().width;  
		int height = getDriver().manage().window().getSize().height;  
		for (int i = 1; i <= num; i++) {  
			getDriver().swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);  
			Log.info("swipeToRight-"+i);
			wait(3);  
		}  
	}  
	public static void swipeToBegin(int num) {
	}
	public static void swipeToEnd(IOSDriver<?> iosdriver,int num) {
	}
	/** 
	 * 上滑 
	 * @param text 
	 */  
	public static void swipeTo(WebElement element,String direction) {  
		int wd_width = getDriver().manage().window().getSize().width;  
		int wd_height = getDriver().manage().window().getSize().height;  
		Point point = element.getLocation();
		int startX=point.x;
		int startY=point.y;
		int endX=0;
		int endY=0;
		switch (direction) {
		case "DOWN":
			endX=point.x;
			endY=point.y+wd_height/8;
			getDriver().swipe(startX,startY,endX,endY,1000);
			Log.info(String.format("swipToDown startX=%d startY=%d endX=%d endY=%d",startX,startY,endX,endY));
			break;
		case "RIGHT":
			endX=wd_width-20;
			startX=startX/2;
			endY=point.y;
			getDriver().swipe(startX,startY,endX,endY,10);
			Log.info(String.format("swipToRight startX=%d startY=%d endX=%d endY=%d",startX,startY,endX,endY));
			break;
		case "UP":
			endX=point.x;
			endY=point.y-wd_height/8;
			getDriver().swipe(startX,startY,endX,endY,1000);
			Log.info(String.format("swipToUp startX=%d startY=%d endX=%d endY=%d",startX,startY,endX,endY));
			break;
		case "LEFT":
			startX=wd_width-20;
			endX=startX/4;;
			endY=point.y;
			getDriver().swipe(startX,startY,endX,endY,10);
			Log.info(String.format("swipToLeft startX=%d startY=%d endX=%d endY=%d",startX,startY,endX,endY));
			break;
		default:
			break;
		}
	}  
	/** 
	 * 等待文本出现 
	 * @param text 
	 * @param timeout  秒
	 */  
	public static void waitUntilTextFind(String text,int timeout){
		String xpath=String.format("//android.widget.TextView[contains(@text,'%s')]", text);
		VP2.waitAuto(By.xpath(xpath), timeout);
	}
	public static void waitUntilByFind(By by,int seconds){
		log(String.format("waitUntilFind  by=%s in  %d seconds",by.toString(),seconds));
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
			log(by.toString() + "  waitUntilFind = success");
		} catch (Exception e) {
			// TODO: handle exception
			log(by.toString() + " waitUntilFind = Not find ");
		}
	}
	public static void waitUntilByTextContains(String text,int seconds){
		String xpath = String.format("//android.widget.TextView[contains(@text,'%s')]", text);
		By by = By.xpath(xpath);
		log(String.format("waitUntilFind  by=%s in  %d seconds",by.toString(),seconds));
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
			log(by.toString() + "  waitUntilFind = success");
		} catch (Exception e) {
			// TODO: handle exception
			log(by.toString() + " waitUntilFind = Not find ");
		}
	}
	public static void waitUntilByText(String text,int seconds){
		String xpath = String.format("//android.widget.TextView[@text='%s']", text);
		By by = By.xpath(xpath);
		log(String.format("waitUntilFind  by=%s in  %d seconds",by.toString(),seconds));
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
			log(by.toString() + "  waitUntilFind = success");
		} catch (Exception e) {
			// TODO: handle exception
			log(by.toString() + " waitUntilFind = Not find ");
		}
	}
	public static void waitUntilByNotFind(By by,int seconds){
		log(String.format("waitUntilByNotFind   %s in  %d seconds",by.toString(),seconds ));
		boolean notFind = false;
		for (int i = 1; i < seconds; i++) {
			if (notFind) {
				log(String.format("waitUntilByNotFind  by=%s  in %d seconds  success",by.toString(),seconds));
				break;
			}else {
				try {
					WebDriverWait wait = new WebDriverWait(getDriver(), 3);
					wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
				} catch (Exception e) {
					// TODO: handle exception
					notFind = true;
				}
			}
		}
		if (!notFind) {
			log(String.format("waitUntilByNotFind  by=%s  in % seconds  timeout",by.toString(),seconds));
		}
	}
	
	public static void waitUntilTextToBe(By by,String text,int seconds){
		log(String.format("textToBe  %s in  %d seconds",by.toString(),seconds ));
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
			wait.until(ExpectedConditions.textToBe(by, text));
			log(by.toString() + "  textToBe = success");
		} catch (Exception e) {
			// TODO: handle exception
			log(by.toString() + " textToBe = Not find ");
		}
	}
	public static void waitUntilByGone(By by,int seconds){
		log(String.format("wait %s gone  in %d secods",by.toString(),seconds));
		boolean exit=false;
		for (int i = 0; i < seconds; i++) {
			if (exit) {
				break;
			}else {
				try {
					getDriver().findElement(by);
				} catch (Exception e) {
					log("not find element , now exit");
					exit=true;
				}
			}
		}
	}
	public static void pressBack(int count){
		for (int i = 0; i < count; i++) {
			log("PRESS-BACK-"+count);
			getDriver().pressKeyCode(AndroidKeyCode.BACK);
			wait(3);
		}
	}
	public static void pressBack(){
		pressBack(1);
	}
	public static void pressEnter(){
		getDriver().pressKeyCode(AndroidKeyCode.ENTER);
	}
	public static void pressHome(int count){
		for (int i = 0; i < count; i++) {
			log("PRESS-HOME-"+count);
			getDriver().pressKeyCode(AndroidKeyCode.HOME);
			wait(3);
		}
	}
	public static void pressPower(int count){
		for (int i = 0; i < count; i++) {
			log("PRESS-POWER-"+count);
			getDriver().pressKeyCode(AndroidKeyCode.KEYCODE_POWER);
			wait(3);
		}
	}
	/** 
	 * 输入文本 
	 * @param WebElement 
	 * @param text  
	 */  
	public static void setText(WebElement webElement,String text){
		try {
			webElement.sendKeys(text);
			wait(3);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * 获得元素 属性的文本
	 * */
	public String getAttributeText(By elementLocator, String attribute) {
		return getDriver().findElement(elementLocator).getAttribute(attribute).trim();
	}
	/**拖拽操作*/
	public void DragAndDrop(By dragBy,By dropBy){
		TouchAction act=new TouchAction(getDriver());
		WebElement dragElement=getDriver().findElement(dragBy);
		WebElement dropElement=getDriver().findElement(dropBy);
		act.press(dragElement).perform();
		act.moveTo(dropElement).release().perform();
	}
	/**页面过长时候滑动页面 window.scrollTo(左边距,上边距); */
	public void scrollPage(int x,int y){
		String js ="window.scrollTo("+x+","+y+");";
		((JavascriptExecutor)getDriver()).executeScript(js);
	}
	public static void initializeScript(){
		//Draw.takeScreenShotWithDraw("initializeScript");
		reStartApp();
		AccountAction.inLogin();
		//Draw.takeScreenShotWithDraw("inLogin_status");
	}

	/**
	 * 获得随机字符
	 */
	public static String getRandomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
}
