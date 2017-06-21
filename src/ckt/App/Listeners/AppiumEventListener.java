package ckt.App.Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ckt.App.Util.Log;
import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;

public class AppiumEventListener implements AppiumWebDriverEventListener{

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1,
			CharSequence[] arg2) {
		// TODO Auto-generated method stub
		Log.info("afterChangeValueOf");
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		Log.info("afterClickOn");
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		Log.info("afterFindBy-"+arg0);
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		Log.info("afterNavigateBack");
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		Log.info("afterNavigateForward");
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		Log.info("afterNavigateRefresh");
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		Log.info("afterNavigateTo");
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		Log.info("afterScript");
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1,
			CharSequence[] arg2) {
		// TODO Auto-generated method stub
		Log.info("beforeChangeValueOf");
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		Log.info("beforeClickOn");
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		Log.info("beforeFindBy-"+arg0);
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		Log.info("beforeNavigateBack");
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		Log.info("beforeNavigateForward");
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		Log.info("beforeNavigateRefresh");
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		Log.info("beforeNavigateTo");
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		Log.info("beforeScript");
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		Log.info("onException");
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		Log.info("afterChangeValueOf");
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		Log.info("beforeChangeValueOf");
	}

}
