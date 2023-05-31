package com.Twinlite.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * this class contains all the methods related to webdriver 
 * @author satya
 *
 */
public class WebDriverUtilities {

	/**
	 * this is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * this is used to minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * used to wait till the page gets loaded
	 * @param driver
	 */
	public void waitTillPageGetsLoaded(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IPATHConstants.implicitwaitduration, TimeUnit.SECONDS);
	}
	/**
	 * used to wait till the specific element is visible
	 * @param driver
	 * @param element
	 */
	public void waitTillElementTObeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPATHConstants.explicitwaitduration));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	/**
	 * waiting till an element is clickable
	 * @param driver
	 * @param element
	 */
	public void waitTillElementTObeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPATHConstants.explicitwaitduration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * waiting till alert popuop shows up
	 * @param driver
	 */
	public void waitForAlertPopup(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPATHConstants.explicitwaitduration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * used to wait till the title is matching with specific title
	 * @param driver
	 * @param title
	 */
	public void waitForATitle(WebDriver driver, String title) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPATHConstants.explicitwaitduration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	
	public void waitForTheUrl(WebDriver driver, String url) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPATHConstants.explicitwaitduration));
		wait.until(ExpectedConditions.urlContains(url));
	}
	
	/**
	 * used to ignore NoSuchElementException
	 * @param driver
	 */
	public void ignoreNoSuchElementException(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPATHConstants.explicitwaitduration));
		wait.ignoring(NoSuchElementException.class);
	}
	
	/**
	 * used to select any element using select by index
	 * @param element
	 * @param index
	 */
	public void selectElementInDropdown(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * used to select an element by using select by value
	 * @param element
	 * @param value
	 */
	public void selectElementInDropdown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * this method is used to select any element from the dropdown using visible text
	 * @param text
	 * @param element
	 */
	public void selectElementInDropdown(String text,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * this method is used to get all the options of a list box
	 * @param element
	 */
	public void getAllOptionFromDropdown(WebElement element)
	{
		Select s=new Select(element);
		List<WebElement> options = s.getOptions();
		for(WebElement option:options) {
			String text=option.getText();
			System.out.println(text);
		}
	}
	/**
	 * this method is used for mouse hover action to any web element
	 * @param driver
	 * @param element
	 */
	public void mouseOverElement(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();;
	}
	/**
	 * this method is used to right click on any element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element).perform();;
	}
	/**
	 * this method is used to perform double click on any web element
	 * @param driver
	 * @param src
	 * @param trg
	 */
	public void doubleClickOnElement(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();;
	}
	
	/**
	 * this method is used to perform drag and drop on any web element
	 * @param driver
	 * @param src
	 * @param trg
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement trg) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src,trg).perform();;
	}
	/**
	 * this method is used to switch to frames using index 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String id) {
		driver.switchTo().frame(id);
	}
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * this method is used to go to main frame(supermost parent frame)
	 * @param driver
	 */
	public void switchToFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * this method is used to switch to alert popup and accept
	 * @param driver
	 * @param text
	 */
	public void switchToAlertPopupAndAccept(WebDriver driver,String text) {
		Alert a=driver.switchTo().alert();
		if(a.getText().trim().equalsIgnoreCase(text.trim())) 
			System.out.println("Alert is present");
			else
				System.out.println("alert is not present");
			a.accept();
		}
	/**
	 * this method is used to switch to alert popup and dismiss
	 * @param driver
	 * @param text
	 */
	public void switchToAlertPopupAndDismiss(WebDriver driver,String text) {
		Alert a=driver.switchTo().alert();
		if(a.getText().trim().equalsIgnoreCase(text.trim())) 
			System.out.println("Alert is present");
			else
				System.out.println("alert is not present");
			a.dismiss();
		}
	public void fileUpload(WebElement element, String path) {
		File f=new File(path);
		String abspath = f.getAbsolutePath();
		element.sendKeys(abspath);
	}
	
	/**
	 * this method is used for custom wait with custom polling period
	 * @param duration
	 * @param element
	 * @param pollingTime
	 */
 public void customWait(int duration,WebElement element, long pollingTime) {
	 int i=0;
	 while(i<duration) {
		 try {
			 element.click();
			 break;
		 }
		 catch(Exception e) {
			 try {
				 Thread.sleep(pollingTime);
			 }
			 catch(InterruptedException el) {
				 el.printStackTrace();
			 }
			 i++;
		 }
	 }
 }
	/**
	 * this method is used to take screenshot of a page
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver, String screenshotname) throws IOException  {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		LocalDateTime ldt=LocalDateTime.now();
		String dateTime=ldt.toString().replace(" ", " ").replace(":","-" );
		File dest=new File("./screenshots/"+screenshotname+" "+dateTime+".png");
		FileUtils.copyFile(src,dest);
		return screenshotname+dateTime;
	}
	/**
	 * this method is used to switch to window using title
	 * @param driver
	 * @param url
	 */
	public void switchWindow(WebDriver driver,String text) {
		Set<String> set = driver.getWindowHandles();
		for(String wd:set) {
			driver.switchTo().window(wd);
			String title=driver.getTitle();
			if(title.contains(text))
				break;
		}
	}
	/**
	 * this method is used to switch to window usring url
	 * @param driver
	 * @param url
	 */
	public void switchWindowWithUrl(WebDriver driver,String url) {
		Set<String> set = driver.getWindowHandles();
		for(String wd:set) {
			driver.switchTo().window(wd);
			String text=driver.getCurrentUrl();
			if(text.contains(url))
				break;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
