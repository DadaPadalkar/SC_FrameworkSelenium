package com.MystoreV3.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
WebDriver ldriver;
	
	public OrderSummaryPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);// driver which we pass at the time of TC execution.
	}
	//quantity selection webelement...
	@FindBy(linkText="Proceed to checkout")
	WebElement proceedtocheckout;
	
	public void clickOnProceedtoCheckOut()
	{
		proceedtocheckout.click();
		
	}
}
