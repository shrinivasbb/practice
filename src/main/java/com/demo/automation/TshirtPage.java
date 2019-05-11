package com.demo.automation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TshirtPage extends StartupPage{
	
	@FindBy(css="img[title*='shirts']")
	@CacheLookup
	public WebElement tshirtImage;
	
	@FindBy(css="a[title='Add to cart']")
	@CacheLookup
	public WebElement addToCartLink;
	
	@FindBy(css="a[title='Proceed to checkout']")
	@CacheLookup
	public WebElement checkoutLink;
	
	@FindBy(id="layer_cart_product_title")
	@CacheLookup
	public WebElement shirtLabel;
	
	@FindBy(id="layer_cart_product_attributes")
	@CacheLookup
	public WebElement colorLabel;
	
	@FindBy(id="layer_cart_product_quantity")
	@CacheLookup
	public WebElement quantityLabel;
	
	@FindBy(id="layer_cart_product_price")
	@CacheLookup
	public WebElement priceLabel;
	
	public TshirtPage(WebDriver driver) {
		super(driver);
	}

    public TshirtPage hoverOnImage() {
    	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", tshirtImage);
    	new Actions(driver).moveToElement(tshirtImage).build().perform();
    	return PageFactory.initElements(driver, TshirtPage.class);
    }
    
    public TshirtPage clickOnAddToCart() {
    	addToCartLink.click();
    	new WebDriverWait(driver, 30).until(driver->checkoutLink.isDisplayed()==true);
    	return PageFactory.initElements(driver, TshirtPage.class);
    }
}
