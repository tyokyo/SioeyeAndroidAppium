package ckt.App.Listeners;

import io.appium.java_client.android.AndroidDriver;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.uncommons.reportng.Reporters;

import ckt.App.Util.BaseAppium;
import ckt.App.Util.Draw;
import ckt.App.Util.Log;
import ckt.App.Util.VP;
import ckt.main.TestNgXml;

public class TestngListener extends TestListenerAdapter {
	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	private static AndroidDriver<?> driver;
	public static AndroidDriver<?> getDriver() {
		return driver;
	}

	public static void setDriver(AndroidDriver<?> driver) {
		TestngListener.driver = driver;
		System.setProperty(ESCAPE_PROPERTY, "false"); 
	}
	public void printErrorMsg(ITestResult tr){
		//打印日志信息
		Throwable throwable = tr.getThrowable();  
		Log.info("测试用例: " + tr.getMethod().getMethodName());
		Log.info( "运行失败,原因:"  + throwable.getMessage());
        StackTraceElement[] se = throwable.getStackTrace();  
        Log.info("堆栈信息:");  
        String msg = "";
        for (StackTraceElement e : se) {  
        	msg=msg+e.toString()+"\n";
        }  
        Log.info(msg);  
	}
	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		try {
			takeScreenShot(tr,"Faled");
		} catch (Exception e) {
			// TODO: handle exception
		}
		Log.infoFailed(tr.getName() + " Failure");
		String drawString="Faled";
		
		//printErrorMsg(tr);
		/*try {
			String pagesource = BaseAppium.getDriver().getPageSource();
			if (pagesource.contains("Unfortunately")||pagesource.contains("停止运行")) {
				drawString  = drawString+" Exception_Crash ";
			} 
			if (pagesource.contains("isn't responding")||pagesource.contains("无响应")) {
				drawString  = drawString+" Exception_ANR ";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		if (VP.existByTextContains("Unfortunately")) {
			drawString  = drawString+" Exception_Crash ";
		}
		if (VP.existByTextContains("停止运行")) {
			drawString  = drawString+" Exception_Crash ";
		}
		if (VP.existByTextContains("isn't responding")) {
			drawString  = drawString+" Exception_ANR ";
		}
		if (VP.existByTextContains("无响应")) {
			drawString  = drawString+" Exception_ANR ";
		}
		try {
			takeScreenShot(tr,drawString);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
		printErrorMsg(tr);
		Log.infoSkipped(tr.getName() + " Skipped");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		Log.infoSuccess(tr.getName() + " Success");
	}

	@Override
	public void onTestStart(ITestResult tr) {
		super.onTestStart(tr);
		String className=tr.getTestClass().getName();
		String methodName=tr.getMethod().getMethodName();
		Log.info2(" Start to Run:"+className+"#"+methodName);
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		super.onFinish(iTestContext);
		/*Iterator<ITestResult> listOfFailedTests = iTestContext.getFailedTests().getAllResults().iterator();
		while (listOfFailedTests.hasNext()) {
			ITestResult failedTest = listOfFailedTests.next();
			ITestNGMethod method = failedTest.getMethod();
			if (iTestContext.getFailedTests().getResults(method).size() > 1) {
				listOfFailedTests.remove();
			} else {
				if (iTestContext.getPassedTests().getResults(method).size() > 0) {
					listOfFailedTests.remove();
				}
			}
		}*/
		Log.info2("Test - onFinish");
	}

	private void takeScreenShot(ITestResult tr,String drawString) {
		int width = getDriver().manage().window().getSize().width/Draw.DISPLAY;  
		int height = getDriver().manage().window().getSize().height/Draw.DISPLAY;  

		String className=tr.getTestClass().getName();
		String methodName=tr.getMethod().getMethodName();
		String folderString = className+"."+methodName;
		System.out.println(folderString);
		folderString=folderString.replaceAll("['.']", "/");
		System.out.println(folderString);
		File folder = new File(TestNgXml.screenshotFolder+"/"+folderString);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		System.out.println(folder.getAbsolutePath());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String mDateTime = formatter.format(new Date());
		//String screenName = mDateTime+"_"+tr.getMethod().getMethodName()+".png";
		String screenName = mDateTime+".png";
		//String screenShotPath = location.getAbsolutePath()+File.separator+screenName;
		String screenShotPath = folder.getAbsolutePath()+File.separator+screenName;
		File screenShot = getDriver().getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			Draw.takeDrawRectAndText(screenShotPath, Color.RED,drawString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.setCurrentTestResult(tr);
		//Reporter.log("<img src=\"" + screenShotName + "/>");
		Reporters.logInfo("<br><img src=../screenshot/" + folderString+"/"+screenName + "  onclick='window.open(\"../screenshot/"+folderString+"/"+screenName+")'"+"  height='"+height+"'  width='"+width+"'/>");
		//Reporter.log("<img src=\"../screenshot/" +folderString+"/"+ screenName + "\"/>");
	}
}