package org.githubb;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 public static WebDriver  driver; 
		public static WebDriver chromeBrowser() {
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
			return driver;
	    }
		public static WebDriver browserLaunch(String bname) {
			if(bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}	
			else if (bname.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				}
			else if(bname.equalsIgnoreCase("edge")){
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			return driver;
			}
		public static void urllaunch(String url) {
			driver.get(url);
			driver.manage().window().maximize();
		}
		public static void implicitlyWait(int a) {
			driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
		}
		public static void  sendkeys(WebElement e,String value) {
			e.sendKeys(value);
		}
		public static void click(WebElement e) {
			e.click();
		
		}
		public static String getCurrentUrl() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}
		public static String getTitle() {
			String title = driver.getTitle();
			return title;
		}
		public static void Alert() {
			Alert c = driver.switchTo().alert();
			c.accept();
		}
		public static void Alert1() {
			Alert c = driver.switchTo().alert();
			c.dismiss();
		}
		public static void Alert2() {
			Alert c = driver.switchTo().alert();
			c.getText();
		}
		public static void Alert3(String S ) {
			Alert c = driver.switchTo().alert();
			c.sendKeys(S);
		}
		public static void quit() {
		driver.quit();
		}
		public static void clear(WebElement e) {
			e.clear();
	}
		public static void moveToElement(WebElement e) {
			Actions a = new Actions(driver);
			a.moveToElement(e).perform();
		}
		public static void dragAndDrop(WebElement src,WebElement tar) {
			Actions a = new Actions(driver);
			a.dragAndDrop(src,tar).perform();
		}
		public static void contextClick(WebElement e) {
			Actions a = new Actions(driver);
			a.contextClick(e).perform();
		}
		public static void doubleClick(WebElement e) {
			Actions a = new Actions(driver);
			a.doubleClick(e).perform();
		}
		public static void clickAndHold(WebElement e) {
			Actions a = new Actions(driver);
			a.clickAndHold(e).perform();
		}
		public static void Down() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		public static void Up() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
		}
		public static void Select() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		public static void Capital() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_SHIFT);
		}
		public static void Copy() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
		public static void Paste() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
		public static void Nextline() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}
		public static void Selectall() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
		public static void Cutall() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_X);
			r.keyRelease(KeyEvent.VK_X);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
		public static void selectByindex(WebElement e,int a) {
			Select s =new Select(e);
			s.selectByIndex(a);
		}
		public static void selectByValue(WebElement e,String a) {
			Select s =new Select(e);
			s.selectByValue(a);
		}
		public static void selectByVisibleText(WebElement e,String a) {
			Select s =new Select(e);
			s.selectByVisibleText(a);
		}
		public static void Takes(WebElement e,String a) throws IOException {
			TakesScreenshot tk=(TakesScreenshot)driver;
			File from = tk.getScreenshotAs(OutputType.FILE);
			File to = new File("C:\\Users\\Admin\\eclipse-workspace\\MavenDemo\\src\\test\\java\\org\\test\\screenshot");
		    FileUtils.copyFile(from, to);
		}
		public static String getText(WebElement e) {
			String text = e.getText();
			return text;
		}
		public static String getAttribute(WebElement e) {
			String attribute = e.getAttribute("value");
			return attribute;
		}
		public static void to(String url) {
	    driver.navigate().to(url);
	}
		public static void back() {
		driver.navigate().back();
	}
		public static void forward() {
		driver.navigate().forward();
		}
		public static void refresh() {
		driver.navigate().refresh();
		}
		public static boolean isselected(WebElement e) {
		   boolean selected = e.isSelected();
		return selected;
		   
		}
	}


