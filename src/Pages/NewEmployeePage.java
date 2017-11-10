package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class NewEmployeePage extends BasePage {
	
	
	@FindBy(how = How.ID, using = "employee_first_name")
	private WebElement employeeFirstName;
	
	@FindBy(how = How.ID, using = "employee_last_name")
	private WebElement employeeLasttName;
	
	@FindBy(how = How.ID, using = "employee_email")
	private WebElement employeeEmail;
	
	@FindBy(how = How.ID, using = "employee_identification")
	private WebElement employeeID;
	
	@FindBy(how = How.ID, using = "employee_leader_name")
	private WebElement leaderName;
	
	@FindBy(how = How.ID, using = "employee_start_working_on_1i")
	private WebElement startWorkingYear;
	
	@FindBy(how = How.ID, using = "employee_start_working_on_2i")
	private WebElement startWorkingMonth;
	
	@FindBy(how = How.ID, using = "employee_start_working_on_3i")
	private WebElement startWorkingDay;
	
	@FindBy(how = How.XPATH, using = ".//input[@value='Create Employee']")
	private WebElement createEmployeeButton;
	
	//employee_identification

	public NewEmployeePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

}
