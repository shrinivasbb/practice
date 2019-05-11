package com.demo.automation;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShopTest{
	
	WebDriver driver;
	StartupPage startupPage;
	HomePage homePage;
	LoginPage loginPage;
	TshirtPage tshirtPage;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator
				                                      +File.separator+"resources"+File.separator+"drivers"+File.separator+"chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		startupPage=new StartupPage(driver);
		loginPage=startupPage.navigateToLogin("http://automationpractice.com/")
				             .clickSignInButton();
	}
	
	@Test
	public void test1() {
		homePage=loginPage.loginWithUserNameAndPassword("jetblue@grr.la", "jetblue");
		tshirtPage=homePage.clickOnTshirts();
		tshirtPage.hoverOnImage().clickOnAddToCart();
		Assert.assertTrue(tshirtPage.shirtLabel.getText().trim().equals("Faded Short Sleeve T-shirts"));
		Assert.assertTrue(tshirtPage.colorLabel.getText().trim().equals("Orange, S"));
		Assert.assertTrue(tshirtPage.quantityLabel.getText().trim().equals("1"));
		Assert.assertTrue(tshirtPage.priceLabel.getText().trim().equals("$16.51"));
	}
	
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		startupPage.quitDriver();
	}
	
	

	
}