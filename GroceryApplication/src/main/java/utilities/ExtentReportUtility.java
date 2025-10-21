package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();// static instance of extentreports that can
	// be shared accross the application

	public synchronized static ExtentReports createExtentReports() {

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); // name of the
																										// folder and
																										// the format of
																										// the file
		reporter.config().setReportName("7RMartSupermarketProject");// name of the report
		extentReports.attachReporter(reporter);

		extentReports.setSystemInfo("Organization", "Obsqura");// setsysteminfo- to include additional info in the
																// report
		extentReports.setSystemInfo("Name", " Maria"); // provides context of the report
		return extentReports;
	}
}
