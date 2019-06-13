package com.syntax.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath="//li[text()='Dashboard']")
	public WebElement dashboardText;
	
	
	
	@FindBy(xpath="//span[text()='PIM']")
	public WebElement pim;
	
	@FindBy(xpath="//span[text()='Add Employee']")
	public WebElement addEmployee;
	
	
	@FindBy(xpath="//span[text()='Employee List']")
	public WebElement empList;
	
	@FindBy(xpath="//div[@class='angucomplete-holder']/input")
	public WebElement empName;
	
	@FindBy(xpath="//*[@id=\"employee_name_quick_filter_employee_list_dropdown\"]/div[3]")
	public WebElement empListDD;
	
	@FindBy(css="#employee_name_quick_filter_employee_list_value")
    public WebElement empSearchBox;
	
	
    //@FindBy(xpath="//a[@ng-click='navbar.search()']")
   // public WebElement empSearchBtn;
	
	   @FindBy(xpath="//*[@id='quick_search_icon']")
	   public WebElement empSearchBtn;
  
	
	@FindBy(xpath="//i[text()='ohrm_filter']")
	public WebElement filterBtn;
	
	@FindBy(xpath="//a[text()='Reset']")
	public WebElement resetBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
