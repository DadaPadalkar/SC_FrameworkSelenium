package com.MystoreV3.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener
{
ExtentSparkReporter htmlReporter;
ExtentReports reports;
ExtentTest    test;
public void configureReport()
{
	readConfig readConfig=new readConfig();
	
	htmlReporter=new ExtentSparkReporter("ExtentListnerReportDemo.html");
	reports=new ExtentReports();
	reports.attachReporter(htmlReporter);
	
	//add Systeminfo 
	reports.setSystemInfo("Machine", "testpc1");
	reports.setSystemInfo("OS","Windows10");
	reports.setSystemInfo("browser",readConfig.getBrowser());
	reports.setSystemInfo("UserName","DP");
	//HTML report look and feel change
	htmlReporter.config().setDocumentTitle("Extent Listner Report Demo");
	htmlReporter.config().setReportName("This is My First Report");
	htmlReporter.config().setTheme(Theme.DARK);
}
public void onStart(ITestContext Result)
{
	configureReport();
	System.out.println("On Start Method invoked....");
}
public void onFinish(ITestContext Result)
{
	System.out.println("On Finish method invoked....");
	reports.flush();//imp mandatory for writing information in html report.
}
//When Test Case get failed this method got called

public void onTestFailure(ITestResult Result)
{
	
	System.out.println("Name of the Test Method Failed:"+Result.getName());
	test=reports.createTest(Result.getName());//for creating entry in html report..
	test.log(Status.FAIL,MarkupHelper.createLabel("Name of Failed Test Case is"+Result.getName(),ExtentColor.RED));
	//for taking screenshot path needed
	//String Screenshotpath=(System.getProperty("user.dir")+"\\ScreenShots\\"+Result.getName()+".png");
	String Screenshotpath=("E:\\15 May 2022\\Automation\\MyStoreV3\\ScreenShots");
	//object of File class
	File screenshotfile=new File(Screenshotpath);
	if(screenshotfile.exists())
	{
		test.fail("Captured Screenshot is Below:"+test.addScreenCaptureFromPath(Screenshotpath));
	}
	
}

//on Test skipp
public void onTestSkipped(ITestResult Result)
{
	System.out.println("Name of the Method which is Skipped:"+Result.getName());
	test=reports.createTest(Result.getName());
	test.log(Status.SKIP,MarkupHelper.createLabel("Name of Skipped Test Case is"+Result.getName(),ExtentColor.YELLOW));
}
public void onTestStart(ITestContext Result)
{
	System.out.println("Name of the test which is Started:"+Result.getName());
}
//when test get passed
public void onTestSuccess(ITestResult Result)
{
	System.out.println("Name of the Method which is successfully Executed:"+Result.getName());
	test=reports.createTest(Result.getName());
	test.log(Status.PASS,MarkupHelper.createLabel("Name of Passed Test Case is"+Result.getName(),ExtentColor.GREEN));
}
public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
{
	
}
}
