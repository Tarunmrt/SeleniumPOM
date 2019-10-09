package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.hubspaot.basepage.BasePage;
import com.qa.hubspot.util.ElementActions;

public class ContactsPageBy extends BasePage{
	WebDriver driver;
	ElementActions elementActions;
	
	
	
	By createContactBtn = By.xpath("//span[text()='Create contact']");
	By createContactSecondBtn = By.xpath("//li//span[text()='Create contact']");
	By email = By.id("uid-ctrl-1");
	By firstName = By.id("uid-ctrl-2");
	By lastName = By.id("uid-ctrl-3");
	By jobTitle = By.id("uid-ctrl-5");
	
	
	public ContactsPageBy(WebDriver driver) {		
		this.driver = driver;	
		elementActions = new ElementActions(driver);
	}
	
	
	public void createNewContact(String emailVal, String firstNameVal, String lastNameVal, String jobTitleVal) {
		elementActions.getElement(createContactBtn).click();
		
		elementActions.sendKeysElement(email, emailVal);
		elementActions.sendKeysElement(firstName, firstNameVal);
		elementActions.sendKeysElement(lastName, lastNameVal);
		elementActions.sendKeysElement(jobTitle, jobTitleVal);
		
		elementActions.getElement(createContactSecondBtn).click();
	}

}
