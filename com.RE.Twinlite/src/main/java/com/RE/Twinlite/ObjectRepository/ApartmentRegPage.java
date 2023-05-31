package com.RE.Twinlite.ObjectRepository;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class ApartmentRegPage {

	//declaration 
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='apartment_name']")private WebElement apartname;
			@FindBy(xpath="(//input[@id='fullname'])[2]")private WebElement fullname;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='mobile']")private WebElement mobile;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='alternat_mobile']")private WebElement alternat_mobile;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='email']")private WebElement email;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='plot_number']")private WebElement plotNo;
			@FindBy(xpath="(//input[@name='rooms'])")private WebElement rooms;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='country']")private WebElement country;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='state']")private WebElement state;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='city']")private WebElement city;
			@FindBy(xpath="//input[@name='rent[]']")private WebElement rent;
			@FindBy(xpath="//input[@name='deposit[]']")private WebElement deposit;
			@FindBy(xpath="//input[@name='accommodation[]']")private WebElement accommodation;
			@FindBy(xpath="//input[@name='description[]']")private WebElement description;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='landmark']")private WebElement landmark;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='address']")private WebElement address;
			@FindBy(xpath="//select[@class='form-control']")private WebElement vacantOrOccupied;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='image']")private WebElement UploadImg;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//button[.='Submit']")private WebElement submitApartReg;
			@FindBy(xpath="//a[.='Add More(Plat Number/Description)']")private WebElement moreFlatsBtn;
			
			@FindBy(xpath="//input[@name='ap_number_of_plats[]']")private WebElement noOfFlats;
			@FindBy(xpath="//input[@name='rooms[]']")private WebElement noOfRooms;
			@FindBy(xpath="//input[@name='area[]']")private WebElement area;
			
			@FindBy(xpath="//a[.='Individual Home Registration']")private WebElement RegRoomsBtn;
			@FindBy(xpath="(//div[.='Registration successfull. Thank you'])[1]")private WebElement successText;
			
			//initialization using constructors
			public ApartmentRegPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			

			public WebElement getMoreFlatsBtn() {
				return moreFlatsBtn;
			}



			public WebElement getApartname() {
				return apartname;
			}


			public WebElement getNoOfFlats() {
				return noOfFlats;
			}

			public WebElement getNoOfRooms() {
				return noOfRooms;
			}

			public WebElement getArea() {
				return area;
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

			public WebElement getSubmitApartReg() {
				return submitApartReg;
			}

			public WebElement getRegRoomsBtn() {
				return RegRoomsBtn;
			}
			
			public void registerApartmentInToApp(WebDriver driver,String apartName, String mobile, String alternat_mobile, String email , String plotNo,String country,String state,String city,
					String landmark , String address, String  fullname,String NoOfFlats, String NoOfrooms,String area , String rent,String deposit,
					String accommodation, String description) throws InterruptedException
			{
				getApartname().sendKeys(apartName);
				Thread.sleep(1000);
				getMobile().sendKeys(mobile);
				getAlternat_mobile().sendKeys(alternat_mobile);
				getEmail().sendKeys(email);
				getPlotNo().sendKeys(plotNo);
				getCountry().sendKeys(country);
				getState().sendKeys(state);
				getCity().sendKeys(city);
				getLandmark().sendKeys(landmark);
				getAddress().sendKeys(address);
		
		//uploading image
				File f=new File("./src/test/resources/Screenshot (38).png");
				String abspath = f.getAbsolutePath();
				getUploadImg().sendKeys(abspath);
				Thread.sleep(1000);
				getMoreFlatsBtn().click();
				
				
				
				getFullname().sendKeys(fullname);
				getNoOfFlats().sendKeys(NoOfFlats);
				getNoOfRooms().sendKeys(NoOfrooms);
				getArea().sendKeys(area);
				getRent().sendKeys(rent);
				getDeposit().sendKeys(deposit);
				getAccommodation().sendKeys(accommodation);
				getDescription().sendKeys(description);

				WebElement options2 = driver.findElement(By.xpath("//select[@id='vacant']"));
				Select s1=new Select(options2);
				s1.selectByValue("1");
				driver.findElement(By.xpath("//h2[.='Apartment Room']/../form//button[.='Submit']")).click();
				
				
				String successText = getSuccessText().getText();
				Assert.assertTrue(successText.contains("successfull"),"apartment not created successfully");
				Reporter.log("property registered successfully",true);
		/*if(successText.contains("successfull"))
			System.out.println("Apartment registered successfully");
		else
			System.out.println("Apartment registration failed");*/
			}
			
		
}
