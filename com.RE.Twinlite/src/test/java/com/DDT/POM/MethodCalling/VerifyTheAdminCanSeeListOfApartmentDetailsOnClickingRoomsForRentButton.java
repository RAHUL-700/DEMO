package com.DDT.POM.MethodCalling;

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
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.RE.Twinlite.ObjectRepository.ApartmentRegPage;
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

public class VerifyTheAdminCanSeeListOfApartmentDetailsOnClickingRoomsForRentButton extends BaseClass{

	@Test(groups= {"RegTest"},retryAnalyzer=com.Twinlite.genericUtilities.RetryAnalyser.class)
	public  void main5() throws InterruptedException, EncryptedDocumentException, IOException {

WebDriverManager.chromedriver().setup();

		int ranNo = jus.getRandomNumber();

		String usn=fLib.getPropertyKeyValue("username");
		String pwd=fLib.getPropertyKeyValue("password");
		String fullname =eus.getExcelData("LoginAdmin", 1, 1);
		String username1 =eus.getExcelData("LoginAdmin", 2, 1);
		String mobile =eus.getExcelData("LoginAdmin", 3, 1)+ranNo;
        String email =	ranNo+eus.getExcelData("LoginAdmin", 4, 1);	
        String password1 =eus.getExcelData("LoginAdmin", 5, 1);		
        String c_password =	eus.getExcelData("LoginAdmin", 6, 1);
		//registering a APPARTMENT property into the application
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
				String apartName=eus.getExcelData("LoginAdmin", 47, 1);
				String NoOfFlats=eus.getExcelData("LoginAdmin", 49, 1);
				String NoOfrooms = eus.getExcelData("LoginAdmin", 50, 1);
				String area =eus.getExcelData("LoginAdmin", 51, 1);
				
				
				//UserLoginHome ulh=new UserLoginHome(driver);
				//clicking register button in user home
			//ulh.getRegisterBtn().click();
				driver.findElement(By.xpath("//a[.='Register']")).click();
				UserRegisterRoomsPage userRegisterRoomsPage=new UserRegisterRoomsPage(driver);
				userRegisterRoomsPage.getRegAppartmtBtn().click();//clicking register apartment button in register rooms page
				ApartmentRegPage apartmentRegPage=new ApartmentRegPage(driver);
				
				//registering the apartment in to the app using the generic method 
		apartmentRegPage.registerApartmentInToApp(driver, apartName,  mobile,  alternat_mobile,  email ,  plotNo, country, state, city,
			 landmark ,  address,   fullname, NoOfFlats,  NoOfrooms, area ,  rent, deposit,
			 accommodation,  description);
		ApartmentRegPage arp=new ApartmentRegPage(driver);
		String apSuccuss=arp.getSuccessText().getText();
		Assert.assertTrue(apSuccuss.contains("success"), "Apartment registration");
		Reporter.log("Apartment registered succussfully",true);
		
		
		//click on logout button
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		
		String adminusn = eus.getExcelData("LoginAdmin", 13, 1);
		String adminpwd = eus.getExcelData("LoginAdmin", 14, 1);
		
		//log in to the application as a admin
		HomePage hp = new HomePage(driver);
 hp.getLoginbtn().click();
 //log in as admin in to the application
 LoginPage lp=new LoginPage(driver);
	lp.loginAsUser( adminusn, adminpwd);
				
		//click on details/update and check for newly registered room
				driver.findElement(By.xpath("//div[contains(.,'Rooms for Rent: ') and @class='alert alert-warning']")).click();
				List<WebElement> allRooms = driver.findElements(By.xpath("//p[contains(.,'Plot Number: ')]"));
				boolean flag=false;String abcd=null;
				for(WebElement room:allRooms) {
					String roomName = room.getText();
					if(roomName.contains(plotNo)) {
					abcd=roomName;
					break;
					}}
					Assert.assertTrue(abcd.contains(plotNo), "registered user not found");	
					System.out.println("VerifyTheAdminCanSeeListOfApartmentDetailsOnClickingRoomsForRentButton passed(5)");
	}

	}
