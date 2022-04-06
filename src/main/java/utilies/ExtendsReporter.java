package utilies;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendsReporter {
	static ExtentReports extentReports;
	public static ExtentReports getExtendReports() {
		
		//for create Extends report we need call ExtendSparksReporter
		
		
		File file = new File("C:\\Users\\Sagar K\\eclipse-workspace\\Mark21_liveProject1\\Extendreport\\extends.html");
		ExtentSparkReporter reporter = new ExtentSparkReporter(file);
		reporter.config().setReportName("Tutorial nija automation ");
		reporter.config().setDocumentTitle("Test Result");
		
		 extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Operting System", "Windows 10");
		extentReports.setSystemInfo("tested by", "Sagar sonwalkar");

		return extentReports;
		
		
		
	}

}
