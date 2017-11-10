package Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseTest;

public class VacationManagementTest extends BaseTest {
	String userEmailText = "gap-automation-test@mailinator.com";
	String passwordText = "12345678";
	String expectedCreatedText = "Employee was successfully created";
	String employeeInfo = "";
	String employeeName = "James Smith";
	String employeeID = "1234567890";
	String employeeEmail = "james.smith@automation.com";
	String leaderName = "Emilio Duarte";
	String startDay = "21-01-2016";
	Boolean result = true;
	
	SoftAssert softAssertion= new SoftAssert();
	
	@Test(priority=1)
	public void testLogin() {
		signInPage.login(userEmailText, passwordText);
		softAssertion.assertTrue(homePage.isUserLogged());
	}
	
	
	@Test(priority=2)
	public void testCreatingANewUser() {
		
		result = signInPage.
			login(userEmailText, passwordText).
			goToCreateNewEmployee().
			createNewEmployee(employeeName, employeeEmail, employeeID, leaderName, startDay).
			verifyEmployeeInformation(expectedCreatedText, employeeName, employeeEmail, employeeID, leaderName, startDay);
		
		softAssertion.assertTrue(result);
	
	}
	
	@Test(priority=3)
	public void testVerifyPublicInfo() {

		employeeInfo = signInPage.
			goToPublicSitePage().
			findEmployee(employeeID).
			getEmployeeInfo();
		
		softAssertion.assertTrue(employeeInfo.contains(employeeName));
	
	}
	
	@Test(priority=4)
	public void testDeleteUser() {

		signInPage.
				login(userEmailText, passwordText).
				deleteEmployee(employeeName, leaderName).
				acceptDeleteAlert();
		
		softAssertion.assertFalse((homePage.isEmployeeDisplayedOnTable(employeeName, leaderName)));
	
	}
	

}
