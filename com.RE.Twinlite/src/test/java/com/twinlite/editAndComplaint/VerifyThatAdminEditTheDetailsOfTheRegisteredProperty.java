  package com.twinlite.editAndComplaint;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.RE.Twinlite.ObjectRepository.HomePage;
import com.RE.Twinlite.ObjectRepository.LoginPage;
import com.RE.Twinlite.ObjectRepository.UserLoginHome;
import com.RE.Twinlite.ObjectRepository.UserRegisterRoomsPage;
import com.Twinlite.genericUtilities.ExcelUtilities;
import com.Twinlite.genericUtilities.FileUtilities;
import com.Twinlite.genericUtilities.JavaUtilities;
import com.Twinlite.genericUtilities.WebDriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;


public class VerifyThatAdminEditTheDetailsOfTheRegisteredProperty {

	public static void main(String[] args) throws InterruptedException, IOException {

 		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
 		JavaUtilities jus=new JavaUtilities();
		FileUtilities fus=new FileUtilities();
		ExcelUtilities eus=new ExcelUtilities();
		WebDriverUtilities wdus=new WebDriverUtilities();

		String browser=fus.getPropertyKeyValue("browser");
		
		//selecting browser according to the property file data
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		String url=fus.getPropertyKeyValue("url");
		String username=fus.getPropertyKeyValue("username");
		String password=fus.getPropertyKeyValue("password");
		
		driver.get(url);
		wdus.maximizeWindow(driver);
		
		
		//generate random numbers
		int ranNo=jus.getRandomNumber();
		
		//fetching data from excel file for user registration 
		 
		 String adminusn = eus.getExcelData("LoginAdmin", 13, 1);
			String adminpwd = eus.getExcelData("LoginAdmin", 14, 1);
		
		//log in to the application as a admin
			
			HomePage homePage=new HomePage(driver);
			homePage.getLoginbtn().click();

			/*
			LoginPage loginpage=new LoginPage(driver);
			loginpage.getUsername().sendKeys(adminusn);
			loginpage.getPassword().sendKeys(adminpwd);
			loginpage.getLogin().click();*/
			
			LoginPage loginpage=new LoginPage(driver);
			loginpage.loginAsUser(username, password);
		
		//goto details and edit the details of a property registered by the user
			UserLoginHome userloginhome=new UserLoginHome(driver);
			userloginhome.getDetailsBtn().click();
		driver.findElement(By.xpath("//p[contains(.,'8884771323')]/../../..//a")).click();
	
		
		String alternat_mobile =	eus.getExcelData("LoginAdmin", 19, 1)+ranNo;
		
		Thread.sleep(1000);
		UserRegisterRoomsPage userRegisterRoomsPage=new UserRegisterRoomsPage(driver);
		userRegisterRoomsPage.editAltNumber(alternat_mobile,"hello", driver);
		
		/*
		userRegisterRoomsPage.getAlternat_mobile().clear();
		userRegisterRoomsPage.getAlternat_mobile().sendKeys(alternat_mobile);
		userRegisterRoomsPage.getOtherTxtBx().sendKeys("hello");
		userRegisterRoomsPage.getSubmitRoomsReg().click();
		
		//verify if the mobile number is changed
		userloginhome.getDetailsBtn().click();
		List<WebElement> allPhones = driver.findElements(By.xpath("//p[contains(.,'"+alternat_mobile+"')]"));
		boolean flag=false;
		for(WebElement phone:allPhones) {
			String phoneNo =phone.getText();
			if(phoneNo.contains(alternat_mobile)) {
		              flag=true;
		              System.out.println("phone number was edited successfully by the admin");
		              break;
		}}
		if(!flag) 
			System.out.println("admin could not edit the phone number successfully");*/
		Thread.sleep(1000);
		driver.quit();
		
		
	}

}
