package com.DDT.POM.MethodCalling;

import java.awt.Window;
import java.io.File;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.RE.Twinlite.ObjectRepository.HomePage;
import com.RE.Twinlite.ObjectRepository.LoginPage;
import com.RE.Twinlite.ObjectRepository.RegisterUserPage;
import com.RE.Twinlite.ObjectRepository.UserLoginHome;
import com.RE.Twinlite.ObjectRepository.UserRegisterRoomsPage;
import com.Twinlite.genericUtilities.BaseClass;
import com.Twinlite.genericUtilities.ExcelUtilities;
import com.Twinlite.genericUtilities.FileUtilities;
import com.Twinlite.genericUtilities.JavaUtilities;
import com.Twinlite.genericUtilities.WebDriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyThatUserCanEditTheRegisteredProperty extends BaseClass{

	@Test(groups= {"RegTest"},retryAnalyzer=com.Twinlite.genericUtilities.RetryAnalyser.class)
	public void main4() throws InterruptedException, EncryptedDocumentException, IOException {

		
	WebDriverManager.chromedriver().setup();
 		JavaUtilities jus=new JavaUtilities();

 		//generate random numbers
		int ranNo=jus.getRandomNumber();

		String fullname =eus.getExcelData("LoginAdmin", 1, 1);
		String username1 =eus.getExcelData("LoginAdmin", 2, 1);
		String mobile =eus.getExcelData("LoginAdmin", 3, 1)+ranNo;
        String email =	ranNo+eus.getExcelData("LoginAdmin", 4, 1);	
        String password1 =eus.getExcelData("LoginAdmin", 5, 1);		
        String c_password =	eus.getExcelData("LoginAdmin", 6, 1);
        
        HomePage homePage = new HomePage(driver);
		homePage.getRegisteruserbtn().click();
		
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
		//click on register button
		userloginhome.getRegisterBtn().click();
		
		UserRegisterRoomsPage registerRoomsPage=new UserRegisterRoomsPage(driver);
		//registering a property using generic methods from pom classes
		registerRoomsPage.registerRoomsInToApp( fullname,  alternat_mobile,  mobile,  email, plotNo, rooms,country,state,city,rent,deposit ,accommodation, description,landmark,address);
		UserRegisterRoomsPage urrup=new UserRegisterRoomsPage(driver);
        String Successmsg=urrup.getSuccessText().getText();

		Assert.assertTrue(Successmsg.contains("Registration successfull"),"property registration not successfull");
		
		//logout as user
		UserLoginHome userLoginHome=new UserLoginHome(driver);
		//click on logout button
		userLoginHome.getLogoutBtn().click();
		
		//first log in as user again
		homePage.getLoginbtn().click();
		 LoginPage lp=new LoginPage(driver);
		lp.loginAsUser(username1, password1);
		
		//edit the property
		
		//click on Details/Update button 
		userloginhome.getDetailsBtn().click();
		//click on the edit button for specific room 
		driver.findElement(By.xpath("//p[contains(.,'"+mobile+"')]/../../..//a")).click();
		Thread.sleep(2000);
		WebElement options2 = driver.findElement(By.xpath("//select[@id='vacant']"));
		Select s1=new Select(options2);
		s1.selectByValue("1");
		String otherdetails = eus.getExcelData("LoginAdmin", 34, 1);
		
		UserRegisterRoomsPage userRegisterRoomsPage=new UserRegisterRoomsPage(driver);
		//edit the alternative number of specific room
		userRegisterRoomsPage.editAltNumber(alternat_mobile,otherdetails, driver);
		System.out.println("VerifyThatUserCanEditTheRegisteredProperty passed(4)");
	}
}
