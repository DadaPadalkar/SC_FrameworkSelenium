	package com.MystoreV3.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registeredUserAccount 
{
	WebDriver ldriver;
	//constructor for initialization of web element
	public registeredUserAccount(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(xpath="//a[@title=\"View my customer account\"]")
	WebElement UserName;
	
	@FindBy(linkText="Sign out")
	WebElement SignOutBtn;
	//search box  element
	@FindBy(id="search_query_top")
	WebElement SearchBox;
	@FindBy(name="submit_search")
	WebElement Submitsearch;
	public String getUserName()
	{
		String text=UserName.getText();
		return text;
	}
	
	public void clickOnSignOutBtn()
	{
		SignOutBtn.click();
	}
	
	public void EnterDataInSearchBox(String searchKey)
	{
		SearchBox.sendKeys(searchKey);
	}
	public void clickOnSearch()
	{
		Submitsearch.click();
		
	}
}
