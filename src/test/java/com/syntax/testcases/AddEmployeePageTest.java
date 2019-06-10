package com.syntax.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class AddEmployeePageTest extends BaseClass{
	
	
	@Test
	public void addEmployee() throws InterruptedException {
		LoginPage lg=new LoginPage();
		HomePage hm=new HomePage();
		AddEmployeePage addEmp=new AddEmployeePage();
		
		lg.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		
		
		CommonMethods.click(hm.pim);
		CommonMethods.click(hm.addEmployee);
		
		CommonMethods.sendText(addEmp.firstname, "John");
		CommonMethods.sendText(addEmp.lastname, "Smith");
        CommonMethods.click(addEmp.location);
		
		//1 identify list
		//2 get all children with li tags
		//loop through each li tag and get text
		//if text is matching then we click
		//break
		
		List<WebElement> listLocations = addEmp.locationList.findElements(By.tagName("li"));
		
		for (WebElement li : listLocations) {
			String liText=li.getText().trim();
			
			if (liText.equals("HQ")) {
				li.click();
				break;
			}
		}
		Thread.sleep(9000);
	}
}
		
		