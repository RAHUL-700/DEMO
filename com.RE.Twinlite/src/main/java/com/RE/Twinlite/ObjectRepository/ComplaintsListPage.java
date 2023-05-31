package com.RE.Twinlite.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComplaintsListPage {
	
	@FindBy(xpath="//td")private List<WebElement> complaintcontents;
	
	//initialization using constructors
	public ComplaintsListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getComplaintcontents() {
		return complaintcontents;
	}
	
}
