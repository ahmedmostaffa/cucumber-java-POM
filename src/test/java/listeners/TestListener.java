package listeners;


import org.testng.ITestListener;
import org.testng.ITestResult;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import tests.BaseTest;





public class TestListener  extends BaseTest implements  ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		Shutterbug.shootPage(driver).save();;
		//log.info("take screenshot for failed tests");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

}
