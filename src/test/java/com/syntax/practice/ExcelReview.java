package com.syntax.practice;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.syntax.utils.Constants;

public class ExcelReview {
	@Test
	public void readExcel() throws Exception {
	String xlPath=Constants.XL_ORANGE_HRM_DATA_FILEPATH;
	
	FileInputStream fis=new FileInputStream(xlPath);
	//open WorkBook
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	//open specified sheet
	XSSFSheet sheet=workbook.getSheet("EmployeeDetails");
	//access value of specific cell
	String value=sheet.getRow(6).getCell(0).toString();
	System.out.println(value);
	//close workbook and stream
	
	int rowNum=sheet.getPhysicalNumberOfRows();
	int colNum=sheet.getRow(0).getLastCellNum();
	
	System.out.println("Number of rows and columns are "+ rowNum+" and "+colNum);
	
	//get value from each cell 1 by 1
	
	for (int i=1; i<rowNum; i++) {
		for (int j=0; j<colNum; j++) {
			
			String cellValue=sheet.getRow(i).getCell(j).toString();
			System.out.println(cellValue);
			
	}
	}
	workbook.close();
	fis.close();
	
	
	
}
}
