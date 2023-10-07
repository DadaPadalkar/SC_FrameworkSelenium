package com.MystoreV3.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage 
{
	WebDriver ldriver;
	
	public ProductPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);// driver which we pass at the time of TC execution.
	}
	//quantity selection webelement...
	@FindBy(id="quantity_wanted")
	WebElement qantityselect;
	//size select element...
	@FindBy(id="group_1")
	WebElement sizeselect;
	@FindBy(name="Submit")
	WebElement AddToCartbtn;
	@FindBy(linkText="Proceed to checkout")
	WebElement proceed;
	
	public void setQuantity(String qty)
	{
		qantityselect.clear();
		qantityselect.sendKeys(qty);
	}
	
	public void selectSize(String size)
	{
		//we use selectclass for dropdown
		Select s=new Select(sizeselect);
		s.selectByVisibleText(size);;
	}
	public void clickOnAddtoCart()
	{
		AddToCartbtn.click();
	}
	
	public void clickOnProceedToCheckOut()
	{
		proceed.click();	
	}

}
