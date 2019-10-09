package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hotspot.commons.Constants;
import com.qa.hubspaot.basepage.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.CommonUtil;

public class HomePageTest {
	
	
	BasePage basepage;
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	HomePage homepage;
	
	@BeforeMethod
	public void setUp() {
		basepage = new BasePage();
		prop=basepage.initialize_properties();
		driver = basepage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		CommonUtil.mediumWait();
		loginPage = new LoginPage(driver);
		homepage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		CommonUtil.mediumWait();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homepage.getHomePageTitle();
		System.out.println("HomePage Title "+ title);
		Assert.assertEquals(title, Constants.HOMEPAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyHomePageHeaderTest() {
		String header = homepage.getHomePageHeaderValue();
		System.out.println("HomePage Header "+ header);
		Assert.assertEquals(header, Constants.HOMEPAGE_HEADER);
	}
	
	@Test(priority=3)
	public void verifyLoggedInAccountNameTest() {
		String accountName = homepage.getLoggedInAccountName();
		System.out.println("Logged in Account Name is "+ accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
