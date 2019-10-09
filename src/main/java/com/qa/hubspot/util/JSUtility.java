package com.qa.hubspot.util;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtility {
	WebDriver driver;
	
	public JSUtility(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void clickWebElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public void scrollDownByJS(WebDriver element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHieght)");
		
		
	}
	
	/*
	 * public static void flash(WebElement element, WebDriver driver) {
	 * JavascriptExecutor js = (JavascriptExecutor) driver; String bgcolor =
	 * element.getCssValue("backgroundColor"); for(int i=0; i<10;i++) {
	 * changeColor("rgb(0,200,0)",element, driver); changeColor(bgcolor,element,
	 * driver); } }
	 */
	
	 public void highlight(WebElement element, WebDriver driver){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		 }
	 
	 /*public void newTab(WebElement element, WebDriver driver) {
		 //JavascriptExecutor js = (JavascriptExecutor) driver;
		 ((JavascriptExecutor)driver).executeScript("window.open()");
		    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		    for(int i=0; i<tabs.size();i++) {
		    driver.switchTo().window(tabs.get(i));
		    driver.get("http://google.com");
		    }
	 }*/
	

}
