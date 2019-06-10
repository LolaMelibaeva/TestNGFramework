package com.syntax.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass {

	@Test(enabled=false)
	public void loginToOrangeHRM() {

		LoginPageWithoutPageFactory login = new LoginPageWithoutPageFactory();

		CommonMethods.sendText(login.username, "Admin");
		CommonMethods.sendText(login.password, "xV9D@Q2Hbv");
		CommonMethods.click(login.btnLogin);

	}

	@Test(enabled=false)

	public void doLogin() {
		LoginPage login = new LoginPage();

		CommonMethods.sendText(login.username, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);

		HomePage home = new HomePage();
		boolean isDisplayed = home.dashboardText.isDisplayed();

		Assert.assertTrue(isDisplayed);
		System.out.println(home.dashboardText +" is displayed");

	}
	
	@Test()
	public void negativeLogin() {
		

		LoginPage login=new LoginPage();
		
		login.login("admin", "test");
		String errorText=login.loginError.getText();
		String expected="Invalid Credentials";
		Assert.assertEquals(errorText, expected);
		
	}
	
	
	
}
