package Runner;



import org.testng.annotations.Listeners;

import io.cucumber.testng.CucumberOptions;
import listeners.TestListener;
import tests.BaseTest;
@Listeners(TestListener.class)
@CucumberOptions(features="src/test/java/features/Login.feature"
	,glue={"stepDefinitions"}
	,monochrome=true
	,plugin={"pretty","html:target/cucumber.html"},tags= "@smoke or @sanity "
	)
public class TestRunner extends BaseTest {
	
}
