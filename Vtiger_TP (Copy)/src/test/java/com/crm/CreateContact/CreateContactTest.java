package com.crm.CreateContact;

import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.BaseClass.BaseClass;

import objectRepository.HomeDashboard_Vtiger;

public class CreateContactTest extends BaseClass{
	@Test(groups = "smoke")
	public void createContact() throws Exception
	{
		//navigate to contact link
		HomeDashboard_Vtiger home = new HomeDashboard_Vtiger(driver);
		home.getContactsBtn().click();
		Thread.sleep(2000);
		
		//click on create new contact button
		driver.findElement(By.xpath("//a[text()='Contacts' and @class='hdrLink']/../../descendant::td[@class='small'][1]/descendant::img[@title='Create Contact...']")).click();
		
		//open excel in read mode
		FileInputStream fis = new FileInputStream("C:\\Users\\prath\\eclipse-workspace\\Vtiger_TP\\src\\test\\resources\\VTigerData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		String contactName = wb.getSheet("Contacts").getRow(1).getCell(0).toString();
		
		Random random = new Random();
		int randomInteger = random.nextInt();
		
		String lastName = contactName+randomInteger;
		
		//enter name into name textfield and click on save
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		
		//verifying header
		String actHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		boolean status = actHeader.contains(contactName);
		Assert.assertTrue(status);
		
		//verifing lastname
		String actLastName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName, lastName);
		
		
		
		soft.assertAll();
		Thread.sleep(2000);
		
	}
}
