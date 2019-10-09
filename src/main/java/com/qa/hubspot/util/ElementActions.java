package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hotspot.commons.Constants;
import com.qa.hubspaot.basepage.BasePage;

public class ElementActions extends BasePage{
	
	WebDriver driver;
	
	public ElementActions(WebDriver driver) {		
		this.driver = driver;		
	}
	
	public WebElement getElement(By selector) {		
		WebElement element = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_EXPLICITLY_WAIT);
		wait.until(ExpectedConditions.presenceOfElementLocated(selector));		
		element = driver.findElement(selector);		
		}
		catch(Exception e) {
			System.out.println("Element could not be created");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return element;		
	}
	
	public void sendKeysElement(By selector, String value) {
		try {
		getElement(selector).sendKeys(value);
		}
		catch(Exception e) {
			System.out.println("Some issue with sendKeys");
			
		}
	}
	
	public void CilckOnElement(By selector) {
		getElement(selector).click();
		
	}
	
	public String getTextElement(By selector) {
		return getElement(selector).getText();		
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	
	

}
