package com.twinliteRegisterRoomsAndUsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
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

import com.RE.Twinlite.ObjectRepository.HomePage;
import com.RE.Twinlite.ObjectRepository.LoginPage;
import com.RE.Twinlite.ObjectRepository.RegisterUserPage;
import com.RE.Twinlite.ObjectRepository.SearchPage;
import com.RE.Twinlite.ObjectRepository.UserLoginHome;
import com.RE.Twinlite.ObjectRepository.UserRegisterRoomsPage;
import com.Twinlite.genericUtilities.ExcelUtilities;
import com.Twinlite.genericUtilities.FileUtilities;
import com.Twinlite.genericUtilities.JavaUtilities;
import com.Twinlite.genericUtilities.WebDriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;


public class VerifyRegisterPropertyisplayedOrNot {

	public static void main(String[] args) throws InterruptedException, IOException {

		
		//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
		//https://github.com/RAHUL-700/TEAM-B-SDET48.git
		//https://github.com/RAHUL-700/TEAM-B-SDET48/tree/master
		
		JavaUtilities jus=new JavaUtilities();
		FileUtilities fus=new FileUtilities();
		ExcelUtilities eus=new ExcelUtilities();
		WebDriverUtilities wdus=new WebDriverUtilities();
		
		
	//opening browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=null;
		
		//selecting browser according to the property file data
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
		//generate random numbers
		int ranNo=jus.getRandomNumber();
		
	
		
		//opening the application for automation
		wdus.maximizeWindow(driver);
		
		String url=fus.getPropertyKeyValue("url");
		driver.get(url);
		
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
		registerUserPage.getSubmitUserReg().click();
		*/
		
		//log in to the application as a user
		String username=fus.getPropertyKeyValue("username");
		String password=fus.getPropertyKeyValue("password");
		
		homePage.getLoginbtn().click();

		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginAsUser(username, password);
		
		/*loginpage.getUsername().sendKeys(username);
		loginpage.getPassword().sendKeys(password);
		loginpage.getLogin().click();
		*/

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
		registerRoomsPage.registerRoomsInToApp( fullname,  alternat_mobile,  mobile,  email, plotNo, rooms,country,state,city,rent,deposit ,accommodation, description,landmark,address);
		
		/*
		registerRoomsPage.getFullname().sendKeys(fullname);
		registerRoomsPage.getAlternat_mobile().sendKeys(alternat_mobile);
		registerRoomsPage.getMobile().sendKeys(mobile);
		registerRoomsPage.getEmail().sendKeys(email);
		registerRoomsPage.getPlotNo().sendKeys(plotNo);
		registerRoomsPage.getRooms().sendKeys(rooms);
		registerRoomsPage.getCountry().sendKeys(country);
		registerRoomsPage.getState().sendKeys(state);
		registerRoomsPage.getCity().sendKeys(city);
		registerRoomsPage.getRent().sendKeys(rent);
		registerRoomsPage.getDeposit().sendKeys(deposit);
		registerRoomsPage.getAccommodation().sendKeys(accommodation);
		registerRoomsPage.getDescription().sendKeys(description);
		registerRoomsPage.getLandmark().sendKeys(landmark);
		registerRoomsPage.getAddress().sendKeys(address);
		
		WebElement options = registerRoomsPage.getVacantOrOccupied();
		
		Select s=new Select(options);
		s.selectByIndex(0);
		
		//uploading image
		WebElement scUploadElement = registerRoomsPage.getUploadImg();
				Thread.sleep(2000);
				wdus.fileUpload(scUploadElement, "./src/test/resources/Screenshot (38).png");
				
				registerRoomsPage.getSubmitRoomsReg().click();
		
		Thread.sleep(1000);
          String successText = registerRoomsPage.getSuccessText().getText();
		if(successText.contains("successfull"))
			System.out.println("property registered successfully");
		else
			System.out.println("property registration failed");
		*/
		
		//logout as user
		UserLoginHome userLoginHome=new UserLoginHome(driver);
		userLoginHome.getLogoutBtn().click();

		//searching the property in the welcome page of the application
		String SearchKey =	eus.getExcelData("LoginAdmin", 44, 1);
		String searchCity =	eus.getExcelData("LoginAdmin", 45, 1);
		
		
		homePage.getSearchbtn().click();		
		
		SearchPage searchPage=new SearchPage(driver);
		searchPage.getKeywordTxtBx().sendKeys(SearchKey);
		searchPage.getLocationTxtBx().sendKeys(searchCity);
		Thread.sleep(2000);
		searchPage.getSearch2Btn().click();
		
		//verify if the registered property is displayed
		List<WebElement> ownersList = searchPage.getOwnerList();
		boolean flag=false;
		for(WebElement owner:ownersList) {
			String mobileNo = owner.getText();
			if(mobileNo.contains(mobile)) {
		              flag=true;
		              System.out.println("Property was found in the search list successfully");
		              break;
		}}
		if(!flag) 
			System.out.println("Property was not  found in the search list successfully");
		driver.close();
	}

}
