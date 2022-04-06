package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;
import pageObject.LoginlandPage;
import pageObject.MyAcountPage;
import sources.Base;

public class login extends Base {
	public WebDriver driver;
    @Given("^Open any Browser$")
    public void open_any_browser() throws Throwable {
    	driver = initilizationDriver();	
    	
    	
    }
    @And("^Navigate to Login page$")
    public void navigate_to_login_page() {
    	driver.get(p.getProperty("url")); 
    	LoginlandPage login = new LoginlandPage(driver);
    	login.myAccountDropDown().click();
    	login.loginOption().click();
    }
    @When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
    public void user_enters_username_as_something_and_password_as_something_into_the_fields(String strArg1, String strArg2) {
    	LoginPage loginPage= new LoginPage(driver);
    	loginPage.emailFields().sendKeys(strArg1);
    	loginPage.passwordsFields().sendKeys(strArg2);
    }
    
    @And("^User clicks on Login button$")
    public void user_clicks_on_login_button() {
    	LoginPage loginPage= new LoginPage(driver);
    	loginPage.loginbutton().click();
    	
    }

    @Then("^Verify user is able to successfully login$")
    public void verify_user_is_able_to_successfully_login() {
    	MyAcountPage map=new MyAcountPage(driver);

    	Assert.assertTrue(map.accountInformation().isDisplayed());

    	
    	
    	
    
    
    
    }
    @After
    public void closer() {
    	driver.close();
    }
    
}
