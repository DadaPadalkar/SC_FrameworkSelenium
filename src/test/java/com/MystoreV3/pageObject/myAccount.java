package com.MystoreV3.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class myAccount
{
//1.Create webdriver object
	WebDriver ldriver;
	
	public myAccount(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//locating webelement
	@FindBy(id="email_create")
	WebElement createEmailid;
	@FindBy(id="SubmitCreate")
	WebElement SubmitCreate;
	//locating webelement from already registered user section on my acc page
	@FindBy(id="email")
	WebElement RegisteredUserName;
	@FindBy(id="passwd")
	WebElement password;     
	@FindBy(id="SubmitLogin")
	WebElement Submitlogin;
	//for entering username in registered sect
	public void enterRegUserName(String UserName)
	{
		RegisteredUserName.sendKeys(UserName);
	}
	public void enterRegPassword(String Password)
	{
		password.sendKeys(Password);
	}
	public void clickOnSubmitloginbtn()
	{
		Submitlogin.click();;
	}
	//adding methods for performing actions on webelement
	
	public void enterCreateemailAddress(String emailAdd)
	{
		createEmailid.sendKeys(emailAdd);
	}
	public void submitCreate()
	{
		SubmitCreate.click();
	}
	
	
	
	
	
}
