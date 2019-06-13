package com.syntax.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class AddEmployeePageTest extends BaseClass {

	String expected = " Lyonya Harris";

	@Test(priority = 1)
	public void addEmployee() throws InterruptedException {
		LoginPage lg = new LoginPage();
		HomePage hm = new HomePage();
		AddEmployeePage addEmp = new AddEmployeePage();

		lg.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

		CommonMethods.click(hm.pim);
		CommonMethods.click(hm.addEmployee);

		CommonMethods.sendText(addEmp.firstname, "Lyonya ");
		CommonMethods.sendText(addEmp.lastname, "Harris");
		CommonMethods.sendText(addEmp.employeeId, "100");
		CommonMethods.click(addEmp.location);

		// 1 identify list
		// 2 get all children with li tags
		// loop through each li tag and get text
		// if text is matching then we click
		// break

		List<WebElement> listLocations = addEmp.locationList.findElements(By.tagName("li"));

		for (WebElement li : listLocations) {
			String liText = li.getText();
			System.out.println("Name of the offices "+liText);

			if (liText.contains("Main Office")) {
				li.click();
				break;
			}
		}
		Thread.sleep(2000);
		CommonMethods.click(addEmp.saveBtn);
		Thread.sleep(2000);
		CommonMethods.click(addEmp.save);

		Thread.sleep(2000);
		CommonMethods.click(hm.empList);
		CommonMethods.click(hm.empName);
		CommonMethods.sendText(hm.empName, "100");
		
		
		
		
		
		
		
	CommonMethods.click(hm.filterBtn);
	CommonMethods.click(hm.resetBtn);
		
		List<WebElement> empList=driver.findElements(By.xpath("//span[@class='angucomplete-title']"));
		for (WebElement empName : empList) {
		String names=empName.getText();
		System.out.println(names);
			CommonMethods.waitForElementBeVisible(empName, 20);
			if (names.contains(expected)) {		
			
			empName.click();				
				
			}
			}

	List<WebElement> rows = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr"));
	for (WebElement cell : rows) {
		String actual = cell.getText();
		System.out.println(actual);
		if (actual.contains(expected)) {
		cell.click();

			Assert.assertTrue(cell.isDisplayed(), "Added employee is not displayed");
		System.out.println("Added employee name is verified");

			break;

			}
		}

	}
}
//		CommonMethods.click(hm.filterBtn);
//		CommonMethods.click(hm.resetBtn);
//		
//		
//		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr"));
//		for(WebElement cell: rows) {
//		String actual=cell.getText();
//		if(actual.equals("Rosa James")) {
//		
//		Assert.assertEquals(actual, "Rosa James");
//		
//		System.out.println("Added employee name is verified");
//		
//		break;
//		}
//		}
//		
