package com.MystoreV3.Testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MystoreV3.Utilities.ReadExcelFile;
import com.MystoreV3.pageObject.IndexPage;
import com.MystoreV3.pageObject.accountCreationDetails;
import com.MystoreV3.pageObject.myAccount;
import com.MystoreV3.pageObject.registeredUserAccount;

public class TC_myAccountPageTestDataDrivenTesting extends Base
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
	@Test(dataProvider="LoginDataProvider")
	public void verifyLogin(String userEmail,String userpwd,String expectedUserName) throws IOException
	{
		logger.info("Verify login Test Execution Started...");
		IndexPage ipg=new IndexPage(driver);
		ipg.clickOnSignIn();
		logger.info("Clicked on sign in link");
		myAccount MyAcpg= new myAccount(driver);
		MyAcpg.enterRegUserName(userEmail);
		MyAcpg.enterRegPassword(userpwd);
		MyAcpg.clickOnSubmitloginbtn();
		logger.info("Clicked on Submit Login Button");
		registeredUserAccount rua=new registeredUserAccount(driver);
		String userName=rua.getUserName();
		//Assert.assertEquals("Dada Padalkar",userName );
		if(userName.equals(expectedUserName))
		{
			logger.info("Verify Login-Pass");
			Assert.assertTrue(true);
			//for signout
			rua.clickOnSignOutBtn();
		}
		else
		{
			logger.info("Verify Login-Failed");
			captureScreenShot(driver,"Verify Login");
			Assert.assertTrue(false);
		}
	}
	@DataProvider(name="LoginDataProvider")
	public String[][]LoginDataProvider()
	{
		//String fileName="E:\\15 May 2022\\Automation\\MyStoreV3\\TestData\\MyStoreV3TestData.xlsx";
		String fileName=System.getProperty("user.dir")+"\\\\TestData\\\\MyStoreV3TestData.xlsx";
		//use ReadExcel file class for getting values
		int ttlRows =ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns=ReadExcelFile.getcolCount(fileName,"LoginTestData");
		
		String data[][]=new String[ttlRows-1][ttlColumns];
		
		for(int i=1;i<ttlRows;i++)
		{
			for (int j=0;j<ttlColumns;j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginTestData",i,j);
			}
		}
		return data;
	}
	
}
