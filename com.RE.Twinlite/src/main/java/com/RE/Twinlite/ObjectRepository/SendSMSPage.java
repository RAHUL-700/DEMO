package com.RE.Twinlite.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendSMSPage {

	
	
	@FindBy(id="selectAll$key")private WebElement checkBox;
	@FindBy(xpath="//td")private List<WebElement> contents;
	@FindBy(name="message")private List<WebElement> messageTxtBx;
	@FindBy(name="sms_alert")private WebElement sendsmsBtn;
	
	//initialization using constructors
	public SendSMSPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public List<WebElement> getContents() {
		return contents;
	}

	public List<WebElement> getMessageTxtBx() {
		return messageTxtBx;
	}

	public WebElement getSendsmsBtn() {
		return sendsmsBtn;
	}
	
	
	
}
