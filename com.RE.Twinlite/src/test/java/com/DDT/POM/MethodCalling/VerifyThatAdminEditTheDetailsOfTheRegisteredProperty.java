  package com.DDT.POM.MethodCalling;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.RE.Twinlite.ObjectRepository.HomePage;
import com.RE.Twinlite.ObjectRepository.LoginPage;
import com.RE.Twinlite.ObjectRepository.UserLoginHome;
import com.RE.Twinlite.ObjectRepository.UserRegisterRoomsPage;
import com.Twinlite.genericUtilities.BaseClass;
import com.Twinlite.genericUtilities.ExcelUtilities;
import com.Twinlite.genericUtilities.FileUtilities;
import com.Twinlite.genericUtilities.JavaUtilities;
import com.Twinlite.genericUtilities.WebDriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;


public class VerifyThatAdminEditTheDetailsOfTheRegisteredProperty extends BaseClass{

	@Test(groups= {"SmokeTest"},retryAnalyzer=com.Twinlite.genericUtilities.RetryAnalyser.class)
	public  void main3() throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
 		JavaUtilities jus=new JavaUtilities();
		
		//generate random numbers
		int ranNo=jus.getRandomNumber();
		
		
		//goto details and edit the details of a property registered by the user
			UserLoginHome userloginhome=new UserLoginHome(driver);
			//click on Details/Update button
			userloginhome.getDetailsBtn().click();
			//click on edit button of the room whose number is 8884771323
		driver.findElement(By.xpath("//p[contains(.,'8884771323')]/../../..//a")).click();

		String alternat_mobile =eus.getExcelData("LoginAdmin", 19, 1)+ranNo;
		Thread.sleep(1000);
		UserRegisterRoomsPage userRegisterRoomsPage=new UserRegisterRoomsPage(driver);
		//Editing the alternative number of a property using a method from pom class
		userRegisterRoomsPage.editAltNumber(alternat_mobile,"hello", driver);
		System.out.println("VerifyThatAdminEditTheDetailsOfTheRegisteredProperty passed(3)");
		
	}

}
