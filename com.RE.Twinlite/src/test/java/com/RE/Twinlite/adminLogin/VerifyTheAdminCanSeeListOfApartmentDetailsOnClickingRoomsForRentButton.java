package com.RE.Twinlite.adminLogin;

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

	//public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

WebDriver driver=null;
//WebDriverManager.chromedriver().setup();
		
		/*JavaUtilities jus=new JavaUtilities();
		FileUtilities fus=new FileUtilities();
		ExcelUtilities eus=new ExcelUtilities();
		WebDriverUtilities wdus=new WebDriverUtilities();*/

		/*String browser=fus.getPropertyKeyValue("browser");
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
		*/
		
		
		@Test
		public void sample() throws InterruptedException, IOException {
		//generate random numbers
		int ranNo=jus.getRandomNumber();
		
		//fetching data from excel file for user registration 
		String fullname =eus.getExcelData("LoginAdmin", 1, 1);
		String username1 =eus.getExcelData("LoginAdmin", 2, 1);
		String mobile =eus.getExcelData("LoginAdmin", 3, 1)+ranNo;
        String email =	ranNo+eus.getExcelData("LoginAdmin", 4, 1);	
        String password1 =eus.getExcelData("LoginAdmin", 5, 1);		
        String c_password =	eus.getExcelData("LoginAdmin", 6, 1);

    	
		
        
				//registering the user
 /*RegisterUserPage registerUserPage=new RegisterUserPage(driver);
 registerUserPage.registerUserInToApp( fullname, username1, mobile, email, password1, password1);*/
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
	/*	homePage.getLoginbtn().click();
		LoginPage loginpage=new LoginPage(driver);
		String username=fus.getPropertyKeyValue("username");
		String password=fus.getPropertyKeyValue("password");
		loginpage.loginAsUser(username, password);*/
		/*
		LoginPage loginpage=new LoginPage(driver);
		loginpage.getUsername().sendKeys(username);
		loginpage.getPassword().sendKeys(password);
		loginpage.getLogin().click();*/
		
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
				
				
				UserLoginHome userLoginHome=new UserLoginHome(driver);
				userLoginHome.getRegisterBtn().click();//clicking register button in user home
				UserRegisterRoomsPage userRegisterRoomsPage=new UserRegisterRoomsPage(driver);
				userRegisterRoomsPage.getRegAppartmtBtn().click();//clicking register apartment button in register rooms page
				//ApartmentRegPage apartmentRegPage=new ApartmentRegPage(driver);
				/*
				apartmentRegPage.getApartname().sendKeys(apartName);
				Thread.sleep(2000);
				apartmentRegPage.getMobile().sendKeys(mobile);
				apartmentRegPage.getAlternat_mobile().sendKeys(alternat_mobile);
				apartmentRegPage.getEmail().sendKeys(email);
				apartmentRegPage.getPlotNo().sendKeys(plotNo);
				apartmentRegPage.getCountry().sendKeys(country);
				apartmentRegPage.getState().sendKeys(state);
				apartmentRegPage.getCity().sendKeys(city);
				apartmentRegPage.getLandmark().sendKeys(landmark);
				apartmentRegPage.getAddress().sendKeys(address);
		
		//uploading image
				File f=new File("./src/test/resources/Screenshot (38).png");
				String abspath = f.getAbsolutePath();
				apartmentRegPage.getUploadImg().sendKeys(abspath);
				Thread.sleep(2000);
				apartmentRegPage.getMoreFlatsBtn().click();
				
				String NoOfFlats=eus.getExcelData("LoginAdmin", 49, 1);
				String NoOfrooms = eus.getExcelData("LoginAdmin", 50, 1);
				String area =eus.getExcelData("LoginAdmin", 51, 1);
				
				apartmentRegPage.getFullname().sendKeys(fullname);
				apartmentRegPage.getNoOfFlats().sendKeys(NoOfFlats);
				apartmentRegPage.getNoOfRooms().sendKeys(NoOfrooms);
				apartmentRegPage.getArea().sendKeys(area);
				apartmentRegPage.getRent().sendKeys(rent);
				apartmentRegPage.getDeposit().sendKeys(deposit);
				apartmentRegPage.getAccommodation().sendKeys(accommodation);
				apartmentRegPage.getDescription().sendKeys(description);

				WebElement options2 = driver.findElement(By.xpath("//select[@id='vacant']"));
				Select s1=new Select(options2);
				s1.selectByValue("1");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//button[.='Submit']")).click();
				
				
				String successText = apartmentRegPage.getSuccessText().getText();
		if(successText.contains("successfull"))
			System.out.println("Apartment registered successfully");
		else
			System.out.println("Apartment registration failed");}*/
				ApartmentRegPage apartmentRegPage=new ApartmentRegPage(driver);
				
		apartmentRegPage.registerApartmentInToApp(driver, apartName,  mobile,  alternat_mobile,  email ,  plotNo, country, state, city,
			 landmark ,  address,   fullname, NoOfFlats,  NoOfrooms, area ,  rent, deposit,
			 accommodation,  description);
		
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		
		String adminusn = eus.getExcelData("LoginAdmin", 13, 1);
		String adminpwd = eus.getExcelData("LoginAdmin", 14, 1);
		
		//log in to the application as a admin
 //hp.getLoginbtn().click();
 /*
 loginpage.getUsername().sendKeys(adminusn);
 loginpage.getPassword().sendKeys(adminpwd);
	loginpage.getLogin().click();*/
 
		LoginPage lp=new LoginPage(driver);
	lp.loginAsUser( adminusn, adminpwd);
				
		//click on registered users and check for newly registered user
				driver.findElement(By.xpath("//div[contains(.,'Rooms for Rent: ') and @class='alert alert-warning']")).click();
				List<WebElement> allRooms = driver.findElements(By.xpath("//p[contains(.,'Plot Number: ')]"));
				boolean flag=false;
				for(WebElement room:allRooms) {
					String roomName = room.getText();
					if(roomName.contains(plotNo)) {
				              flag=true;
				              System.out.println("apartment was found in the admin's registered room list successfully");
				              break;
				}}
				if(!flag) 
					System.out.println("apartment was not  found in the admin's registered room list successfully");
				driver.quit();
	}

}
