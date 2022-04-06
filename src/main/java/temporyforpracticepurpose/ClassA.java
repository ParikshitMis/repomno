package temporyforpracticepurpose;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Sagar%20K/Desktop/Created%20web%20side/multipleselectionbox.html");

		WebElement dd = driver.findElement(By.id("1234"));
		
		Select select = new Select(dd);


		List<WebElement> option = select.getOptions();
		int a =option.size();

		for( int b= a-3;b<a;++b) {
			
			select.selectByIndex(b);
		}

		
		
	}

}
