package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Vtiger {
	public LoginPage_Vtiger(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement usernameTf;
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement passwordTf;
	
	@FindBy(id="submitButton")
	private WebElement SubmitBtn;

	public WebElement getUsernameTf() {
		return usernameTf;
	}

	public WebElement getPasswordTf() {
		return passwordTf;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	public void userLoginMethod(String username, String password) {
		usernameTf.clear();
		usernameTf.sendKeys(username);
		passwordTf.clear();
		passwordTf.sendKeys(password);
		SubmitBtn.submit();
	}
}
