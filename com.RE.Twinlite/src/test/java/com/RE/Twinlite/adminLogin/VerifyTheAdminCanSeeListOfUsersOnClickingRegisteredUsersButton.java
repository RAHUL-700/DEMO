package com.RE.Twinlite.adminLogin;

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

import com.RE.Twinlite.ObjectRepository.HomePage;
import com.RE.Twinlite.ObjectRepository.LoginPage;
import com.RE.Twinlite.ObjectRepository.RegisterUserPage;
import com.RE.Twinlite.ObjectRepository.UserLoginHome;
import com.Twinlite.genericUtilities.ExcelUtilities;
import com.Twinlite.genericUtilities.FileUtilities;
import com.Twinlite.genericUtilities.JavaUtilities;
import com.Twinlite.genericUtilities.WebDriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTheAdminCanSeeListOfUsersOnClickingRegisteredUsersButton {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		JavaUtilities jus=new JavaUtilities();
		FileUtilities fus=new FileUtilities();
		ExcelUtilities eus=new ExcelUtilities();
		WebDriverUtilities wdus=new WebDriverUtilities();

		String browser=fus.getPropertyKeyValue("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
        wdus.maximizeWindow(driver);
		
		String url=fus.getPropertyKeyValue("url");
		String username=fus.getPropertyKeyValue("username");
		String password=fus.getPropertyKeyValue("password");
		driver.get(url);
		
		//generate random numbers
		int ranNo=jus.getRandomNumber();
		HomePage homePage = new HomePage(driver);
		homePage.getRegisteruserbtn().click();
		
		//fetching data from excel file for user registration 
		String fullname =eus.getExcelData("LoginAdmin", 1, 1);
		String username1 =eus.getExcelData("LoginAdmin", 2, 1);
		String mobile =eus.getExcelData("LoginAdmin", 3, 1)+ranNo;
        String email =	ranNo+eus.getExcelData("LoginAdmin", 4, 1);	
        String password1 =eus.getExcelData("LoginAdmin", 5, 1);		
        String c_password =	eus.getExcelData("LoginAdmin", 6, 1);
        
				//registering the user
 RegisterUserPage registerUserPage=new RegisterUserPage(driver);
 registerUserPage.registerUserInToApp( fullname, username1, mobile, email, password1, password1);
		/*
		registerUserPage.getFullname().sendKeys(fullname);
		registerUserPage.getUsername1().sendKeys(username1);
		registerUserPage.getMobile().sendKeys(mobile);
		registerUserPage.getEmail().sendKeys(email);
		registerUserPage.getPassword1().sendKeys(password1);
		registerUserPage.getC_password1().sendKeys(password1);
		Thread.sleep(1000);
		registerUserPage.getSubmitUserReg().click();*/
				
				//log in to the application as a user
		homePage.getLoginbtn().click();

		LoginPage loginpage=new LoginPage(driver);
		/*loginpage.getUsername().sendKeys(username);
		loginpage.getPassword().sendKeys(password);
		loginpage.getLogin().click();*/
		loginpage.loginAsUser(username, password);
		
		UserLoginHome userLoginHome=new UserLoginHome(driver);
		Thread.sleep(1000);
		userLoginHome.getLogoutBtn().click();
		
		
		String adminusn = eus.getExcelData("LoginAdmin", 13, 1);
		String adminpwd = eus.getExcelData("LoginAdmin", 14, 1);
		
		//log in to the application as a admin
		homePage.getLoginbtn().click();
		loginpage.loginAsUser(adminusn, adminpwd);
		/*
		loginpage.getUsername().sendKeys(adminusn);
		loginpage.getPassword().sendKeys(adminpwd);
		loginpage.getLogin().click();
		*/
		
		//click on registered users and check for newly registered user
				driver.findElement(By.xpath("//div[contains(.,'Registered Users: ') and @class='alert alert-warning']")).click();
				List<WebElement> allNames = driver.findElements(By.xpath("//td"));
				boolean flag=false;
				for(WebElement owner:allNames) {
					String ownerName = owner.getText();
					if(ownerName.contains(username)) {
				              flag=true;
				              System.out.println("User was found in the admin's User list successfully");
				              break;
				}}
				if(!flag) 
					System.out.println("User was not  found in the admin's User list successfully");
				driver.close();
	}

}
