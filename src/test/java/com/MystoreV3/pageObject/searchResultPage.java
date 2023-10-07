package com.MystoreV3.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchResultPage 
{
WebDriver ldriver;
	
	public searchResultPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//to identify element present on search page
	@FindBy(linkText="Faded Short Sleeve T-shirts")
	WebElement searchresult;
	@FindBy(linkText="Sign out")
	WebElement SignOuntbtn;
	//to find element more button on search page
	@FindBy(linkText="More")
	WebElement Morebutton;
	//
	public String getSearchResultText()
	{
		return (searchresult.getText());
	}
	public void clickOnsignOutbtn()
	{
		SignOuntbtn.click();
	}
	public void clickOnMoreButton()
	{
		Morebutton.click();
	}
}
