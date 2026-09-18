package com.crm.CreateContact;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.BaseClass.BaseClass;

import objectRepository.HomeDashboard_Vtiger;


/**
 * 
 * @author Prathik
 * 
 * contains method to create contact with support start date and support end date
 */

public class CreateContactWithDateTest extends BaseClass{
	/**
	 * 
	 * @throws Exception
	 * it creates contact with support start date and support end date
	 */

	@Test(groups = "regression")
	public void createContactWithDate() throws Exception
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
				
				//enter name into name textfield 
				driver.findElement(By.name("lastname")).sendKeys(lastName);
				
				
				
				Date dateObj = new Date();
				SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
				String startDate = sim.format(dateObj);
			//	System.out.println(actDate);
				
				Calendar cal = sim.getCalendar();
				cal.add(Calendar.DAY_OF_MONTH,30);
				String endDate = sim.format(cal.getTime());
			//	System.out.println(dateRequired);
				
				
				//enter support date for 30 days
				driver.findElement(By.name("support_start_date")).clear();
				driver.findElement(By.name("support_start_date")).sendKeys(startDate);
			
				Thread.sleep(1000);
				
				driver.findElement(By.name("support_end_date")).clear();
				driver.findElement(By.name("support_end_date")).sendKeys(endDate);
			
				
				

				
				driver.findElement(By.xpath("//input[@accesskey='S']")).click();
				
				
	
				//verifying header
				String actHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				boolean status = actHeader.contains(contactName);
				Assert.assertTrue(status);
				
				//verifying last name
				String actLastName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
				SoftAssert soft = new SoftAssert();
				soft.assertEquals(actLastName, lastName);
				soft.assertAll();
				Thread.sleep(2000);
				
				//verifying start and end date
				String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
				soft.assertEquals(actStartDate, startDate);
				String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
				soft.assertEquals(actEndDate, endDate);
	}
}
