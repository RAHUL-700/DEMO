package com.Twinlite.genericUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptPractice {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("https://docs.phptravels.com/");
		
		JavaScriptUtility js=new JavaScriptUtility(driver);
		//launch application
		js.launchApplication("https://docs.phptravels.com/");
		
		//get url of the current page
		String url=js.urlOfCurrentPage();
		System.out.println(url);
		
		//get the title of the current page
		String title=js.titleOfCurrentPage();
		System.out.println(title);
		
		//scrolldown
		js.scrollDown();
		
		//scrollup
		js.scrollUp();
		
		//scrollTillElement //scrollbar1 (click on Response error link)
		/*WebElement element= driver.findElement(By.xpath("//div[@data-testid='page.desktopTableOfContents']//div[.='API Response Error' and @class='']"))
	     js.scrollTillElement(element);
		//click on element
		js.click(element);*/
		
		//scrollbar2 click on smily face
		/*WebElement element2=driver.findElement(By.xpath("//div[.='Was this page helpful?']//div[@class='css-175oi2r r-18u37iz r-1awozwy']//div[@ar]"))
	    js.scrollTillElement(element2);
		//click on element
		js.click(element2);*/
	}

}
