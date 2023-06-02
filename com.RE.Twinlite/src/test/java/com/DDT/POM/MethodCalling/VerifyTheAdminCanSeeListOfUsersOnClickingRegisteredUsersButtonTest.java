package com.DDT.POM.MethodCalling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.RE.Twinlite.ObjectRepository.HomePage;
import com.RE.Twinlite.ObjectRepository.LoginPage;
import com.RE.Twinlite.ObjectRepository.RegisterUserPage;
import com.RE.Twinlite.ObjectRepository.UserLoginHome;
import com.Twinlite.genericUtilities.BaseClass;
import com.Twinlite.genericUtilities.ExcelUtilities;
import com.Twinlite.genericUtilities.FileUtilities;
import com.Twinlite.genericUtilities.JavaUtilities;
import com.Twinlite.genericUtilities.WebDriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTheAdminCanSeeListOfUsersOnClickingRegisteredUsersButtonTest extends BaseClass{

	@Test(groups= {"RegTest"},retryAnalyzer=com.Twinlite.genericUtilities.RetryAnalyser.class)
	public  void main6() throws InterruptedException, EncryptedDocumentException, IOException {

		WebDriverManager.chromedriver().setup();
		JavaUtilities jus=new JavaUtilities();
		FileUtilities fus=new FileUtilities();
		ExcelUtilities eus=new ExcelUtilities();
		WebDriverUtilities wdus=new WebDriverUtilities();

		
		
		//generate random numbers
		int ranNo=jus.getRandomNumber();
		HomePage homePage = new HomePage(driver);
		
		//fetching data from excel file for user registration 
		String fullname =eus.getExcelData("LoginAdmin", 1, 1);
		String username1 =eus.getExcelData("LoginAdmin", 2, 1);
		String mobile =eus.getExcelData("LoginAdmin", 3, 1)+ranNo;
        String email =	ranNo+eus.getExcelData("LoginAdmin", 4, 1);	
        String password1 =eus.getExcelData("LoginAdmin", 5, 1);		
        String c_password =	eus.getExcelData("LoginAdmin", 6, 1);
      
		UserLoginHome userLoginHome=new UserLoginHome(driver);
		Thread.sleep(1000);
		//logout as user
		userLoginHome.getLogoutBtn().click();
		Reporter.log("login and logout scuccessfully");
		
		
		String adminusn = eus.getExcelData("LoginAdmin", 13, 1);
		String adminpwd = eus.getExcelData("LoginAdmin", 14, 1);
		
		//log in to the application as a admin
		homePage.getLoginbtn().click();
		//log in as admin in to the app
		LoginPage lp=new LoginPage(driver);
		lp.loginAsUser(adminusn, adminpwd);
		Reporter.log("logged in as admin scuccessfully");
		
		//click on registered users and check for newly registered user
				driver.findElement(By.xpath("//div[contains(.,'Registered Users: ') and @class='alert alert-warning']")).click();
				List<WebElement> allNames = driver.findElements(By.xpath("//td"));
				boolean flag=false;String abcd=null;
				for(WebElement owner:allNames) {
					String ownerName = owner.getText();
					if(ownerName.contains(username1)) {
					abcd=username1;
					break;
					}}
					Assert.assertTrue(abcd.contains(username1), "user not found");	
					Reporter.log("searched scuccessfully");
					System.out.println("VerifyTheAdminCanSeeListOfUsersOnClickingRegisteredUsersButton passed(6)");
				
	}

}
