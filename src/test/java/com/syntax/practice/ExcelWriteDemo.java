package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.syntax.utils.Constants;

public class ExcelWriteDemo {
	
	@Test
	public void writeExcel() throws Exception {
	String xlPath=Constants.XL_ORANGE_HRM_DATA_FILEPATH;
	
	FileInputStream fis=new FileInputStream(xlPath);
	//open WorkBook
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheet=wb.getSheet("EmployeeDetails");
	//write values
//	sheet.getRow(0).createCell(4).setCellValue("Result");
//	sheet.getRow(1).createCell(4).setCellValue("pass");
//	sheet.getRow(1).getCell(4).setCellValue("Fail");
//	sheet.createRow(11).createCell(0).setCellValue("Mehmet");
	
	//write to Excel
	
	FileOutputStream fos=new FileOutputStream(xlPath);
	wb.write(fos);
	
	//close file and opened streams
	fos.close();
	wb.close();
	fis.close();

}

}