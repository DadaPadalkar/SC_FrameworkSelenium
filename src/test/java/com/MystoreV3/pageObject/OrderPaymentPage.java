package com.MystoreV3.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentPage 
{
	WebDriver ldriver;
	
	public OrderPaymentPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements( rdriver,this);
	}
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")
    WebElement payByCheque;
	
	@FindBy(name="bankwire")
	WebElement payByBankwire;
	
	public String getPageTitle()
	{
		return (ldriver.getCurrentUrl());
	}
	
	public void clickOnPayByCheque()
	{
		payByCheque.click();
		
	}
	public void clickOnPayByBankwire()
	{
		payByBankwire.click();
	}
	
	
}
