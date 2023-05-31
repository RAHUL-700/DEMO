package com.twinliteRegisterRoomsAndUsers;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SampleExcel {

	public static void main(String[] args) throws IOException {

//		 DataBaseUtility dLib = new DataBaseUtility();
//		 FileUtilities fLib = new FileUtilities();
//		 ExcelUtilities eus = new ExcelUtilities();
//		 WebDriverUtilities wLib = new WebDriverUtilities();
//		  WebDriver driver;
//		
//		 JavaUtilities jus=new JavaUtilities();
		FileInputStream fis=new FileInputStream("C:\\Users\\satya\\OneDrive\\Desktop\\selenium programs\\com.RE.Twinlite\\src\\test\\resources\\hihihello.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("sheet1");
		String data = sh.getRow(0).getCell(0).getStringCellValue();
		System.out.println(data);
		 
		 
	/*	int ranNo=jus.getRandomNumber();
		String usn=fLib.getPropertyKeyValue("username");
		String pwd=fLib.getPropertyKeyValue("password");
		String fullname =eus.getExcelData("LoginAdmin", 1, 1);
		String username1 =eus.getExcelData("LoginAdmin", 2, 1);
		String mobile =eus.getExcelData("LoginAdmin", 3, 1)+ranNo;
        String email =	ranNo+eus.getExcelData("LoginAdmin", 4, 1);	
        String password1 =eus.getExcelData("LoginAdmin", 5, 1);		
        String c_password =	eus.getExcelData("LoginAdmin", 6, 1);
        
        System.out.println(usn+" "+pwd+" "+fullname+" "+username1+" "+mobile);
        */
        
	}

}
