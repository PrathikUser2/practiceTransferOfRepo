package com.crm.CreateOrganization;

import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass;

import objectRepository.HomeDashboard_Vtiger;

public class CreateOrganizationWithContact extends BaseClass {

	@Test(groups = "regression")
	public void createorganizationWithContact() throws Exception {
		
		//click on organization link from dashboard
		HomeDashboard_Vtiger home = new HomeDashboard_Vtiger(driver);
		home.getOrganizationsBtn().click();
		
		//click on add new organization button
		driver.findElement(By.xpath("//a[text()='Organizations' and @class='hdrLink']/../../descendant::img[@alt='Create Organization...']")).click();
		
		//fetch data from excel
		FileInputStream fis = new FileInputStream("C:\\Users\\prath\\eclipse-workspace\\Vtiger_TP\\src\\test\\resources\\VTigerData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		//storing data in variable
		String orgName = wb.getSheet("CreateOrganization").getRow(4).getCell(1).toString();
		String orgPhone =wb.getSheet("CreateOrganization").getRow(4).getCell(2).toString();
		
		//generating random number
		Random random = new Random();
		int randomInteger = random.nextInt();
		Thread.sleep(2000);
		
		//passing organization name and phone number
		driver.findElement(By.name("accountname")).sendKeys(orgName+randomInteger);
		driver.findElement(By.id("phone")).sendKeys(orgPhone);
		
		//click on save button
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		Thread.sleep(2000);
		
		//verify organization name
		
		
		//verify phone number
		
		
	}
}
