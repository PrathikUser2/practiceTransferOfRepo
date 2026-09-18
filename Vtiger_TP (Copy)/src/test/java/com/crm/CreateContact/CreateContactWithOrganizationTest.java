package com.crm.CreateContact;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.BaseClass.BaseClass;

import objectRepository.HomeDashboard_Vtiger;

public class CreateContactWithOrganizationTest extends BaseClass {

	@Test(groups = "regression")
	public void createContactWithOrganization() throws Exception
	{
		Thread.sleep(2000);
		//click on organization link from dashboard
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		//click on add new organization button
		driver.findElement(By.xpath("//a[text()='Organizations' and @class='hdrLink']/../../descendant::img[@alt='Create Organization...']")).click();
		
		Thread.sleep(2000);
		FileInputStream fis = new FileInputStream("C:\\Users\\prath\\eclipse-workspace\\Vtiger_TP\\src\\test\\resources\\VTigerData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("CreateOrganization");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(0);
		
		
		Random random = new Random();
		int randomInteger = random.nextInt();
		
		String finalOrgName = cell.toString()+randomInteger;
		//passing organization name
		driver.findElement(By.name("accountname")).sendKeys(finalOrgName);
		
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		Thread.sleep(2000);
		
		
		//verify header
		String actHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		boolean status = actHeader.contains(finalOrgName);
		Assert.assertTrue(status);
		
		//navigate to contact module
		
		HomeDashboard_Vtiger home = new HomeDashboard_Vtiger(driver);
		home.getContactsBtn().click();
		Thread.sleep(2000);
		
		//click on create new contact button
		driver.findElement(By.xpath("//a[text()='Contacts' and @class='hdrLink']/../../descendant::td[@class='small'][1]/descendant::img[@title='Create Contact...']")).click();
				
		//open excel in read mode
		fis = new FileInputStream("C:\\Users\\prath\\eclipse-workspace\\Vtiger_TP\\src\\test\\resources\\VTigerData.xlsx");
		wb = WorkbookFactory.create(fis);
		
		String contactName = wb.getSheet("Contacts").getRow(1).getCell(0).toString();
				
		random = new Random();
		randomInteger = random.nextInt();
				
		String lastName = contactName+randomInteger;
				
		//enter name into name textfield
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		//click on add organization
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
		
		String parentWindowId = driver.getWindowHandle();
		
		//switch to child window
		Set<String> set = driver.getWindowHandles();
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext())
		{
			String currentWindowID = iterator.next();
			driver.switchTo().window(currentWindowID);
			
			@Nullable
			String actualUrl = driver.getCurrentUrl();
			if(actualUrl.contains("module=Accounts")) {
				break;
			}
		}
		
		
		driver.findElement(By.id("search_txt")).clear();
		driver.findElement(By.id("search_txt")).sendKeys(finalOrgName, Keys.ENTER);
		Thread.sleep(2500); // Give the table time to reload after searching
		driver.findElement(By.xpath("//a[text()='" + finalOrgName + "']")).click();
		
		
		
		//switch to parent window
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		
		// 5. Save the contact (Only ONCE)
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		Thread.sleep(2000);

		// 6. Verify header
		actHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		status = actHeader.contains(contactName);
		Assert.assertTrue(status);

		// 7. Verify lastname
		String actLastName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName.trim(), lastName);
		soft.assertAll();
		
		
		
		
	}
}
