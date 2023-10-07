package com.MystoreV3.Testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MystoreV3.pageObject.IndexPage;
import com.MystoreV3.pageObject.accountCreationDetails;
import com.MystoreV3.pageObject.myAccount;
import com.MystoreV3.pageObject.registeredUserAccount;

public class TC_myAccountPageTest extends Base
{
	@Test(enabled=false)
public void verifyRegistrationAndLogin()
{
	IndexPage pg=new IndexPage(driver);
	pg.clickOnSignIn();
	logger.info("Clicked on sign in button");
	myAccount MyAcpg= new myAccount(driver);
	MyAcpg.enterCreateemailAddress("dadapadalkar98@gmail.com");
	logger.info("Emailid Entered");
	MyAcpg.submitCreate();
	logger.info("submit create button clicked");
	//accountcreationpage 
	accountCreationDetails ac=new accountCreationDetails (driver);
	ac.TitleSelectMr();
	ac.EnterCustomerFirstName("Dada");
	ac.EnterCustomerLasstName("Padalkar");
	ac.Enterpassword("ABCDE");
	logger.info("All Info Enterred");
	ac.clickOnRegister();
	logger.info("User Registerred Successfully");
	//registeruserpage
	registeredUserAccount ru= new registeredUserAccount(driver);
	String username=ru.getUserName();
	//for verification assert class
	Assert.assertEquals("Dada Padalkar",username);
	
}
	@Test(enabled=true)
	public void verifyLogin() throws IOException
	{
		logger.info("Verify login Test Execution Started...");
		IndexPage ipg=new IndexPage(driver);
		ipg.clickOnSignIn();
		logger.info("Clicked on sign in link");
		myAccount MyAcpg= new myAccount(driver);
		MyAcpg.enterRegUserName(emailAddress);
		MyAcpg.enterRegPassword(password);
		MyAcpg.clickOnSubmitloginbtn();
		logger.info("Clicked on Submit Login Button");
		registeredUserAccount rua=new registeredUserAccount(driver);
		String userName=rua.getUserName();
		//Assert.assertEquals("Dada Padalkar",userName );
		if(userName.equals("Dada Padalkar"))
		{
			logger.info("Verify Login-Pass");
			rua.clickOnSignOutBtn();
			Assert.assertTrue(true);
			
		}
		else
		{
			logger.info("Verify Login-Failed");
			captureScreenShot(driver,"Verify Login");
			Assert.assertTrue(false);
		}
	}
	
	@Test(enabled=false)
	public void verifySignOut() throws Exception
	{
		logger.info("Verify Sign Out Test Execution Started...");
		IndexPage ipg=new IndexPage(driver);
		ipg.clickOnSignIn();
		logger.info("Clicked on sign in link");
		System.out.println(ipg.getPageTitle());
		myAccount MyAcpg= new myAccount(driver);
		MyAcpg.enterRegUserName(emailAddress);
		MyAcpg.enterRegPassword(password);
		MyAcpg.clickOnSubmitloginbtn();
		logger.info("Clicked on Submit Login Button");
		
		registeredUserAccount ra=new registeredUserAccount(driver);
		ra.clickOnSignOutBtn();
		logger.info("Clicked on Sign out link");
		
		
		//page title checking
		if (ipg.getPageTitle().equals("Login-My Store"))
		{
			logger.info("Verify Sign Out Test passed..");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Verify Sign Out Test failed..");
			captureScreenShot(driver,"Verify SignOut");
			Assert.assertTrue(false);
		}
		logger.info("Test Case Verification ends....");
		
	}
}
