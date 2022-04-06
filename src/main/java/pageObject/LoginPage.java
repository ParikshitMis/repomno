package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="input-email")
	private WebElement emailFields;
	
	@FindBy(id="input-password")
	private WebElement passwordsFields;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginbutton;
	
	public WebElement emailFields() {
		return emailFields;
	}
	public WebElement passwordsFields() {
		return passwordsFields;
	}
	public WebElement loginbutton() {
		return loginbutton;
	}
	

}
