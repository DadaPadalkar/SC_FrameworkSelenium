package com.MystoreV3.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountCreationDetails 
{
	WebDriver ldriver;
	//constructor for initialization of web element
	public accountCreationDetails(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(id="id_gender1")
	WebElement GenderMr;
	
	@FindBy(id="id_gender2")
	WebElement GenderMrs;
	
	@FindBy(id="customer_firstname")
	WebElement CustomerFirstNameBox;
	
	@FindBy(id="customer_lastname")
	WebElement CustomerLastNameBox;
	
	@FindBy(id="passwd")
	WebElement Password;
	//for address
	@FindBy(id="submitAccount")
	WebElement RegisterButton;
	
	//Identify actions to be perform
	public void TitleSelectMr()
	{
		GenderMr.click();
	}
	public void TitleSelectMrs()
	{
		GenderMrs.click();
	}
	public void EnterCustomerFirstName(String Fname)
	{
		CustomerFirstNameBox.sendKeys(Fname);
	}
	public void EnterCustomerLasstName(String Lname)
	{
		CustomerLastNameBox.sendKeys(Lname);
	}
	public void Enterpassword(String Pass)
	{
		Password.sendKeys(Pass);
	}
	public void clickOnRegister()
	{
		RegisterButton.click();
	}

}
