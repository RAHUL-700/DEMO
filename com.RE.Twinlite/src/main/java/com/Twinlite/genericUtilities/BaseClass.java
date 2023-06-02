package com.Twinlite.genericUtilities;
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.RE.Twinlite.ObjectRepository.HomePage;
import com.RE.Twinlite.ObjectRepository.LoginPage;
import com.RE.Twinlite.ObjectRepository.RegisterUserPage;
import com.RE.Twinlite.ObjectRepository.UserLoginHome;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		
		public DataBaseUtility dLib = new DataBaseUtility();
		public FileUtilities fLib = new FileUtilities();
		public ExcelUtilities eus = new ExcelUtilities();
		public WebDriverUtilities wLib = new WebDriverUtilities();
		public static WebDriver driver;
		
		public JavaUtilities jus=new JavaUtilities();
		
		// connect to DB
		@BeforeSuite(groups= {"SmokeTest","RegTest"}) 
		public void Config_BS() throws Throwable
		{
			//dLib.connectToDb();

			
			//Thread.sleep(5000);
			//ji
			System.out.println("-- connect to DB---");
		}
		
		
		//to launch the browser
		//@Parameters("browser")
		@BeforeClass(groups= {"SmokeTest","RegTest"})
		//@BeforeTest//String BROWSER
		public void config_BC() throws Throwable
		{
			String BROWSER = fLib.getPropertyKeyValue("browser");
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			
			if(BROWSER.equalsIgnoreCase("edge"))
			{
				//WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			String URL = fLib.getPropertyKeyValue("url");
			driver.get(URL);
			wLib.maximizeWindow(driver);
			Thread.sleep(60000);
			//wLib.waitTillPageGetsLoaded(driver);
			System.out.println("-- browser opened successfully---");
		}
		
		// login to App
		@BeforeMethod(groups= {"SmokeTest","RegTest"})
		public void confi_BM() throws Throwable
		{
			int ranNo=jus.getRandomNumber();
			String usn=fLib.getPropertyKeyValue("username");
			String pwd=fLib.getPropertyKeyValue("password");
			String fullname =eus.getExcelData("LoginAdmin", 1, 1);
			String username1 =eus.getExcelData("LoginAdmin", 2, 1);
			String mobile =eus.getExcelData("LoginAdmin", 3, 1)+ranNo;
	        String email =	ranNo+eus.getExcelData("LoginAdmin", 4, 1);	
	        String password1 =eus.getExcelData("LoginAdmin", 5, 1);		
	        String c_password =	eus.getExcelData("LoginAdmin", 6, 1);
	        
	        //click on register user button
	        HomePage hp = new HomePage(driver);
	        hp.getRegisteruserbtn().click();
	        RegisterUserPage registerUserPage=new RegisterUserPage(driver);
	        registerUserPage.registerUserInToApp(username1, password1, email, mobile, password1, c_password);
	        
	    	//login as user
	        LoginPage lp=new LoginPage(driver);
	    	 hp.getLoginbtn().click();
	        lp.loginAsUser(usn, pwd);
	        System.out.println("---logged in successfully---");
	        Thread.sleep(1000);
	        
		}
		
		//logout from App
		@AfterMethod(groups= {"SmokeTest","RegTest"})
		public void config_AM()
		{
			UserLoginHome usd=new UserLoginHome(driver);
			//usd.getLogoutBtn().click();
			System.out.println("-- logged out from app --");
		}
		
		// close the browser
		@AfterClass(groups= {"SmokeTest","RegTest"})
		//@AfterTest
		public void config_AC()
		{
			driver.quit();
			System.out.println("---browser closed successfully---");
		}
		
		// disconnect database
		@AfterSuite(groups= {"SmokeTest","RegTest"})
		public void config_AS() throws Throwable
		{
			dLib.closeDb();
			System.out.println("---Db connection closed---");
			
		}

	}


