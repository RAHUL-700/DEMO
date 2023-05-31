package com.Twinlite.genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class methods to insert data and read data from excel files
 * @author satya
 *
 */
public class ExcelUtilities {

public String getExcelData(String sheetname,int rownum,int colnum) throws IOException {
		
		FileInputStream fis=new FileInputStream(IPATHConstants.excelfilepath);
		DataFormatter dtf=new DataFormatter();
		
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(colnum);
		String data=dtf.formatCellValue(cell);
		return data;
	}

/**
 * this method is used to insert the given data into the specific cell in the excel sheet
 * @param sheetname
 * @param rownum
 * @param colnum
 * @param text
 * @throws IOException
 */
public void insertExcelData(String sheetname,int rownum,int colnum,String text) throws IOException {
	
	FileInputStream fis=new FileInputStream(IPATHConstants.excelfilepath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet(sheetname);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(colnum);
	cell.setCellValue(text);
	FileOutputStream fos=new FileOutputStream(IPATHConstants.excelfilepath);
	wb.write(fos);
	wb.close();
}
/**
 * this method is used to get the last row numbwer of a given excel sheet
 * @param sheetname
 * @param rownum
 * @return
 * @throws IOException
 */
public int getRowNum(String sheetname,int rownum) throws IOException {
	
	FileInputStream fis=new FileInputStream(IPATHConstants.excelfilepath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet(sheetname);
	int row = sheet.getLastRowNum();
	return row;
}
public Object[][] data20(String sheetname) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis= new FileInputStream(IPATHConstants.excelfilepath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	int lastRow = sh.getLastRowNum()+1;
	int lastCol = sh.getRow(0).getLastCellNum();
	Object[][] obj=new Object[lastRow][lastCol];
	for(int i=0;i<lastRow;i++) {
		for(int j=0;j<lastCol;j++) {
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
}

}
