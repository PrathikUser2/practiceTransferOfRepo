package com.crm.CreateOrganization;

import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass;

public class CreateOrganizationWithIndustry extends BaseClass{
	@Test
	public void createOrganizationWithIndustry() throws Exception
	{
		
		//click on organization link from dashboard
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		//click on add new organization button
		driver.findElement(By.xpath("//a[text()='Organizations' and @class='hdrLink']/../../descendant::img[@alt='Create Organization...']")).click();
		
		//fetch data from excel
		FileInputStream fis = new FileInputStream("C:\\Users\\prath\\eclipse-workspace\\Vtiger_TP\\src\\test\\resources\\VTigerData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		//storing data in variable
		String orgName = wb.getSheet("CreateOrganization").getRow(7).getCell(1).toString();
		String industryValue =wb.getSheet("CreateOrganization").getRow(7).getCell(2).toString();
		String typeValue =wb.getSheet("CreateOrganization").getRow(7).getCell(3).toString();
		
		//generating random number
		Random random = new Random();
		int randomInteger = random.nextInt();
		
		
		//passing organization name
		driver.findElement(By.name("accountname")).sendKeys(orgName+randomInteger);
		
		//industry dropdown
		WebElement industryDropdown = driver.findElement(By.xpath("//select[@name='industry']"));
		WebElement typeDropdown = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select s = new Select(industryDropdown);
		s.selectByVisibleText(industryValue);
		s = new Select(typeDropdown);
		s.selectByContainsVisibleText(typeValue);
		
		//click on save button
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		Thread.sleep(2000);
		
		//verify organization name
		
		
		//verify industry and type name
		
		
		
	}
}
