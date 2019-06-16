package com.syntax.practice;


import org.testng.annotations.Test;

import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class ExcelFunctionsTest {
	
	@Test
	public void excelTest() {
		
		ExcelUtility obj=new ExcelUtility();
		obj.openExcel(Constants.XL_ORANGE_HRM_DATA_FILEPATH, "EmployeeDetails");
		String value = obj.getCellData(2, 3);
		System.out.println(value);
	
		
		
		//retrieve all values from XL and store 2D Object array
		
		int row=obj.getRowNum();
		int cell=obj.getColNum(0);
		Object [][] data=new Object [row][cell];//number of row with number of cells on the row
		for (int i=0; i<row; i++) {
			for (int y=0; y<cell; y++) {
				data[i][y]=obj.getCellData(i, y);
			}
		}
		System.out.println(data.length);
	}		
}
