package com.crm.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import genericUtility.BrowserUtility;
import genericUtility.FileUtility;
import genericUtility.UtilityClassObject;
import objectRepository.LoginPage_Vtiger;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	BrowserUtility bu;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	
	@BeforeSuite(groups = "smoke")
	public void configBS()
	{
		System.out.println("==connect db, report generation==");
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
	
	@BeforeClass(groups = "smoke")
	public void configBC() throws Exception
	{
		System.out.println("==launch browser==");
		//launch browser, maximize and set implicit wait
		bu = new BrowserUtility();
		driver = bu.launchBrowser("Chrome");
		sdriver =driver;
		UtilityClassObject.setDriver(driver); 
		bu.maximizeBrowser(driver);
		bu.implicitWaitBrowser(driver, 15);
	}
	
	@BeforeMethod(groups = "smoke")
	public void configBM() throws Exception
	{
		System.out.println("==login==");
		
		//navigate to application and login
		FileUtility fu = new FileUtility();
		LoginPage_Vtiger login = new LoginPage_Vtiger(driver);

		driver.get(fu.fetchPropertyValue("url"));
		login.userLoginMethod("admin", "admin");
		
	}
	
	@AfterClass(groups = "smoke")
	public void configAC()
	{
		System.out.println("==close browser==");
		
		//quit browser
		bu.quitBrowser(driver);
	}
	
	@AfterMethod(groups = "smoke")
	public void configAM() throws Exception
	{
		System.out.println("==logout");
		driver.findElement(By.xpath("//span[text()='ACOE Fireflink']/../../td[@class='small'][1]/img")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(1000);
	}
	
	@AfterSuite(groups = "smoke")
	public void configAS()
	{
		System.out.println("==disconnect db, report backup");
		report.flush();
	}
}
