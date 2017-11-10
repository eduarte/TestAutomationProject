package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class PublicSitePage extends BasePage {
	
	@FindBy(how = How.ID, using = "employee_identification")
	private WebElement employeeIDInput;
	
	@FindBy(how = How.XPATH, using = ".//input[@value='Find Employee']")
	private WebElement findEmployeeButton;
	
	@FindBy(how = How.XPATH, using = ".//div[contains(@id,'content')]//h1")
	private WebElement employeeInformationText;
	

	public PublicSitePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	private PublicSitePage setEmployeeId(String employeeID) {
		employeeIDInput.sendKeys(employeeID);
		return new PublicSitePage(driver);
	}
	
	private PublicSitePage clickFindEmployeeButton() {
		findEmployeeButton.click();
		return new PublicSitePage(driver);
	}
	
	public String getEmployeeInfo() {
		return employeeInformationText.getText();
	}
	
	public PublicSitePage findEmployee(String employeeID) {
		setEmployeeId(employeeID).clickFindEmployeeButton();
		return new PublicSitePage(driver);
	}

}
