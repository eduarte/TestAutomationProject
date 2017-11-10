package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class SignInPage extends BasePage {
	
	@FindBy(how = How.ID, using = "user_email")
	private WebElement userEmail;
	
	@FindBy(how = How.ID, using = "user_password")
	private WebElement userPassword;
	
	@FindBy(how = How.CLASS_NAME, using = "submit")
	private WebElement submitButton;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Forgot your password?")
	private WebElement forgotPasswordLink;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "public site")
	private WebElement publicSiteLink;

	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	private SignInPage setUserName (String userEmailText) {
		userEmail.sendKeys(userEmailText);
		return new SignInPage(driver);
	}
	
	private SignInPage setPassword (String passwordText) {
		userPassword.sendKeys(passwordText);
		return new SignInPage(driver);
	}
	
	private SignInPage clickLoginButton () {
		submitButton.click();
		return new SignInPage(driver);
	}
	
	public PublicSitePage goToPublicSitePage() {
		publicSiteLink.click();
		return new PublicSitePage(driver);
	}
	
	
	
	public HomePage login(String userEmailText, String passwordText) {
		setUserName(userEmailText).
		setPassword(passwordText).
		clickLoginButton();
		
		return new HomePage(driver);
	}
	

}
