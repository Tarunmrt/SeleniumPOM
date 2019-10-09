package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspaot.basepage.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPageBy;
import com.qa.hubspot.util.CommonUtil;
import com.qa.hubspot.util.ExcelUtil;

public class ContactsPageTest {
	
	
	BasePage basepage;
	WebDriver driver;
	Properties prop;
	//LoginPage loginPage;
	LoginPageBy loginPageBy;
	HomePage homepage;
	ContactsPage contactsPage;
	
	@BeforeMethod
	public void setUp() {
		basepage = new BasePage();
		prop=basepage.initialize_properties();
		driver = basepage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		CommonUtil.mediumWait();
		loginPageBy = new LoginPageBy(driver);
		homepage = loginPageBy.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		CommonUtil.mediumWait();
		contactsPage=homepage.gotoContactsPage();
		
	}
	
	@DataProvider(name = "getContactsData")
	public Object[][] getContactsTestData() {
		Object contactsData[][] = ExcelUtil.getTestData("contacts");
		return contactsData;
		
	}
	
/*	@Test
	public void createContactsTest() {
		contactsPage.createNewContact("tarun@gmail.com", "tarun", "kumar", "PL");
	}*/	
		
	
   	@Test(dataProvider = "getContactsData")
	public void createContactsTest(String email, String firstName, String lastName, String jobTitle) {
		contactsPage.createNewContact(email, firstName, lastName, jobTitle);
	
	}	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	

}
