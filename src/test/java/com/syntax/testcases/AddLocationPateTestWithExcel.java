package com.syntax.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.AddLocationPage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;
import com.syntax.utils.Constants;

public class AddLocationPateTestWithExcel extends BaseClass {

	@Test(dataProvider = "Country details")
	public void addEmployee(String nameOffice, String country, String city, String zip) throws InterruptedException {

		LoginPage login = new LoginPage();
		HomePage home = new HomePage();
		AddLocationPage addLoc = new AddLocationPage();
		// login to the OrangeHRM
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

		CommonMethods.waitForElementBeClickable(home.admin, 20);
		CommonMethods.click(home.admin);
		CommonMethods.click(home.organization);
		CommonMethods.click(home.locations);
		CommonMethods.click(home.addLocation);
		
		CommonMethods.sendText(addLoc.name, nameOffice);
		CommonMethods.click(addLoc.country);
		CommonMethods.waitForElementBeClickable(addLoc.countryDD, 20);
		CommonMethods.selectList(addLoc.countryDD, country);

		CommonMethods.sendText(addLoc.city, city);
		CommonMethods.sendText(addLoc.zipcode, zip);
		CommonMethods.click(addLoc.savebutton);

	
				
		Assert.assertTrue(CommonMethods.compareListValueReturnBoolean(addLoc.addedLocationList, country));
		System.out.println("Added Locations are verified");
	}

	@DataProvider(name = "Country details")
	public Object[][] addLocationData() {

		FileInputStream fis = null;
		
		XSSFWorkbook workbook = null;

		try {
			fis = new FileInputStream(Constants.XL_ADD_LOCATION_FILEPATH);
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet("AddLocations");
		int rowNum = sheet.getPhysicalNumberOfRows();
		int colNum = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowNum - 1][colNum];
		for (int i = 1; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				XSSFCell cell = sheet.getRow(i).getCell(j);
				if (cell != null) {
					data[i - 1][j] = cell.toString();
				} else {
					data[i - 1][j] = "";
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
