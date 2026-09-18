package genericUtility;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtility {

	public WebDriver launchBrowser(String browser) throws Exception
	{	
		//Handling Change your Password Notification
		final Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
				
		WebDriver driver ;
			if(browser.equalsIgnoreCase("Chrome"))
				driver = new ChromeDriver(chromeOptions);
			else if(browser.equalsIgnoreCase("Firefox"))
				driver = new FirefoxDriver();
			else if(browser.equalsIgnoreCase("Edge"))
				driver = new EdgeDriver();
			else
				driver = new ChromeDriver(chromeOptions);
		return driver;
	}
	
	public void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void implicitWaitBrowser(WebDriver driver,int seconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	public void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	public void closeBrowser(WebDriver driver)
	{
		driver.close();
	}
}
