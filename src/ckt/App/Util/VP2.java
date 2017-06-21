package ckt.App.Util;

import org.apache.http.util.TextUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ckt.android.action.AccountAction;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;
import static io.appium.java_client.android.AndroidKeyCode.BACKSPACE;
import static io.appium.java_client.android.AndroidKeyCode.KEYCODE_MOVE_END;
/**
 * 逻辑处理父类
 * Created by LITP on 2016/9/22.
 */

public class VP2 extends BaseAppium {
    //单个触摸操作类
    public static TouchAction touchAction;

    //多个触摸操作时间
    public static MultiTouchAction multiTouchAction;

    public static int WAIT_TIME = 3;    //默认的等待控件时间
    public static final int SWIPE_DEFAULT_PERCENT = 5;   //默认滑动百分比

    /**
     * 打印字符
     *
     * @param str 要打印的字符
     */
    public static  <T> void print(T str) {
        if (!TextUtils.isEmpty(String.valueOf(str))) {
            System.out.println(str);
        } else {
            System.out.println("输出了空字符");
        }
    }

    /**
     * Click点击空格键
     *
     * @param ae 要点击的控件
     * @return 返回是否点击
     */
    public static boolean clickView(AndroidElement ae) {
        return clickView(ae, "");
    }


    /**
     * Click点击控件
     *
     * @param ae  控件
     * @param str 控件的文字描述，供错误时候输出
     * @return 返回是否存在控件
     */
    public static boolean clickView(AndroidElement ae, String str) {
        if (ae != null) {
            ae.click();
            return true;
        } else {
            print(str + "为空，点击错误");
        }
        return false;
    }


    /**
     * 线程休眠秒数，单位秒
     *
     * @param s 要休眠的秒数
     */
    public static  void sleep(long s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取当前的activity,返回文件名
     *
     * @return
     */
    public static String getCurrActivity() {
        String str = getDriver().currentActivity();
        return str.substring(str.lastIndexOf(".") + 1);
    }

    /**
     * 获取触摸实例
     *
     * @return
     */
    public static TouchAction getTouch() {
        if (getDriver() == null) {
            print("单点触摸时候getDriver()为空");
            return null;
        } else {
            if (touchAction == null) {
                return new TouchAction(getDriver());
            } else {
                return touchAction;
            }

        }
    }


    /**
     * 获取多点触摸实例
     *
     * @return
     */
    public static MultiTouchAction getMultiTouch() {
        if (getDriver() == null) {
            print("多点触摸时候getDriver()为空");
            return null;
        } else {
            if (multiTouchAction == null) {
                return new MultiTouchAction(getDriver());
            } else {
                return multiTouchAction;
            }

        }
    }

    /**
     * 往控件输入字符串
     *
     * @param ae  要输入的控件
     * @param str 要输入的字符串
     */
    public static void input(AndroidElement ae, String str) {
        if (ae == null) {
            print("控件为空,输入内容失败:" + str);
        } else {
            ae.sendKeys(str);
        }

    }

    public static void swipeToUp(int during) {
        swipeToUp(during, SWIPE_DEFAULT_PERCENT);
    }

    /**
     * 向上滑动，
     *
     * @param during
     */
    public static void swipeToUp(int during, int percent) {
        int width = getScreenWidth();
        int height = getScreenHeight();
        getDriver().swipe(width / 2, height * (percent - 1) / percent, width / 2, height / percent, during);
    }

    public static void swipeToDown(int during) {
        swipeToDown(during, SWIPE_DEFAULT_PERCENT);
    }

    /**
     * 向下滑动，
     *
     * @param during 滑动时间
     */
    public static void swipeToDown(int during, int percent) {
        int width = getScreenWidth();
        int height = getScreenHeight();
        getDriver().swipe(width / 2, height / percent, width / 2, height * (percent - 1) / percent, during);
    }


    public static void swipeToLeft(int during) {
        swipeToLeft(during, SWIPE_DEFAULT_PERCENT);
    }

    /**
     * 向左滑动，
     *
     * @param during  滑动时间
     * @param percent 位置的百分比，2-10， 例如3就是 从2/3滑到1/3
     */
    public static void swipeToLeft(int during, int percent) {
        int width = getScreenWidth();
        int height = getScreenHeight();
        getDriver().swipe(width * (percent - 1) / percent, height / 2, width / percent, height / 2, during);
    }


    public static void swipeToRight(int during) {
        swipeToRight(during, SWIPE_DEFAULT_PERCENT);
    }

    /**
     * 向右滑动，
     *
     * @param during  滑动时间
     * @param percent 位置的百分比，2-10， 例如3就是 从1/3滑到2/3
     */
    public static void swipeToRight(int during, int percent) {
        int width = getScreenWidth();
        int height = getScreenHeight();
        getDriver().swipe(width / percent, height / 2, width * (percent - 1) / percent, height / 2, during);
    }


    /**
     * 显示等待，等待Id对应的控件出现time秒，一出现马上返回，time秒不出现也返回
     * @param By
     * @param time 等待时间（秒）
     */
    public static AndroidElement waitAuto(By by, int time) {
        try {
            return new WebDriverWait(getDriver(), time).until(new ExpectedCondition<AndroidElement>() {
                @Override
                public AndroidElement apply(WebDriver webDriver) {
                	log("查找结果-success-" + time + " 秒之内找到元素 [" + by.toString() + "]");
                    return (AndroidElement) webDriver.findElement(by);
                }
            });
        } catch (TimeoutException e) {
            log("查找元素失败-超时- " + time + " 秒之后还没找到元素 [" + by.toString() + "]");
            return null;
        }
    }

    public static AndroidElement waitAutoById(String id) {
        return waitAutoById(id, WAIT_TIME);
    }

    public static AndroidElement waitAutoById(String id, int time) {
        return waitAuto(By.id(id), time);
    }

    public static AndroidElement waitAutoByName(String name) {
        return waitAutoByName(name, WAIT_TIME);
    }

    public static AndroidElement waitAutoByName(String name, int time) {
        return waitAuto(By.name(name), time);
    }


    public static AndroidElement waitAutoByXp(String xPath) {
        return waitAutoByXp(xPath, WAIT_TIME);
    }

    public static AndroidElement waitAutoByXp(String xPath, int time) {
        return waitAuto(By.xpath(xPath), time);
    }

    public static void waitAuto() {
        waitAuto(WAIT_TIME);
    }

    /**
     * ，隐式等待，如果在指定时间内还是找不到下个元素则会报错停止脚本
     * 全局设定的，find控件找不到就会按照这个事件来等待
     *
     * @param time 要等待的时间
     */
    public static void waitAuto(int time) {
        getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    /**
     * 获取当前界面的所有EditText，并依次输入内容
     *
     * @param str 要输入的数组
     */
    public static void inputManyText(String... str) {
        List<AndroidElement> textFieldsList = (List<AndroidElement>) getDriver().findElementsByClassName("android.widget.EditText");
        for (int i = 0; i < str.length; i++) {
            textFieldsList.get(i).click();
            clearText(textFieldsList.get(i));   //清除内容
            textFieldsList.get(i).sendKeys(str[i]);
        }
    }

    /**
     * 点击屏幕中间
     */
    public static void press() {
        press(getScreenWidth() / 2, getScreenHeight() / 2);
    }


    /**
     * 点击某个控件
     *
     * @param ae 要点击的控件
     */
    public static void press(AndroidElement ae) {
        try {
            getTouch().tap(ae).perform();
        } catch (Exception e) {
            print("tab点击元素错误" + e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * 点击某个坐标
     *
     * @param x
     * @param y
     */
    public static void press(int x, int y) {
        try {
            getDriver().tap(1, x, y, 500);
            //getTouch().tap(x, y).perform();
            print("tab点击位置(" + x + "," + y + ")");
        } catch (Exception e) {
            print("tab点击元素位置异常" + e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * 长按某个控件
     *
     * @param ae 要点击的控件
     */
    public static void longPress(AndroidElement ae) {
        try {
            getTouch().longPress(ae).release().perform();
        } catch (Exception e) {
            print("长按点击元素错误" + e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * 长按某个坐标
     *
     * @param x
     * @param y
     */
    public static void longPress(int x, int y) {
        try {
            getTouch().longPress(x, y).release().perform();
        } catch (Exception e) {
            print("长按点击元素错误" + e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * 在控件上滑动
     *
     * @param element   要滑动的控件
     * @param direction 方向，事件不设置默认1秒
     */
    public static void swipOnElement(AndroidElement element, String direction) {
        swipOnElement(element, direction, 1000);  //不设置时间就为2秒
    }

    /**
     * 在某一个控件上滑动
     *
     * @param element   在那个元素上滑动
     * @param direction 方向，UP  DOWN LEFT RIGHT
     */
    public static void swipOnElement(AndroidElement element, String direction, int duration) {
        //获取元素的起初xy，在左上角
        int x = element.getLocation().getX();
        int y = element.getLocation().getY();
        //获取元素的宽高
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        int startX;
        int endX;
        int startY;
        int endY;
        switch (direction) {
            case "UP":
                startX = x + width / 2;
                startY =y + height * 4 / 5;
                endX  = startX;
                endY  = y + height / 5;
                //在4/5的底部的中间向上滑动
                getDriver().swipe(startX, startY, endX,endY, duration);
                break;
            case "DOWN":
            	 startX = x + width / 2;
                 startY =y + height * 4 / 5;
                 endX  = startX;
                 endY  = y + height / 5;
                 //在4/5的底部的中间向上滑动
                 getDriver().swipe( endX,endY,startX, startY, duration);

            case "LEFT":
                startY = y + height / 2;
                startX =x+width/3;
                
                endX=x+2*width/3;
                endY=startY;
                getDriver().swipe(startX,startY, endX,endY , duration);
                break;
            case "RIGHT":
            	 startY = y + height / 2;
                 startX =x+width/3;
                 
                 endX=x+2*width/3;
                 endY=startY;
                 getDriver().swipe(endX,endY,startX,startY, duration);
                 break;
        }
    }

    /**
     * 在某个方向上滑动
     *
     * @param direction 方向，UP DOWN LEFT RIGHT
     * @param duration  持续时间
     */
    public static void swip(String direction, int duration) {
        switch (direction) {
            case "UP":
                swipeToUp(duration);
                break;
            case "DOWN":
                swipeToDown(duration);
                break;
            case "LEFT":
                swipeToLeft(duration);
                break;
            case "RIGHT":
                swipeToRight(duration);
                break;
        }
    }
    /**
     * 在指定次数的条件下，某个方向滑动，直到这个元素出现
     *
     * @param by         控件
     * @param direction  方向，UP DOWN  LEFT RIGHT
     * @param duration   滑动一次持续时间
     * @param maxSwipNum 最大滑动次数
     */
    public static void swipUtilElementAppear(By by, String direction, int duration, int maxSwipNum) {
        int i = maxSwipNum;
        Boolean flag = true;
        while (flag) {
            try {
                if (i <= 0) {
                    flag = false;
                }
                getDriver().findElement(by);
                flag = false;
            } catch (Exception e) {
                i--;
                swip(direction, duration);
            }
        }
    }

    /**
     * 在某个方向滑动直到这个元素出现
     *
     * @param by        控件
     * @param direction 方向，UP DOWN  LEFT RIGHT
     * @param duration  滑动一次持续时间
     */
    public static void swipUtilElementAppear(By by, String direction, int duration) {
        Boolean flag = true;
        while (flag) {
            try {
                getDriver().findElement(by);
                flag = false;
            } catch (Exception e) {
                swip(direction, duration);
            }
        }
    }


    /**
     * 获取屏幕的宽高
     *
     * @return 返回宽高的数组
     */
    public int[] getScreen() {
        int width = getDriver().manage().window().getSize().getWidth();
        int height = getDriver().manage().window().getSize().getHeight();
        return new int[]{width, height};
    }

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    public static int getScreenWidth() {
        return getDriver().manage().window().getSize().getWidth();
    }

    /**
     * 获取屏幕高度
     *
     * @return
     */
    public static int getScreenHeight() {
        return getDriver().manage().window().getSize().getHeight();
    }


    /**
     * 逐字删除编辑框中的文字
     *
     * @param element 文本框架控件
     */
    public static void clearText(AndroidElement element) {
        String text = element.getText();
        //跳到最后
        getDriver().pressKeyCode(KEYCODE_MOVE_END);
        for (int i = 0; i < text.length(); i++) {
            //循环后退删除
            getDriver().pressKeyCode(BACKSPACE);
        }
    }
}
