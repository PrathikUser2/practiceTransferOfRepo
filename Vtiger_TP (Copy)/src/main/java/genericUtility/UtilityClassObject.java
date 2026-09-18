package genericUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

// this class helps to share the static variable for multiple threads during parallel execution
public class UtilityClassObject {
	
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static ExtentTest getTest() {
		return test.get();
	}
	
	public static void setTest(ExtentTest actTest) {
		test.set(actTest);
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void setDriver(WebDriver actDriver) {
		driver.set(actDriver);
	}
}
