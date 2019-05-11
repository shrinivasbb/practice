package com.demo.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends StartupPage {
	
	@FindBy(id="email")
	@CacheLookup
	public WebElement userNameTextBox;
	
	@FindBy(id="passwd")
	@CacheLookup
	public WebElement passwordTextBox;
	
	@FindBy(name="SubmitLogin")
	@CacheLookup
	public WebElement signInButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public HomePage loginWithUserNameAndPassword(String username, String password) {
		userNameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		signInButton.click();
		return PageFactory.initElements(driver, HomePage.class);
	}

}
