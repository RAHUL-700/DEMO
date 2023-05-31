package com.DDT.POM.MethodCalling;

import java.io.IOException;
import java.util.List;
//HELLO BOSS

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.RE.Twinlite.ObjectRepository.HomePage;
import com.RE.Twinlite.ObjectRepository.SearchPage;
import com.RE.Twinlite.ObjectRepository.UserLoginHome;
import com.RE.Twinlite.ObjectRepository.UserRegisterRoomsPage;
import com.Twinlite.genericUtilities.BaseClass;
import com.Twinlite.genericUtilities.ExcelUtilities;
import com.Twinlite.genericUtilities.FileUtilities;
import com.Twinlite.genericUtilities.JavaUtilities;
//@Listeners(com.Twinlite.genericUtilities.ListenerImplimentations.class)//or <listener> in suit file
public class VerifyRegisterPropertyisplayedOrNot extends BaseClass{

	
	@Test(groups= {"SmokeTest"},retryAnalyzer=com.Twinlite.genericUtilities.RetryAnalyser.class)
	public static void main1() throws InterruptedException, IOException {
		
		//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
		//https://github.com/RAHUL-700/TEAM-B-SDET48.git
		//https://github.com/RAHUL-700/TEAM-B-SDET48/tree/master
		
		JavaUtilities jus=new JavaUtilities();
		 FileUtilities fus = new FileUtilities(); 
		 ExcelUtilities eus = new ExcelUtilities();
		
	
		//generate random numbers
		int ranNo=jus.getRandomNumber();
		
		
		//fetching data from excel file for user registration 
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
		//using generic method to register the room in to the application
		registerRoomsPage.registerRoomsInToApp( fullname,  alternat_mobile,  mobile,  email, plotNo, rooms,country,state,city,rent,deposit ,accommodation, description,landmark,address);
		UserRegisterRoomsPage urrup=new UserRegisterRoomsPage(driver);
        String Successmsg=urrup.getSuccessText().getText();

		Assert.assertTrue(Successmsg.contains("Registration successfull"),"property registration not successfull");
		
		Reporter.log("property registered successfully",true);
		
		//logout as user
		UserLoginHome userLoginHome=new UserLoginHome(driver);
		userLoginHome.getLogoutBtn().click();
		
		
		//Assert.fail();

		//searching the property in the welcome page of the application
		String SearchKey =	eus.getExcelData("LoginAdmin", 44, 1);
		String searchCity =	eus.getExcelData("LoginAdmin", 45, 1);
		
		//click on search button in the welcome page
		 HomePage hp = new HomePage(driver);
		hp.getSearchbtn().click();
		Reporter.log("search page opened successfully",true);
		
		SearchPage searchPage=new SearchPage(driver);
		searchPage.searchTheProperty( SearchKey,  searchCity);
		
		//verify if the registered property is displayed
		List<WebElement> ownersList = searchPage.getOwnerList();
		boolean flag=false;
		String mobileNo=null;
		for(WebElement mob:ownersList) 
		{
			 mobileNo = mob.getText();
			if(mobileNo.contains(mobile))
				break;
		}
		 Assert.assertTrue(mobileNo.contains(mobile),"pass");
		Reporter.log("test case passed",true);
		System.out.println("VerifyRegisterPropertyisplayedOrNot passed(1)");//THANK YOU
		//HELLO EVERYONE
	}}


