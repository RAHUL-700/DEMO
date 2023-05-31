package com.RE.Twinlite.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginHome {

	
	
	//declaration 
		@FindBy(xpath="//a[.='Home']")private WebElement homeBtn;
		@FindBy(xpath="//a[.='Register']")private WebElement registerBtn;
		@FindBy(xpath="//a[.='Details/Update']")private WebElement detailsBtn;
		@FindBy(xpath="//b[text()='Registered Rooms: ']")private WebElement registeredRoomsBtn;
		@FindBy(xpath="//a[.='Logout']")private WebElement logoutBtn;
		
		
		
		//initialization using constructors
		public UserLoginHome(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}



		public WebElement getHomeBtn() {
			return homeBtn;
		}



		public WebElement getRegisterBtn() {
			return registerBtn;
		}



		public WebElement getDetailsBtn() {
			return detailsBtn;
		}



		public WebElement getRegisteredRoomsBtn() {
			return registeredRoomsBtn;
		}



		public WebElement getLogoutBtn() {
			return logoutBtn;
		}
		
		
}
