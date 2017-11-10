package Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseTest;

public class VacationManagementTest extends BaseTest {
	String userEmailText = "gap-automation-test@mailinator.com";
	String passwordText = "12345678";
	String expectedText = "";
	String employeeName = "James Smith";
	String employeeID = "1234567890";
	String employeeEmail = "james.smith@automation.com";
	String leaderName = "Emilio Duarte";
	String startDay = "21-01-2016";
	
	SoftAssert softAssertion= new SoftAssert();
	
	@Test
	public void test01() {
		signInPage.login(userEmailText, passwordText);
		softAssertion.assertTrue(homePage.isUserLogged());
	}
	
	@Test
	public void test02() {
		expectedText = "Signed in successfully.";
		signInPage.login(userEmailText, passwordText);
		softAssertion.assertTrue(homePage.getSignedText().contains(expectedText));
	}
	
	@Test
	public void test03() {

		signInPage.
			login(userEmailText, passwordText).
			clickCreateNewEmployee().
			createNewEmployee(employeeName, employeeEmail, employeeID, leaderName, startDay);
		
	
	}
	

}
