package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginlandPage {
	WebDriver driver;
	
	public LoginlandPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
		
	}
	@FindBy(xpath="//span[contains(text(),'My Account')]")
	private WebElement myAccountDropDown;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	

	
	public WebElement myAccountDropDown() {
		return myAccountDropDown;
	}
	public WebElement loginOption() {
		return loginOption;
	}

}
