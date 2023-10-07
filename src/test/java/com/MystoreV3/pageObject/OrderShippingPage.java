package com.MystoreV3.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShippingPage 
{
WebDriver ldriver;
public OrderShippingPage (WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

@FindBy(id="cvg")
WebElement termsandservice;

@FindBy(name="processCarrier")
WebElement proceedtocheckout;

public void clickOnTermsOfService()
{
	termsandservice.click();
}

public void proceedTocheckout()
{
	proceedtocheckout.click();
}

}
