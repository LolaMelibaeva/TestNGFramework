package com.syntax.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass {

	@Test(groups="smoke")
	public void loginToOrangeHRM() {
	//	test=report.createTest("Positive login");
		
		LoginPageWithoutPageFactory login = new LoginPageWithoutPageFactory();
		
		test.info("Logging in with valid credentials");
		
		CommonMethods.sendText(login.username, "Admin");
		CommonMethods.sendText(login.password, "xV9D@Q2Hbv");
		CommonMethods.click(login.btnLogin);
		
		test.info("Logging in with valid credentials");
		
		HomePage home = new HomePage();
		boolean isDisplayed = home.dashboardText.isDisplayed();

		Assert.assertTrue(isDisplayed);
		System.out.println(home.dashboardText +" is displayed");
		


	}

	@Test(groups="smoke")

	public void doLogin() {
		
	//	test=report.createTest("Login verification 2");
		LoginPage login = new LoginPage();

		CommonMethods.sendText(login.username, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);

		HomePage home = new HomePage();
		boolean isDisplayed = home.dashboardText.isDisplayed();

		Assert.assertTrue(false);
		System.out.println(home.dashboardText +" is displayed");

		//test.pass("Login verification passed");
	}
	
	@Test(groups="regression")
	public void negativeLogin() {
		

		LoginPage login=new LoginPage();
		test.info("Logging in with Invalid credentials");
		login.login("admin", "test");
		
		
		String errorText=login.loginError.getText();		
		String expected="Invalid Credentials";
		test.info("Verifying error message "+errorText);
		Assert.assertEquals(errorText, expected);
		
	}
	
	
	
}
