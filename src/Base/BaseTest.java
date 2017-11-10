package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Pages.HomePage;
import Pages.NewEmployeePage;
import Pages.SignInPage;

public class BaseTest {

	protected static WebDriver driver;
	protected SignInPage signInPage;
	protected HomePage homePage;
	protected NewEmployeePage newEmployeePage;

	@BeforeMethod
	@Parameters({ "browser", "startURL" })
	public void setup(String browser, String startURL)  {
		createDriver(browser, startURL);
		signInPage = new SignInPage(driver);
		homePage = new HomePage(driver);
		newEmployeePage = new NewEmployeePage(driver);

	}

	public WebDriver createDriver(String browserType, String startURL) {

		try {
			driver = null;
			if (browserType.toLowerCase().equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserType.toLowerCase().equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			driver.get(startURL);
			driver.manage().window().maximize();
			return driver;
		} catch (Exception e) {
			System.out.println(e);
			return driver;
		}
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
	}

}
