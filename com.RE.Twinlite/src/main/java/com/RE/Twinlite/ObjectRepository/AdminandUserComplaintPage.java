package com.RE.Twinlite.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AdminandUserComplaintPage {


	//declaration 
		@FindBy(xpath="//input[@name='name']")private WebElement apartTxtBx;
		@FindBy(xpath="//input[@name='cmp']")private WebElement compTxtBx;
		@FindBy(xpath="//a[.='Details/Update']")private WebElement detailsBtn;
		@FindBy(xpath="//button[.='Submit']")private WebElement submitBtn;
		@FindBy(xpath="//div[.='Sent Successfully']")private WebElement successMsg;
		
		
		
		//initialization using constructors
		public AdminandUserComplaintPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}



		public WebElement getSuccessMsg() {
			return successMsg;
		}



		public WebElement getApartTxtBx() {
			return apartTxtBx;
		}



		public WebElement getCompTxtBx() {
			return compTxtBx;
		}



		public WebElement getDetailsBtn() {
			return detailsBtn;
		}



		public WebElement getSubmitBtn() {
			return submitBtn;
		}
		
		public void risingAComplaint(String complaint,String compname) 
		{
			getCompTxtBx().sendKeys(complaint);
			getApartTxtBx().sendKeys(compname);
			getSubmitBtn().click();
			
			//verifying the complaint
			String check =getSuccessMsg().getText();
			Assert.assertTrue(check.contains("Sent Successfully"), "pass");
			Reporter.log("complaint rised successfully");
			/*if(check.contains("Sent Successfully"))
				System.out.println("complaint rised successfully");
			else 
				System.out.println("complaint rising failed");*/
		}
		
}
