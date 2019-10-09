package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hotspot.commons.Constants;
import com.qa.hubspaot.basepage.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.LoginPageBy;
import com.qa.hubspot.util.CommonUtil;

public class LoginTest {
	
	BasePage basepage;
	WebDriver driver;
	Properties prop;
	//LoginPage loginPage;
	LoginPageBy loginPageBy;
	
	@BeforeMethod
	public void setUp() {
		basepage = new BasePage();
		prop=basepage.initialize_properties();
		driver = basepage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		CommonUtil.mediumWait();
		loginPageBy = new LoginPageBy(driver);
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title = loginPageBy.getLoginPageTitle();
		System.out.println("Login page title is " +  title);
		Assert.assertEquals(title, Constants.LOGINPAGE_TITLE);				
	}
	
	@Test(priority=2)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPageBy.verifySignUpLink(), "Signup Link is not visible");		
	}
	
	@Test(priority=3)
	public void loginTest() {
		loginPageBy.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
