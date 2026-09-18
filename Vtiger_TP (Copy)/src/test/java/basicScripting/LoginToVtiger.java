package basicScripting;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import genericUtility.BrowserUtility;
import genericUtility.FileUtility;
import objectRepository.LoginPage_Vtiger;

public class LoginToVtiger {
	@Test
	public void loginMethodVtigerDemo() throws Exception {
		
		FileUtility fu = new FileUtility();
		BrowserUtility bu = new BrowserUtility();
		WebDriver driver;
		
		//connecting to properties file
		fu.readPropertiesFile();
		
		//storing required data
		String browser = fu.fetchPropertyValue("browser");
		String url = fu.fetchPropertyValue("url");
		String username = fu.fetchPropertyValue("username");
		String password = fu.fetchPropertyValue("password");
		
		//launch browser
		driver = bu.launchBrowser(browser);
		
		//maximize window
		bu.maximizeBrowser(driver);
		
		//set implicit wait
		bu.implicitWaitBrowser(driver, 15);
		
		//navigate to url
		driver.get(url);
		
		//login to vtiger
		LoginPage_Vtiger login = new LoginPage_Vtiger(driver);
		login.userLoginMethod(username, password);
		
		
		
		//close browser
		Thread.sleep(2000);
		driver.quit();
		
		
	}
}
