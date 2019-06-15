package com.syntax.testcases;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.AddLocationPage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class AddLocationPageTest extends BaseClass {
	
	

	@Test(dataProvider="Country details")
	public void addEmployee(String nameOffice , String country,String city, String zip) throws InterruptedException {

		LoginPage login = new LoginPage();
		HomePage home=new HomePage();
		AddLocationPage addLoc=new AddLocationPage();
		//login to the OrangeHRM
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
		
		
		
		
		CommonMethods.tableCompareCellValueToExpected(driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr")), nameOffice);;
        
        
            
            }
        
		
//	CommonMethods.waitForElementBeVisible(addLoc.AddedLocationNameList.get(0), 20);
//		boolean isLocationAdded=false;
//		for (WebElement we :addLoc.AddedLocationNameList) {
//			String locname=we.getAttribute("value");
//			if(locname.equals(country)) {
//				isLocationAdded=true;
//				break;
//			}Assert.assertTrue(isLocationAdded);
//			
//		}
		
			
		
		
	
	
		@DataProvider(name = "Country details")
		public Object[][] getData() {
			
			Object[][] data=new Object[3][4];
			//1 set
			data[0][0]="HH Office";
			data[0][1]="Russia";
			data[0][2]="Tula";
			data[0][3]="22558";
			//2 set
			data[1][0]="EE Office";
			data[1][1]="Spain";
			data[1][2]="Madrid";
			data[1][3]="78453";
			//3 set
			data[2][0]="GG Office";
			data[2][1]="Israel";
			data[2][2]="Telaviv";
			data[2][3]="12345";
			return data;
		}
	}
		
		
