package com.demo.automation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends StartupPage {
	
	
	@FindBy(css="li a[title='T-shirts']")
	@CacheLookup
	public WebElement tShirtsLink;
	
	

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public TshirtPage clickOnTshirts() {
		((JavascriptExecutor)driver).executeScript("arguments[0].focus();",tShirtsLink);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",tShirtsLink);
		return PageFactory.initElements(driver, TshirtPage.class);
	}
	
	
}
