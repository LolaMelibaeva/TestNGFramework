package com.syntax.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class AddEmployeePageTest4 extends BaseClass { 



	@Test(dataProvider="Employee details")
	public void addEmployee(String fName, String mName,String lName, String location) throws InterruptedException {

		LoginPage login = new LoginPage();
		HomePage home =new HomePage();
		AddEmployeePage addEmp=new AddEmployeePage();
		//login to the OrangeHRM
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		//navigate to add Employee
		CommonMethods.waitForElementBeClickable(home.PIM, 20);
		CommonMethods.click(home.PIM);
		
		CommonMethods.click(home.addEmployee);
		//enter employee details
		CommonMethods.sendText(addEmp.firstName, fName);
		CommonMethods.sendText(addEmp.middleName, mName);
		CommonMethods.sendText(addEmp.lastName, lName);
		CommonMethods.click(addEmp.location);
		CommonMethods.selectList(addEmp.locationList, location);
		CommonMethods.click(addEmp.saveBtn);
		//verify employee is added
		CommonMethods.waitForElementBeClickable(addEmp.empCheck, 20);
		String verifText=addEmp.empCheck.getText();
		System.out.println(verifText);
		Assert.assertEquals(verifText, fName+" "+lName);
	}
	
	 @DataProvider(name="Employee details")
	 public Object[][] addLocationData (){
	        
		 FileInputStream fis=null;;
	        XSSFWorkbook workbook=null;
	        
	        try {
	            fis = new FileInputStream("src\\test\\resources\\testdata\\OrangeHrmData.xlsx");
	            workbook = new XSSFWorkbook(fis);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        XSSFSheet sheet = workbook.getSheet("EmployeeDetails");
	        int rowNum = sheet.getPhysicalNumberOfRows();
	        int colNum = sheet.getRow(0).getLastCellNum();
	        Object[][] data = new Object[rowNum-1][colNum];
	        for(int i=1; i< rowNum; i++){
	            for(int j=0; j<colNum; j++){
	                XSSFCell cell = sheet.getRow(i).getCell(j);
	                if(cell!=null) {
	                    data[i-1][j]=cell.toString();
	                }else {
	                    data[i-1][j]="";
	                }
	            }
	        }
	        try {
	            workbook.close();
	            fis.close();
	        } catch (IOException e) {
	            
	            e.printStackTrace();
	        }
	        return data;
	    }
}