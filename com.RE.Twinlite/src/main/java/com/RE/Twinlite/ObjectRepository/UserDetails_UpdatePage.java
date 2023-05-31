package com.RE.Twinlite.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDetails_UpdatePage {

	@FindBy(xpath="//a[.='Complaint']")private WebElement ComplaintBtn;
	@FindBy(xpath="")private List<WebElement> rommsDetails;
	
	//initialization using constructors
	public UserDetails_UpdatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getComplaintBtn() {
		return ComplaintBtn;
	}

	public List<WebElement> getRommsDetails() {
		return rommsDetails;
	}
	
	
	
	
	
}
