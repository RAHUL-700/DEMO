package com.Twinlite.genericUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {

	JavascriptExecutor js;
	/**
	 * this is a constructor
	 * @param driver
	 */
	public JavaScriptUtility(WebDriver driver){
		js=(JavascriptExecutor)driver;//typecasting
	}
	/**
	 * 
	 */
	public void scrollUp() {
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	/**
	 * 
	 */
	public void scrollDown() {
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	/**
	 * 
	 * @param element
	 */
	public void scrollTillElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	/**
	 * 
	 * @param url
	 */
	public void launchApplication(String url) {
		js.executeScript("window.location=arguments [0]", url);
	} 
	/** 
	 * 
	 * @param element
	 * @param data
	 */
	public void sendKeys(WebElement element, String data) {
		js.executeScript("argumernts[0].value=arguments[1]", element,data);
	} 
	/**
	 * 
	 * @param element
	 */
	public void click(WebElement element) {
		js.executeScript("arguments[0].click()", element);
	}
	/**
	 * 
	 * @param elementID
	 */
	public void clickElementById(String elementID) {
		js.executeScript("document.getElementById('elementID').click()");
	} 
	/**
	 * 
	 * @param element
	 * @return
	 *  /
	public String getTheText(WebElement element) {
		String textfieldValue=(String)js.executeScript("return.arguments[0].value;", element);
		return textfieldValue;
	}
	/**
	 * 
	 * @return
	 */
	public String urlOfCurrentPage() {
		String url=(String) js.executeScript("return window.location.href");
		return url;
	}
	
	/**
	 * 
	 * @return
	 */
	public String titleOfCurrentPage() {
		String title=(String)js.executeScript("return document.title");
		return title;
	}
}
