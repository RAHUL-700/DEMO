package com.DDT.POM.MethodCalling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
//HELLO DEVASHISH
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.RE.Twinlite.ObjectRepository.AdminandUserComplaintPage;
import com.RE.Twinlite.ObjectRepository.HomePage;
import com.RE.Twinlite.ObjectRepository.LoginPage;
import com.RE.Twinlite.ObjectRepository.RegisterUserPage;
import com.RE.Twinlite.ObjectRepository.UserDetails_UpdatePage;
import com.RE.Twinlite.ObjectRepository.UserLoginHome;
import com.RE.Twinlite.ObjectRepository.UserRegisterRoomsPage;
import com.Twinlite.genericUtilities.BaseClass;
import com.Twinlite.genericUtilities.ExcelUtilities;
import com.Twinlite.genericUtilities.FileUtilities;
import com.Twinlite.genericUtilities.JavaUtilities;
import com.Twinlite.genericUtilities.WebDriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyThatAdminCanFileAComplaintForTheRegisteredPropertyTest extends BaseClass{

	int ranNo=jus.getRandomNumber();
	
	@Test(groups= {"SmokeTest"},retryAnalyzer=com.Twinlite.genericUtilities.RetryAnalyser.class)
	public  void main2() throws InterruptedException, IOException {

		
		//generate random numbers
		int ranNo=jus.getRandomNumber();
		String usn=fLib.getPropertyKeyValue("username");
		String pwd=fLib.getPropertyKeyValue("password");
		String fullname =eus.getExcelData("LoginAdmin", 1, 1);
		String username1 =eus.getExcelData("LoginAdmin", 2, 1);
		String mobile =eus.getExcelData("LoginAdmin", 3, 1)+ranNo;
        String email =	ranNo+eus.getExcelData("LoginAdmin", 4, 1);	
        String password1 =eus.getExcelData("LoginAdmin", 5, 1);		
        String c_password =	eus.getExcelData("LoginAdmin", 6, 1);
		
		//fetching data for registering property using excel file
		String alternat_mobile =	eus.getExcelData("LoginAdmin", 19, 1)+ranNo;
		String plotNo =	eus.getExcelData("LoginAdmin", 21, 1);
		String rooms =	eus.getExcelData("LoginAdmin", 22, 1);
		String country =	eus.getExcelData("LoginAdmin", 23, 1);
		String state =	eus.getExcelData("LoginAdmin", 24, 1);
		String city =	eus.getExcelData("LoginAdmin", 25, 1);
		String rent =	eus.getExcelData("LoginAdmin", 26, 1);
		String deposit =	eus.getExcelData("LoginAdmin", 27, 1);
		String accommodation =	eus.getExcelData("LoginAdmin", 28, 1);
		String description =	eus.getExcelData("LoginAdmin", 29, 1);
		String landmark =	eus.getExcelData("LoginAdmin", 30, 1);
		String address =	eus.getExcelData("LoginAdmin", 31, 1);
		
		
		//registering a property into the application
		
		UserLoginHome userloginhome=new UserLoginHome(driver);
		userloginhome.getRegisterBtn().click();
		
		UserRegisterRoomsPage registerRoomsPage=new UserRegisterRoomsPage(driver);
		//registering the room into the application using methods from pom class
		registerRoomsPage.registerRoomsInToApp( fullname,  alternat_mobile,  mobile,  email, plotNo, rooms,country,state,city,rent,deposit ,accommodation, description,landmark,address);
		UserRegisterRoomsPage urrup=new UserRegisterRoomsPage(driver);
        String Successmsg=urrup.getSuccessText().getText();
		
      UserLoginHome userLoginHome = new UserLoginHome(driver);
      //clicking on logout button 
      userLoginHome.getLogoutBtn().click();
		
		//first log in as admin 
      HomePage hp = new HomePage(driver);
      hp.getLoginbtn().click();
String adminusn = eus.getExcelData("LoginAdmin", 13, 1);
String adminpwd = eus.getExcelData("LoginAdmin", 14, 1);

//log in to app as admin using method from pom classes
LoginPage lp=new LoginPage(driver);
lp.loginAsUser(adminusn, adminpwd);

		//rising a complaint
//clicking on deatils/Update button
UserLoginHome ulh=new UserLoginHome(driver);
ulh.getDetailsBtn().click();
UserDetails_UpdatePage userDetails_UpdatePage=new UserDetails_UpdatePage(driver);
//clicking on complaint button
userDetails_UpdatePage.getComplaintBtn().click();
		
		String compname =eus.getExcelData("LoginAdmin", 38, 1)+ranNo;
		String complaint =eus.getExcelData("LoginAdmin", 39, 1)+ranNo;

		AdminandUserComplaintPage adminandUserComplaintPage=new AdminandUserComplaintPage(driver);
		//raising a complaint using a method from pom class and verifying the complaint
		adminandUserComplaintPage.risingAComplaint(complaint,compname);
		System.out.println("VerifyThatAdminCanFileAComplaintForTheRegisteredProperty passed(2)");
		
	}

}
