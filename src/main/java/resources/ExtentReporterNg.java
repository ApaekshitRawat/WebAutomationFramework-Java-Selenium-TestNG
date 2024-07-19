package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNg {
	
	public static ExtentReports getReportObject() {
		
		String pathString = System.getProperty("user.dir")+"//reports//report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(pathString);
		
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTheme(Theme.DARK);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Apaekshit Rawat");
		extent.setSystemInfo("Framework Creater", "Apaekshit Rawat");
		return extent;
		
	}
}
