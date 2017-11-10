package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.BasePage;

public class NewEmployeePage extends BasePage {
	
	
	@FindBy(how = How.ID, using = "employee_first_name")
	private WebElement employeeFirstNameInput;
	
	@FindBy(how = How.ID, using = "employee_last_name")
	private WebElement employeeLasttNameInput;
	
	@FindBy(how = How.ID, using = "employee_email")
	private WebElement employeeEmailInput;
	
	@FindBy(how = How.ID, using = "employee_identification")
	private WebElement employeeIDInput;
	
	@FindBy(how = How.ID, using = "employee_leader_name")
	private WebElement leaderNameInput;
	
	@FindBy(how = How.ID, using = "employee_start_working_on_1i")
	private WebElement startYearSelect;
	
	@FindBy(how = How.ID, using = "employee_start_working_on_2i")
	private WebElement startMonthSelect;
	
	@FindBy(how = How.ID, using = "employee_start_working_on_3i")
	private WebElement startDaySelect;
	
	@FindBy(how = How.XPATH, using = ".//input[@value='Create Employee']")
	private WebElement createEmployeeButton;
	Select dropdown = null;
	
	@FindBy(how = How.ID, using = "notice")
	private WebElement noticeText;
	

	public NewEmployeePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public NewEmployeePage createNewEmployee(String employeeName,String employeeEmail, String employeeID, String leaderName, String startDay) {
		String[] name = employeeName.split(" ");
		setEmployeeName(name[0]).
		setEmployeeLastName(name[1]).
		setEmployeeEmail(employeeEmail).
		setEmployeeID(employeeID).
		setLeaderName(leaderName).
		setStartDate(startDay).
		clickCreateNewEmployee();
		return new NewEmployeePage(driver);
	}
	
	private NewEmployeePage setEmployeeName(String employeeName) {
		employeeFirstNameInput.sendKeys(employeeName);
		return new NewEmployeePage(driver);
	}
	
	private NewEmployeePage setEmployeeLastName(String employeeLastName) {
		employeeLasttNameInput.sendKeys(employeeLastName);
		return new NewEmployeePage(driver);
	}
	
	private NewEmployeePage setEmployeeEmail(String employeeEmail) {
		employeeEmailInput.sendKeys(employeeEmail);
		return new NewEmployeePage(driver);
	}
	
	private NewEmployeePage setEmployeeID (String employeeID) {
		employeeIDInput.sendKeys(employeeID);
		return new NewEmployeePage(driver);
	}
	
	private NewEmployeePage setLeaderName (String leaderName) {
		leaderNameInput.sendKeys(leaderName);
		return new NewEmployeePage(driver);
	}
	
	private NewEmployeePage setStartDate (String startDay) {
		String[] date = startDay.split("-");
		setStartDay(date[0].replaceFirst("^0+(?!$)", ""));
		setStartMonth(date[1].replaceFirst("^0+(?!$)", ""));
		setStartYear(date[2].replaceFirst("^0+(?!$)", ""));


		return new NewEmployeePage(driver);
	}
	
	private NewEmployeePage setStartYear(String startYear) {
		dropdown = new Select(startYearSelect);
		dropdown.selectByValue(startYear);
		return new NewEmployeePage(driver);
	}
	
	private NewEmployeePage setStartMonth(String startMonth) {
		dropdown = new Select(startMonthSelect);
		dropdown.selectByValue(startMonth);
		return new NewEmployeePage(driver);
	}
	
	private NewEmployeePage setStartDay(String startDay) {
		dropdown = new Select(startDaySelect);
		dropdown.selectByVisibleText(startDay);
		return new NewEmployeePage(driver);
	}
	
	private NewEmployeePage clickCreateNewEmployee() {
		createEmployeeButton.click();
		return new NewEmployeePage(driver);
	}
	
	public String getNoticeText() {
		return noticeText.getText();
	}

}
