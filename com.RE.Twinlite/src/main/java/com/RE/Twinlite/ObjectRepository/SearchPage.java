package com.RE.Twinlite.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author satya
 *
 */
public class SearchPage {

	

	@FindBy(id="keywords")private WebElement keywordTxtBx;
	@FindBy(id="location")private WebElement locationTxtBx;
	@FindBy(name="search")private WebElement Search2Btn;
	@FindBy(xpath="//p[contains(.,'Mobile Number:')]")private List<WebElement> ownerList;
	
	//initialization using constructors
			public SearchPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			
	public List<WebElement> getOwnerList() {
				return ownerList;
			}


	public WebElement getKeywordTxtBx() {
		return keywordTxtBx;
	}

	public WebElement getLocationTxtBx() {
		return locationTxtBx;
	}

	public WebElement getSearch2Btn() {
		return Search2Btn;
	}
	
	public void searchTheProperty(String SearchKey, String searchCity) throws InterruptedException {
		getKeywordTxtBx().sendKeys(SearchKey);
		getLocationTxtBx().sendKeys(searchCity);
		Thread.sleep(1000);
		getSearch2Btn().click();	
	}
}
