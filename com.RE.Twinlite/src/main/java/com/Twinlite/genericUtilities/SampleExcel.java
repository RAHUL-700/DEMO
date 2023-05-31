package com.Twinlite.genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SampleExcel {

	public static void main(String[] args) throws IOException {


		WebDriver driver=new EdgeDriver();
		driver.get("http://www.gmail.com");
        
	}

}
