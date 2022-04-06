package tests;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import sources.Base;

public class ThreeTest extends Base{
	public WebDriver driver;

	@Test
	public void threeTest() throws IOException, InterruptedException {
		System.out.println("inside test three");
		 driver = initilizationDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scores/32493/nzw-vs-engw-19th-match");
		Thread.sleep(2000);
		
		Assert.assertTrue(false);
		
		
	}
	@AfterMethod
	public void closer() throws InterruptedException{
		Thread.sleep(2000);
		driver.close();
		
	}

}
