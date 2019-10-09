package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspaot.basepage.BasePage;

public class LoginPage extends BasePage {
	WebDriver driver;
	
	//1.a define page objects with the help of either page factory OR By locator
	//2. page actions/methods of the page
	
	@FindBy(id="username")
	WebElement emailId;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginButton;
	
	@FindBy(linkText="Sign up")
	WebElement signupLink;
	
	//1.b. create a constructor of page class and initialize all the page objects with driver
	
	public LoginPage(WebDriver driver){
		
		this.driver= driver;
		PageFactory.initElements(driver, this);		
		
	}
	
	//2. define actions/methods:
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifySignUpLink() {
		return signupLink.isDisplayed();
	}
	
	public HomePage doLogin(String un, String pwd) {
		emailId.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage(driver);
		
	}

}
