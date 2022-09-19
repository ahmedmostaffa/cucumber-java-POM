package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.ConfigReader;

public class ExtentReporterNG implements IReporter {

	private static final String OUTPUT_FOLDER = "test-output/";
	private static final String FILE_NAME = "ExtentReport.html";

	private ExtentReports extent;

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getFailedTests(), Status.FAIL);
				buildTestNodes(context.getSkippedTests(), Status.SKIP);
				buildTestNodes(context.getPassedTests(), Status.PASS);

			}
		}

		for (String s : Reporter.getOutput()) {
			extent.addTestRunnerOutput(s);
		}

		extent.flush();
		try {
			Desktop.getDesktop().browse(new File(OUTPUT_FOLDER + FILE_NAME).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void init() throws IOException {
		
		ExtentSparkReporter spark = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
		extent = new ExtentReports();
		extent.attachReporter(spark);
		spark.loadXMLConfig("extentconfig.xml");
		
		
		extent.attachReporter(spark);
		extent.setReportUsesManualConfiguration(true);
		extent.setSystemInfo("OS", "Windows");
	    extent.setSystemInfo("RunMode",ConfigReader.getStringProperty("RunMode"));
	    extent.setSystemInfo("Browser", "Chrome");
	    extent.setSystemInfo("Enable-headless", ConfigReader.getStringProperty("headless"));
	    extent.setSystemInfo(OUTPUT_FOLDER, FILE_NAME);
	    
	    
	}

	private void buildTestNodes(IResultMap tests, Status status) {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.createTest(result.getMethod().getMethodName());

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
				}

				test.getModel().setStartTime(getTime(result.getStartMillis()));
				test.getModel().setEndTime(getTime(result.getEndMillis()));
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}