package com.MystoreV3.Testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

import com.MystoreV3.Utilities.readConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base 
{
readConfig readconfig=new readConfig();
String url=readconfig.getBaseUrl();
String browser=readconfig.getBrowser();
public String emailAddress=readconfig.getEmailAddress();
     String password=readconfig.getPassword();
//creating object variable of webdriver
public static WebDriver driver;
//Creating object of logger class for logging log4j2file
public static Logger logger;
//we are creating setup method for browser launching
@BeforeClass
public void setup()
{
	switch(browser.toLowerCase())
	{
	case"chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		
	case"msedge":
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
	break;
	
	case"firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
		
		default: 
		driver=null;
		break;
	}
	//wait added
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//for logging
    logger=LogManager.getLogger("MyStoreV3");
  //openURL
  		driver.get(url);
  		//start logger
  		logger.info("Url Opened");
 }
/*
@AfterClass
public void tearDown()
{
	driver.close();
	driver.quit();
	
}
*/
public void captureScreenShot(WebDriver driver,String testName)throws IOException
{
	//step 1: convert webdriver object to TakesScreenShot Interface.
	TakesScreenshot screenshot=((TakesScreenshot) driver);
	//call takesscreenshot method to create image file
	File src=screenshot.getScreenshotAs(OutputType.FILE);
	File dest=new File(System.getProperty("user.dir")+"\\ScreenShots\\"+testName+".png");//chk
	//copyfile from src to dest
	FileUtils.copyFile(src,dest);
}
}
