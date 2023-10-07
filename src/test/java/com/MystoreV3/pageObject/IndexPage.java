package com.MystoreV3.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage 
{
	//1.Create object of webdriver.
	WebDriver ldriver; //local driver.
	
	//2.Create constructor for driver initialization
	public IndexPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
//locating web elements from index page using page factory model.
	@FindBy(linkText="Sign in")
	WebElement signIn;
	//identify action on webelement
	public void clickOnSignIn()
	{
		signIn.click();
	}
	
	public String getPageTitle()
	{
		return(ldriver.getTitle());
	}
}
