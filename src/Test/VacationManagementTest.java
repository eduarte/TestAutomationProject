package Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseTest;

public class VacationManagementTest extends BaseTest {
	String userEmailText = "";
	String passwordText = "";
	String expectedText = "";
	SoftAssert softAssertion= new SoftAssert();
	
	@Test
	public void test01() {
		userEmailText = "gap-automation-test@mailinator.com";
		passwordText ="12345678";
		signInPage.login(userEmailText, passwordText);
		softAssertion.assertTrue(homePage.isUserLogged());
	}
	
	@Test
	public void test02() {
		userEmailText = "gap-automation-test@mailinator.com";
		passwordText ="12345678";
		expectedText = "Signed in successfully.";
		signInPage.login(userEmailText, passwordText);
		softAssertion.assertTrue(homePage.getSignedText().contains(expectedText));
	}
	

}
