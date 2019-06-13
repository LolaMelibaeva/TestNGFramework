package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class AddEmployeePage extends BaseClass {
	
	@FindBy(css="input#firstName")
	public WebElement firstname;
	
	@FindBy(css="input#middleName")
	public WebElement middlename;
	
	@FindBy(css="input#lastName")
	public WebElement lastname;	

    @FindBy(id="employeeId")
    public WebElement employeeId;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//input")
    public WebElement location;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//ul")
    public WebElement locationList;
    
    @FindBy(css="a#systemUserSaveBtn")
    public WebElement saveBtn;
    
    @FindBy(xpath="//button[@type='submit']")
    public WebElement save;
    
	
	public AddEmployeePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	

}
