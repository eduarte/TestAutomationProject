package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
	
	public NewEmployeePage goToCreateNewEmployee() {
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
	
	private WebElement findInTable(String employeeName, String leadName) {
		String[] name = employeeName.split(" ");
		String xpath = ".//td[text()='"+ name[0] +"']/following-sibling::td[text()='"+ name[1] + "']/following-sibling::td[contains(text(),'" + leadName + "')]";
		return listOfEmployeesTable.findElement(By.xpath("//tr["+ xpath +"]"));
	}
	
	public HomePage deleteEmployee(String employeeName, String leadName) {
		findInTable(employeeName,leadName).findElement(By.partialLinkText("Delete")).click();
		
		return new HomePage(driver);
	}
	
	public HomePage acceptDeleteAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return new HomePage(driver);
	}
	
	
	public Boolean isEmployeeDisplayedOnTable(String employeeName, String leadName) {
		try {
			return findInTable(employeeName,leadName).isDisplayed();
		} catch (Exception e) {
			return false;
		}	
		
	}

}
