package com.crm.CreateOrganization;

import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass;

import objectRepository.HomeDashboard_Vtiger;

public class CreateOrganizationTest extends BaseClass{

	@Test(groups = "smoke")
	public void createOrganizationTest() throws Exception
	{
		
		//click on organization link from dashboard
		HomeDashboard_Vtiger home = new HomeDashboard_Vtiger(driver);
		home.getOrganizationsBtn().click();
		
		//click on add new organization button
		driver.findElement(By.xpath("//a[text()='Organizations' and @class='hdrLink']/../../descendant::img[@alt='Create Organization...']")).click();
		
		//fetch organization name from excel
		FileInputStream fis = new FileInputStream("C:\\Users\\prath\\eclipse-workspace\\Vtiger_TP\\src\\test\\resources\\VTigerData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("CreateOrganization");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(1);
		
		//random integer generation
		Random random = new Random();
		int randomInteger = random.nextInt();
		
		//passing organization name
		driver.findElement(By.name("accountname")).sendKeys(cell.toString()+randomInteger);
		
		//click on save button
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		Thread.sleep(2000);
		
	}
	
	
	
}	
