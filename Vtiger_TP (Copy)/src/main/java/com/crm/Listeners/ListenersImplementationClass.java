package com.crm.Listeners;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.BaseClass;

import genericUtility.UtilityClassObject;

public class ListenersImplementationClass implements ISuiteListener,ITestListener {
	public ExtentSparkReporter spark;
	public ExtentReports report;
	ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		//report configuration
		
		spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		
		//add environment information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "Chrome-152");
	}
	
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("==========="+result.getMethod().getMethodName()+"====START======= ");
		
		test =  report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"====> Started <=====");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("==========="+result.getMethod().getMethodName()+"====END======= ");
		test.log(Status.PASS, result.getMethod().getMethodName()+"=====> Completed <=====");
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		
		String testName = result.getMethod().getMethodName();
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;     //static variable sdriver
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		
		test.addScreenCaptureFromBase64String(filePath,testName+"_"+time);
		
		test.log(Status.FAIL, result.getMethod().getMethodName()+"=====> Failed <=====");

	}
	
	@Override
	public void onTestSkipped(ITestResult result) {

	}
	
}
