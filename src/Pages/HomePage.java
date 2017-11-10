package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class HomePage extends BasePage {
	
	@FindBy(how = How.XPATH, using = ".//a[text()='Create a new employee']")
	private WebElement createNewEmployeeLink;
	
	@FindBy(how = How.TAG_NAME, using = "table")
	private WebElement listOfEmployeesTable;
	
	@FindBy(how = How.CLASS_NAME, using = "flash_notice")
	private WebElement signedText;
	
	@FindBy(how = How.XPATH, using = ".//a[text()='Logout']")
	private WebElement logoutLink;
	

	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public NewEmployeePage clickCreateNewEmployee() {
		createNewEmployeeLink.click();
		return new NewEmployeePage(driver);
	}
	
	public String getSignedText() {
		return signedText.getText();
	}
	
	public Boolean isUserLogged() {
		return signedText.isDisplayed();
	}
	
	public SignInPage clickLogout() {
		logoutLink.click();
		return new SignInPage(driver);
	}

}
