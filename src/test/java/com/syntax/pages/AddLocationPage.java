package com.syntax.pages;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class AddLocationPage extends BaseClass{
	

	
	@FindBy(css="input#name")
	public WebElement name;
	
	@FindBy(xpath="//div[@id='countryCode_inputfileddiv']//input")
	public WebElement country;
	
	@FindBy(xpath="//div[@id='countryCode_inputfileddiv']//ul")
	public WebElement countryDD;
	
	@FindBy(css="input#city")
	public WebElement city;
	
	
	@FindBy(xpath="//a[text()='Save']")
	public WebElement savebutton;
	
	@FindBy(css="input#zipCode")
	public WebElement zipcode;
	
	@FindBy(xpath="//table[@class='highlight bordered']/tbody/tr")
	public List<WebElement> addedLocationList;
	
	 
	
	public AddLocationPage() {
		PageFactory.initElements(driver, this);
	}

}
