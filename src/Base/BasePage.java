package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForLoad(WebElement element) {
		 new WebDriverWait(driver, 45)
         .until(ExpectedConditions.visibilityOf(element));
	}
	
	public Boolean isElementDisplayed(WebElement element){
		return element.isDisplayed();
	}
	
	public Boolean VerifyDataEquals(String firstValue, String secondValue){
		if (firstValue.equals(secondValue)) {
			return true;
		} else {
			return false;
		}
	}
	
	

}
