package Runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;


import io.cucumber.testng.CucumberOptions;
import listeners.TestListener;
import listeners.TransformAnno;

import tests.BaseApiTest;
import tests.BaseTest;

//@Listeners({TestListener.class,TransformAnno.class})


@CucumberOptions(features="src/test/java/features"
	,glue={"stepDefinitions","hooks"}
	,monochrome=true
	,plugin={"json:target/cucumber.json"
		,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	,tags= "@login"
	,publish=true
)


public class TestRunner extends BaseTest {
	@DataProvider(parallel = false)
	@Override
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
