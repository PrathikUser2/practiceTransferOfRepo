package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeDashboard_Vtiger {
	public HomeDashboard_Vtiger(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Calendar']")
	private WebElement calendarBtn;
	
	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement organizationsBtn;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactsBtn;
	
	@FindBy(xpath = "//a[text()='Opportunities']")
	private WebElement opportunitiesBtn;
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productsBtn;
	
	@FindBy(xpath = "//a[text()='Documents']")
	private WebElement documentsBtn;
	
	@FindBy(xpath = "//a[text()='Email']")
	private WebElement emailBtn;
	
	@FindBy(xpath = "//a[text()='Trouble Tickets']")
	private WebElement troubleticketsBtn;
	
	@FindBy(xpath = "//a[text()='Dashboard']")
	private WebElement dashboardBtn;
	
	@FindBy(xpath = "//a[text()='Leads']")
	private WebElement LeadsBtn;
	
	@FindBy(xpath = "//a[text()='More']")
	private WebElement MoreBtn;
	
	@FindBy(xpath = "//td[@class='small']/preceding-sibling::td[@class=\"tabUnSelected\"]/a/img")
	private WebElement homeBtn;
	
	@FindBy(xpath = "//input[@class='searchBox']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//input[@class='searchBtn']")
	private WebElement searchBtn;
	
	

	public WebElement getCalendarBtn() {
		return calendarBtn;
	}

	public WebElement getOrganizationsBtn() {
		return organizationsBtn;
	}

	public WebElement getContactsBtn() {
		return contactsBtn;
	}

	public WebElement getOpportunitiesBtn() {
		return opportunitiesBtn;
	}

	public WebElement getProductsBtn() {
		return productsBtn;
	}

	public WebElement getDocumentsBtn() {
		return documentsBtn;
	}

	public WebElement getEmailBtn() {
		return emailBtn;
	}

	public WebElement getTroubleticketsBtn() {
		return troubleticketsBtn;
	}

	public WebElement getDashboardBtn() {
		return dashboardBtn;
	}

	public WebElement getLeadsBtn() {
		return LeadsBtn;
	}

	public WebElement getMoreBtn() {
		return MoreBtn;
	}

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	
}
