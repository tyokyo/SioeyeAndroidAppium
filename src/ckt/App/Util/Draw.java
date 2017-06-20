package ckt.App.Util;

import java.io.File;
import java.io.FileOutputStream;  
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Color;  
import java.awt.Font;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.image.BufferedImage;  

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.uncommons.reportng.Reporters;

import ckt.App.Listeners.TestngListener;
import ckt.main.TestNgXml;

import com.sun.image.codec.jpeg.JPEGCodec;  
import com.sun.image.codec.jpeg.JPEGImageEncoder;  
import com.sun.jna.platform.unix.X11.Display;

public class Draw{
	public  static int DISPLAY = 2; 
	private static String getPrefix() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		if (stackTrace == null || stackTrace.length < 4) return "BOGUS";
		String className = stackTrace[3].getClassName();
		String methodName = stackTrace[3].getMethodName();
		return String.format("%s.%s", className, methodName);
	}
	public static void takeScreenShot(Color color){
		int width = TestngListener.getDriver().manage().window().getSize().width/DISPLAY;  
		int height = TestngListener.getDriver().manage().window().getSize().height/DISPLAY;  
		String folderString = getPrefix();
		folderString=folderString.replaceAll("['.']", "/");
		//File folder = new File("test-output/screenshot/"+folderString);
		File folder = new File(TestNgXml.screenshotFolder+"/"+folderString);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String mDateTime = formatter.format(new Date());
		String screenName = mDateTime+".png";
		String screenShotPath = folder.getAbsolutePath()+File.separator+screenName;
		File screenShot =  TestngListener.getDriver().getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Log.info(folderString+"/"+screenName);
		try {
			takeDrawRect(screenShotPath, color);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporters.logInfo("<br><img src=../screenshot/" + folderString+"/"+screenName + "  onclick='window.open(\"../screenshot/"+folderString+"/"+screenName+")'"+"  height='"+height+"'  width='"+width+"'/>");
	}
	public static String takeScreenShot(){
		int width =  TestngListener.getDriver().manage().window().getSize().width/DISPLAY;  
		int height =  TestngListener.getDriver().manage().window().getSize().height/DISPLAY;  
		String folderString = getPrefix();
		folderString=folderString.replaceAll("['.']", "/");
		//File folder = new File("test-output/screenshot/"+folderString);
		File folder = new File(TestNgXml.screenshotFolder+"/"+folderString);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String mDateTime = formatter.format(new Date());
		String screenName = mDateTime+".png";
		String screenShotPath = folder.getAbsolutePath()+File.separator+screenName;
		File screenShot =  TestngListener.getDriver().getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Log.info(screenShotPath);
		try {
			takeDrawRect(screenShotPath, Color.BLACK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporters.logInfo("<br><img src=../screenshot/" + folderString+"/"+screenName + "  onclick='window.open(\"../screenshot/"+folderString+"/"+screenName+")'"+"  height='"+height+"'  width='"+width+"'/>");
		return screenShotPath;
	}
	public static String  takeInspectorScreenShot(){
		int width =  TestngListener.getDriver().manage().window().getSize().width/DISPLAY;  
		int height =  TestngListener.getDriver().manage().window().getSize().height/DISPLAY;  
		File folder = new File("inspector");
		if (!folder.exists()) {
			folder.mkdirs();
		}
		String screenName = String.format("app-inspector%s.png",System.currentTimeMillis());;
		String screenShotPath = folder.getAbsolutePath()+File.separator+screenName;
		File screenShot =  TestngListener.getDriver().getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Log.info(screenShotPath);
		try {
			takeDrawRect(screenShotPath, Color.BLACK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenName;
	}
	public static void takeScreenShotWithDraw(String drawText){
		try {
			int width =  TestngListener.getDriver().manage().window().getSize().width/DISPLAY;  
			int height =  TestngListener.getDriver().manage().window().getSize().height/DISPLAY;  
			String folderString = getPrefix();
			folderString=folderString.replaceAll("['.']", "/");
			//File folder = new File("test-output/screenshot/"+folderString);
			File folder = new File(TestNgXml.screenshotFolder+"/"+folderString);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String mDateTime = formatter.format(new Date());
			String screenName = mDateTime+".png";
			String screenShotPath = folder.getAbsolutePath()+File.separator+screenName;
			File screenShot =  TestngListener.getDriver().getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenShot, new File(screenShotPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			Log.info(screenShotPath);
			takeDrawRectAndText(screenShotPath, Color.BLACK,drawText);
			Reporters.logInfo("<br><img src=../screenshot/" + folderString+"/"+screenName + "  onclick='window.open(\"../screenshot/"+folderString+"/"+screenName+")'"+"  height='"+height+"'  width='"+width+"'/>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void takeDrawRect(String filePath,Color color) throws IOException{
		File _file = new File(filePath); // 读入文件  
		Image src = ImageIO.read(_file); // 构造Image对象  
		int width = src.getWidth(null); // 得到源图宽  
		int height = src.getHeight(null); // 得到源图长  
		//需要长度  
		int newwidth = width;//width / 2  
		int newheight = height;//height / 2  
		BufferedImage image = new BufferedImage(newwidth, newheight,  
				BufferedImage.TYPE_INT_RGB);  
		Graphics graphics = image.getGraphics();  
		graphics.drawImage(src, 0, 0, newwidth, newheight, null); // 绘制缩小后的图  
		// 画边框,在drawImage后面，下面代码给图片加上两个像素的白边     
		graphics.setColor(color);     
		graphics.drawRect(0, 0, newwidth - 1, newheight - 1);  
		graphics.drawRect(1, 1, newwidth - 1, newheight - 1);  
		graphics.drawRect(0, 0, newwidth - 2, newheight - 2);  
		FileOutputStream out = new FileOutputStream(filePath); // 输出到文件流  
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
		encoder.encode(image); // JPEG编码  
		out.close();  
	}
	private static List<String> splitDrawString(String drawText){
		List<String> rows = new ArrayList<String>();
		int rowCount =30;
		int length =drawText.length();
		if (length<=rowCount) {
			rows.add(drawText);
		}else {
			int startIndex = 0;
			while (startIndex<=length) {
				int endIndex =startIndex+rowCount;
				if (endIndex>length) {
					String substr = drawText.substring(startIndex, length);
					rows.add(substr);
					break;
				}else {
					String substr = drawText.substring(startIndex, endIndex);
					rows.add(substr);
					startIndex = endIndex;
				}
			}
		}
		return rows;
	}
	public static void takeDrawRectAndText(String filePath,Color color,String drawText) throws IOException{
		File _file = new File(filePath); // 读入文件  
		Image src = ImageIO.read(_file); // 构造Image对象  
		int width = src.getWidth(null); // 得到源图宽  
		int height = src.getHeight(null); // 得到源图长  
		//需要长度  
		int newwidth = width;//width / 2  
		int newheight = height;//height / 2  
		BufferedImage image = new BufferedImage(newwidth, newheight,  
				BufferedImage.TYPE_INT_RGB);  
		Graphics graphics = image.getGraphics();  
		graphics.drawImage(src, 0, 0, newwidth, newheight, null); // 绘制缩小后的图  
		// 画边框,在drawImage后面，下面代码给图片加上两个像素的白边     
		graphics.setColor(color);     
		graphics.drawRect(0, 0, newwidth - 1, newheight - 1);  
		graphics.drawRect(1, 1, newwidth - 1, newheight - 1);  
		graphics.drawRect(0, 0, newwidth - 2, newheight - 2);  
		Font font=new Font("Helvetica",Font.BOLD,55);
		graphics.setFont(font);
		List<String> toDrawStrings = splitDrawString(drawText);
		int row=1;
		for (String draw : toDrawStrings) {
			int x =20;
			int y = 60*row+height/20;
			if (y<=height) {
				graphics.drawString(draw,x ,y );
				row=row+1;
			}
		}
		
		FileOutputStream out = new FileOutputStream(filePath); // 输出到文件流  
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
		encoder.encode(image); // JPEG编码  
		out.close();  
	}
}
