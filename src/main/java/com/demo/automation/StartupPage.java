package com.demo.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartupPage {

	public WebDriver driver;
	
	@FindBy(css="a.login")
	@CacheLookup
	public WebElement signInLink;

	
	public StartupPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public StartupPage navigateToLogin(String url) {
		driver.get(url);
		return PageFactory.initElements(driver, StartupPage.class);
	}
	
	public LoginPage clickSignInButton() {
		signInLink.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}

	public void quitDriver() {
		driver.quit();
	}
}
