package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import sources.Base;

public class FourTest extends Base{
	 public WebDriver driver;
	@Test
	public void fourTest() throws IOException {
		
		
		
		System.out.println("kiran has made some changes in his machine ");
		System.out.println("inside four test");
		 driver= initilizationDriver();
		driver.get("https://www.amazon.in/");
	
		
	 
	
		
	}
	@AfterMethod
	public void methodB() throws InterruptedException {
		Thread.sleep(3000);
		
		driver.quit();
	}

}
