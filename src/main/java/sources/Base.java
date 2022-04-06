package sources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver;
	public Properties p;
	
	public WebDriver initilizationDriver() throws IOException {
		
		String path=System.getProperty("user.dir")+"//src//main//java//sources//Data.properties";	
		FileInputStream fis= new FileInputStream(path);
	
		 p = new Properties();
		p.load(fis);
		String driverName= p.getProperty("Browser");
		
		
		if(driverName.equalsIgnoreCase("firebox")) {
		WebDriverManager.firefoxdriver().setup();
		 driver= new FirefoxDriver();
	}else if(driverName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver(); 
		
		
	}else if (driverName.equalsIgnoreCase("IE")) {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}
	
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		return driver;
	}
public String takeScreenshot(String testName,WebDriver driver) throws IOException {
		
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileHandler.copy(SourceFile,new File(destinationFilePath));
		return destinationFilePath;

}}
