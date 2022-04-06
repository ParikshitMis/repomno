package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import sources.Base;
import utilies.ExtendsReporter;

public class Listeners extends Base implements ITestListener {
	 public   WebDriver driver;
	 ExtentReports extentReport = ExtendsReporter.getExtendReports();
		ExtentTest extentTest;
		ThreadLocal<ExtentTest> extentTestThread= new ThreadLocal<>();
	@Override
	public void onTestStart(ITestResult result) {

		 extentTest = extentReport.createTest(result.getName());	
		 
		 
		 extentTestThread.set(extentTest);
	}
	

	@Override
	public void onTestSuccess(ITestResult result) {

		
		extentTestThread.get().info(result.getName()+" Got passed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {	

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}
	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTestThread.get().fail(result.getThrowable());
		
	    driver = null;
		
			String testMethodName = result.getName();
			
			try {
				driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				 String destinationPath = takeScreenshot(testMethodName,driver);
				 
				 extentTestThread.get().addScreenCaptureFromPath(destinationPath, testMethodName);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {


	}

	@Override
	public void onFinish(ITestContext context) {

		extentReport.flush();

	}

}
