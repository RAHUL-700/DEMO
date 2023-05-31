package com.twinliteRegisterRoomsAndUsers;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

public class amazonEx {


		public static void main(String[] args) throws InterruptedException {

			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.amazon.in/");
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Samsung");
			driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
			Thread.sleep(2000);
			List<WebElement> allPhones = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
			List<WebElement> allPrices = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/../../../..//span[@class='a-price-whole']"));
			int size=allPhones.size();
			for(int i=0;i<size;i++) {
				
				String ph=allPhones.get(i).getText();
				String pr=allPrices.get(i).getText();
				
				System.out.println(ph+"====>"+pr);
			}
			

		}

	}

////span[@class='a-size-medium a-color-base a-text-normal']/../../following-sibling::/span[@class='a-price-whole']