package com.MystoreV3.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage 
{
	WebDriver ldriver;
	public OrderConfirmationPage (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")
	WebElement confirmOrder;
	
	@FindBy(linkText="Sign out")
	WebElement signout;

	//alertmessage
	@FindBy(xpath="//div[@id='center_column']/p[@class='alert alert-success']")
	WebElement successAlert;
	
	
	public void clickOnconfirmOrder()
	{
		confirmOrder.click();
	}
	public void clickOnSignOut()
	{
		signout.click();
	}
	public String getOrderSuccessMessage()
	{
		return(successAlert.getText());
		
	}
	
}
