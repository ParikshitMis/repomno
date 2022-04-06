package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.LoginlandPage;
import pageObject.MyAcountPage;
import sources.Base;

public class LoginTest extends Base {
	public WebDriver driver;
	Logger log ;
	@BeforeMethod
	public void openBrowser() throws IOException, InterruptedException {
		System.out.println("in side login test");
	    log = LogManager.getLogger(LoginTest.class.getName());
		 driver = initilizationDriver();
	  
		log.debug("Browser got launched");
		Thread.sleep(3000);
		driver.get(p.getProperty("url"));
		log.debug("url got open");
		
	}
	@Test(dataProvider="testData")
	public void logintestOne(String email,String password,String expectedResult) throws IOException, InterruptedException {
		System.out.println("in side login test");
	
		LoginlandPage login = new LoginlandPage(driver);
		login.myAccountDropDown().click();
		 log.debug("Clicked on My account dropdown ");
		login.loginOption().click();
		 log.debug("clicked on login option ");
		
		Thread.sleep(3000);
		LoginPage loginPage= new LoginPage(driver);
		loginPage.emailFields().sendKeys(email);
		 log.debug("Entered email into email fields");
		loginPage.passwordsFields().sendKeys(password);
		 log.debug("Entered password into password fields");
		loginPage.loginbutton().click();
		 log.debug("clicked on login button");
		
		
		
		MyAcountPage map=new MyAcountPage(driver);

		String actualResult= null;
		try {
			if(map.accountInformation().isDisplayed()) {
				actualResult="Sucessufully";
				log.info(actualResult);
			}
		}catch(Exception e) {
			actualResult="Failure";
			log.error(actualResult);
		}
		Assert.assertEquals(actualResult,expectedResult);
		
		log.debug(actualResult);
		Assert.assertTrue(false);

		
		
		
	}
	
	@AfterMethod
	public void clouser() {
	
	
		driver.close();
		
		log.debug("browser got closed");
	}
	@DataProvider
	public Object[][] testData() {
		Object[][]data= {{"arun.selenium@gmail.com","Second@123","Sucessufully"}};
		return data;
	}
}