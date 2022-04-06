package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import sources.Base;

public class TwoTest extends Base{
	public WebDriver driver ;
	@Test
	public void twoTest() throws IOException, InterruptedException {
		System.out.println("inside two test");
		 driver = initilizationDriver();
		driver.get("https://www.flipkart.com/mobiles/~cs-kz84hcsprl/pr?sid=tyy%2C4io&collection-tab-name=Samsung+F23&param=65333&otracker=hp_bannerads_2_3.bannerAdCard.BANNERADS_Mob_HPW_Samsung%2BF23-sale%2Bis%2Bon_XW4BQFBDQFEV");
		Thread.sleep(2000);
		driver.close();
		
	}

}
