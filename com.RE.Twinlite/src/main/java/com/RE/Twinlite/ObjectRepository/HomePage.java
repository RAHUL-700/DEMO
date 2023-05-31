package com.RE.Twinlite.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author satya
 *
 */
public class HomePage {
//declaration of elements
	@FindBy(xpath="//a[.='Search']")private WebElement searchbtn;
	@FindBy(xpath="//a[.='Register']")private WebElement registeruserbtn;
	@FindBy(xpath="//a[.='Login']")private WebElement loginbtn;
	
	
	
	@FindBy(xpath="//a[.='Logo/Home']")private WebElement home_logoBtn;
	
	//initialization using constructors
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}
	
	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getRegisteruserbtn() {
		return registeruserbtn;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	

	public WebElement getHome_logoBtn() {
		return home_logoBtn;
	}
	
	public void clickRegisteruserbtn() {
		 registeruserbtn.click();
	}

	
}
