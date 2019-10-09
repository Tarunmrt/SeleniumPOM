package com.qa.hubspot.pages;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspaot.basepage.BasePage;
import com.qa.hubspot.util.ElementActions;

public class LoginPageBy extends BasePage {
	
	
	WebDriver driver;
	ElementActions elementActions;
	
	//1.a define page objects with the help of either page factory OR By locator
	//2. page actions/methods of the page
	
	By username = By.id("username");
	By password = By.id("password");
	By loginBtn = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	
	public LoginPageBy(WebDriver driver) {		
		this.driver = driver;	
		elementActions = new ElementActions(driver);
	}
	
	public String getLoginPageTitle() {
		return elementActions.getPageTitle();
	}
	
	public boolean verifySignUpLink() {
		return elementActions.getElement(signUpLink).isDisplayed();
	}
	
	public HomePage doLogin(String un, String pwd) {
		
		elementActions.sendKeysElement(username, un);
		elementActions.sendKeysElement(password, pwd);
		elementActions.CilckOnElement(loginBtn);
		
		return new HomePage(driver);
		
	}

	
	
	
	
	
	

}
