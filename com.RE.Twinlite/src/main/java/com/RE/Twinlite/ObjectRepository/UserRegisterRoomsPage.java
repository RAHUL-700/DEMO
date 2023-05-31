package com.RE.Twinlite.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.Twinlite.genericUtilities.WebDriverUtilities;

public class UserRegisterRoomsPage {
	
	//declaration 
		@FindBy(xpath="//input[@id='fullname']")private WebElement fullname;
		@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='mobile']")private WebElement mobile;
		@FindBy(xpath="//h2[.='Register Room']/../form//input[@id='alternat_mobile']")private WebElement alternat_mobile;
		@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='email']")private WebElement email;
		@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='plot_number']")private WebElement plotNo;
		@FindBy(xpath="(//input[@name='rooms'])")private WebElement rooms;
		@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='country']")private WebElement country;
		@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='state']")private WebElement state;
		@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='city']")private WebElement city;
		@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='rent']")private WebElement rent;
		@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='deposit']")private WebElement deposit;
		@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='accommodation']")private WebElement accommodation;
		@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='description']")private WebElement description;
		@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='landmark']")private WebElement landmark;
		@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='address']")private WebElement address;
		@FindBy(xpath="//select[@class='form-control']")private WebElement vacantOrOccupied;
		@FindBy(xpath="//h2[.='Register Room']/../form//input[@name='image']")private WebElement UploadImg;
		@FindBy(xpath="//h2[.='Register Room']/../form//button[.='Submit']")private WebElement submitRoomsReg;
		@FindBy(xpath="//input[@name='other']")private WebElement otherTxtBx;
		
		@FindBy(xpath="//a[.='Apartment Registration']")private WebElement RegAppartmtBtn;
		@FindBy(xpath="(//div[.='Registration successfull. Thank you'])[1]")private WebElement successText;
		@FindBy(xpath="//div[.='Registration successfull. Thank You']")private WebElement successUserMsg;
		
		//initialization using constructors
				public UserRegisterRoomsPage(WebDriver driver) {
					PageFactory.initElements(driver, this);
				}
		
		public WebElement getSuccessUserMsg() {
			return successUserMsg;}

		public WebElement getOtherTxtBx() {
			return otherTxtBx;
		}

		public WebElement getFullname() {
			return fullname;
		}
		
		public WebElement getSuccessText() {
			return successText;
		}

		public WebElement getMobile() {
			return mobile;
		}

		public WebElement getAlternat_mobile() {
			return alternat_mobile;
		}

		public WebElement getEmail() {
			return email;
		}

		public WebElement getPlotNo() {
			return plotNo;
		}

		public WebElement getRooms() {
			return rooms;
		}

		public WebElement getCountry() {
			return country;
		}

		public WebElement getState() {
			return state;
		}

		public WebElement getCity() {
			return city;
		}

		public WebElement getRent() {
			return rent;
		}

		public WebElement getDeposit() {
			return deposit;
		}

		public WebElement getAccommodation() {
			return accommodation;
		}

		public WebElement getDescription() {
			return description;
		}

		public WebElement getLandmark() {
			return landmark;
		}

		public WebElement getAddress() {
			return address;
		}

		public WebElement getVacantOrOccupied() {
			return vacantOrOccupied;
		}

		public WebElement getUploadImg() {
			return UploadImg;
		}

		public WebElement getSubmitRoomsReg() {
			return submitRoomsReg;
		}

		public WebElement getRegAppartmtBtn() {
			return RegAppartmtBtn;
		}
		WebDriverUtilities wdus=new WebDriverUtilities();
		public void registerRoomsInToApp(String fullname, String alternat_mobile, String mobile, String email, String plotNo,String rooms,String country,String state, String city, String rent, String deposit ,String accommodation, String description,String landmark, String  address) throws InterruptedException
		{
			getFullname().sendKeys(fullname);
			getAlternat_mobile().sendKeys(alternat_mobile);
			getMobile().sendKeys(mobile);
			getEmail().sendKeys(email);
			getPlotNo().sendKeys(plotNo);
			getRooms().sendKeys(rooms);
			getCountry().sendKeys(country);
			getState().sendKeys(state);
			getCity().sendKeys(city);
			getRent().sendKeys(rent);
			getDeposit().sendKeys(deposit);
			getAccommodation().sendKeys(accommodation);
			getDescription().sendKeys(description);
			getLandmark().sendKeys(landmark);
			getAddress().sendKeys(address);
			
			WebElement options = getVacantOrOccupied();
			
			Select s=new Select(options);
			s.selectByIndex(0);
			
			//uploading image
			WebElement scUploadElement = getUploadImg();
					Thread.sleep(2000);
					wdus.fileUpload(scUploadElement, "./src/test/resources/Screenshot (38).png");
					getSubmitRoomsReg().click();
					Thread.sleep(2000);
			        String successText = getSuccessText().getText();
					Assert.assertTrue(successText.contains("successfull"), "property registration failed");
		}
		
		public void editAltNumber(String alternat_mobile, String msg, WebDriver driver) {
			getAlternat_mobile().clear();
			getAlternat_mobile().sendKeys(alternat_mobile);
			getOtherTxtBx().sendKeys("hello");
			getSubmitRoomsReg().click();
			
			//verify if the mobile number is changed
			UserLoginHome userloginhome=new UserLoginHome(driver);
			userloginhome.getDetailsBtn().click();
			List<WebElement> allPhones = driver.findElements(By.xpath("//p[contains(.,'"+alternat_mobile+"')]"));
			String abcd=null;
			   
			for(WebElement phone:allPhones) {
				String phoneNo =phone.getText();
				if(phoneNo.contains(alternat_mobile))
					{abcd=alternat_mobile;
					break;}
			}
				Assert.assertTrue(abcd.contains(alternat_mobile), "pass");
		}
}    
