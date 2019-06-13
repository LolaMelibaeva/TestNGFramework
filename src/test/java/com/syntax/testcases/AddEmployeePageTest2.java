package com.syntax.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class AddEmployeePageTest2 extends BaseClass {

	@Test(priority = 1)
	public void addEmployee() throws InterruptedException {
		LoginPage lg = new LoginPage();
		HomePage hm = new HomePage();
		AddEmployeePage addEmp = new AddEmployeePage();

		lg.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

		CommonMethods.click(hm.pim);
		CommonMethods.click(hm.addEmployee);

		CommonMethods.sendText(addEmp.firstname, "Alluchka");
		CommonMethods.sendText(addEmp.lastname, "Pugacheva");
		CommonMethods.sendText(addEmp.employeeId, "132");
		String expectedEmpID = addEmp.employeeId.getAttribute("value");
		System.out.println("Employee ID is " + expectedEmpID);
		CommonMethods.click(addEmp.location);

		// 1 identify list
		// 2 get all children with li tags
		// loop through each li tag and get text
		// if text is matching then we click
		// break

		List<WebElement> listLocations = addEmp.locationList.findElements(By.tagName("li"));

		for (WebElement li : listLocations) {
			String liText = li.getAttribute("innerHTML");
			System.out.println("Name of the offices " + liText);

			if (liText.contains("HQ")) {
				li.click();
				break;
			}
		}

		WebDriverWait wait = new WebDriverWait(driver, 0);

		CommonMethods.click(addEmp.saveBtn);
		Thread.sleep(2000);
		CommonMethods.click(addEmp.save);
		Thread.sleep(2000);
		CommonMethods.click(hm.empList);
		CommonMethods.click(hm.empName);

		CommonMethods.sendText(hm.empSearchBox, expectedEmpID);
		wait.until(ExpectedConditions.elementToBeClickable(hm.empSearchBtn));		
		CommonMethods.click(hm.empSearchBtn);
		Thread.sleep(4000);
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr"));
		
		boolean isEmpIDDisplayed=false;
		for (int i=1; i<=rows.size();i++) {
		String actual = driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+i+"]")).getText();
		
		if(actual.contains(expectedEmpID)) {
			isEmpIDDisplayed=true;
		}
		Assert.assertTrue(isEmpIDDisplayed);
			
			
		}
		Thread.sleep(5000);
	}

}
			
			//			System.out.println(actual);
//			if (actual.contains(expectedEmpID)) {
//				System.out.println("Employee is verified");
//
////				
//
//			}else {
//				System.out.println("Employee name verification is invalid");
//			}
		
//		
//driver.findElement(By.xpath("//*[@id='employee_name_quick_filter_employee_list_dropdown']/div[3]"));
//
//        
//
//        List<WebElement> list = hm.empListDD.findElements(By.xpath("//div[@class='angucomplete-row']"));
//        for (int i = 3; i < list.size(); i++) {
//
//            String text = driver
//                    .findElement(
//                            By.xpath("//*[@id='employee_name_quick_filter_employee_list_dropdown']/div[" + i + "]"))
//                    .getText();
//
//            if (text.contains(expectedEmpID)) {
//            	
//                CommonMethods.sendText(driver.findElement(
//                        By.xpath("//*[@id='employee_name_quick_filter_employee_list_dropdown']/div[" + i + "]")), expectedEmpID);
//                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='employee_name_quick_filter_employee_list_dropdown']/div[\" + i + \"]\"))"))));
//                
//                Thread.sleep(1000);
//                break;
//            }
//        }
//		
//		
//	
//	
//
// List<WebElement> rows = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr"));
//	for (WebElement cell : rows) {
//		String actual = cell.getText();
//		System.out.println(actual);
//		if (actual.contains(expectedEmpID)) {
//
//		Assert.assertTrue(cell.isDisplayed(), "Added employee is not displayed");
//	System.out.println("Added employee name is verified");
//
//		break;
//
//}
//
//	}
//}}

//		
//		List <WebElement> empList = hm.empListDD.findElements(By.xpath("//div[@class='angucomplete-row']"));
//      for (WebElement  list: empList) {
//       	String listText = list.getText();
//       	System.out.println("printing name of employees"+listText);
//            if (listText.contains(expectedEmpID)) {
//            
//            	CommonMethods.click(list);
//            	break;
//           	
//           }
