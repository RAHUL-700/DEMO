package com.RE.Twinlite.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	

	//declaration 
	@FindBy(name="username")private WebElement username;
	@FindBy(name="password")private WebElement password;
	@FindBy(name="login")private WebElement login;
	
	
	
	//initialization using constructors
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public WebElement getUsername() {
		return username;
	}



	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}
	public void loginAsUser(String username,String password) {
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getLogin().click();
	}
	
	
}
