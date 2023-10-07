package com.MystoreV3.Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.MystoreV3.pageObject.IndexPage;
import com.MystoreV3.pageObject.OrderAddressPage;
import com.MystoreV3.pageObject.OrderConfirmationPage;
import com.MystoreV3.pageObject.OrderPaymentPage;
import com.MystoreV3.pageObject.OrderShippingPage;
import com.MystoreV3.pageObject.OrderSummaryPage;
import com.MystoreV3.pageObject.ProductPage;
import com.MystoreV3.pageObject.myAccount;
import com.MystoreV3.pageObject.registeredUserAccount;
import com.MystoreV3.pageObject.searchResultPage;

import junit.framework.Assert;

public class TC_ProductPageTest extends Base 
{
  @Test(enabled=true)
	public void VerifySearchProduct() throws Exception
	{
		String searchKey="T-shirts";
		logger.info("product search verification started...");
		myAccount ma=new myAccount(driver);
		//index pagelogin 
		IndexPage ip=new IndexPage(driver);
		ip.clickOnSignIn();
		
		ma.enterRegUserName("dadapadalkar64@gmail.com");
		ma.enterRegPassword("ABCDE");
		ma.clickOnSubmitloginbtn();
		logger.info("Sign In clicked......");
		//clicking on search and entering search key..
		searchResultPage sr=new searchResultPage(driver);
		registeredUserAccount ra=new registeredUserAccount(driver);
		ra.EnterDataInSearchBox(searchKey);
		ra.clickOnSearch();
		logger.info("Clicked on Search button");
		
		//getting text from result page
		String SearchResultProductName=sr.getSearchResultText();
		
		if(SearchResultProductName.contains(searchKey))
		{
			logger.info("Test Case Passed");
			Assert.assertTrue(true);
			sr.clickOnsignOutbtn();
		}
		else
		{
			logger.info("Test Case Failed");
			captureScreenShot(driver,"VerifySearchProduct");
			Assert.assertTrue(false);
			
		}
		
		
	}
 
  @Test(enabled=true)
 	public void VerifBuyProduct() throws Exception
 	{
 		logger.info("Buy Product Verification started...");
 		myAccount ma=new myAccount(driver);
 		//index pagelogin 
 		IndexPage ip=new IndexPage(driver);
 		ip.clickOnSignIn();
 		
 		ma.enterRegUserName("dadapadalkar64@gmail.com");
 		ma.enterRegPassword("ABCDE");
 		ma.clickOnSubmitloginbtn();
 		logger.info("Sign In clicked......");
 		//clicking on search and entering search key..
 		searchResultPage sr=new searchResultPage(driver);
 		registeredUserAccount ra=new registeredUserAccount(driver);
 		ra.EnterDataInSearchBox("T-Shirts");
 		logger.info("T-Shirt entered in search box");
 		ra.clickOnSearch();
 		logger.info("Clicked on Search button");
 		sr.clickOnMoreButton();
 		logger.info("More button clicked......");
 		Thread.sleep(4000);
 		ProductPage pp=new ProductPage(driver);
 		pp.setQuantity("2");
 		logger.info("Qty 2 Enterred");
 		pp.selectSize("M");
 		logger.info("M size selected");
 		pp.clickOnAddtoCart();
 		logger.info("Add to cart clicked......");
 		pp.clickOnProceedToCheckOut();
 		logger.info("Proceed to check out clicked......");
 		
 		OrderSummaryPage os=new OrderSummaryPage(driver);
 		os.clickOnProceedtoCheckOut();
 		logger.info("Proceed to check out clicked.from Order Summary Page.....");
 		
 		OrderAddressPage orderaddress=new OrderAddressPage (driver);
 		orderaddress.clickOnproceedfromAddressPage();
 		logger.info("Proceed to check out clicked.from Order Address Page.....");
 		
 		OrderShippingPage ordeshipping=new OrderShippingPage (driver);
 		ordeshipping.clickOnTermsOfService();
 		ordeshipping.proceedTocheckout();
 		logger.info("Proceed to check out clicked.from Shipping address Page.....");
 		
 		OrderPaymentPage OrdrPayment =new OrderPaymentPage(driver);
 		OrdrPayment.clickOnPayByCheque();
 		logger.info("clicked on Payby cheque from order payment page.....");
 		
 		OrderConfirmationPage OrdCnfrPg=new OrderConfirmationPage(driver);
 		OrdCnfrPg.clickOnconfirmOrder();
 		logger.info("clicked on Confirm order on orderconfirmation  page.....");
 		
 		String successmessage=OrdCnfrPg.getOrderSuccessMessage();
 		
 		//Assert for verifying sucess of order.
 		if (successmessage.equals("Your order on My Store is complete"))
 		{
 			logger.info("Verify Buy product Test is passed...");
 			Assert.assertTrue(true);
 			OrdCnfrPg.clickOnSignOut();
 		}
 		else
 		{
 			logger.info("Verify Buy product Test is Failed...");
 			captureScreenShot(driver,"VerifyBuyProduct");
 			Assert.assertTrue(false);
 		}
 		
 		logger.info(".......Verify Buy product Test is Ended.....");
 	}
 
}
