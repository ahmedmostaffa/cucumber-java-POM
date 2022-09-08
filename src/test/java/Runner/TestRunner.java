package Runner;



import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import listeners.TestListener;
import listeners.TransformAnno;

import tests.BaseApiTest;
import tests.BaseTest;

//@Listeners({TestListener.class,TransformAnno.class})

@CucumberOptions(features="src/test/java/features"
	,glue={"stepDefinitions"}
	,monochrome=true
	,plugin={"html:target/cucumber.html"}
	,tags= "@post"
	,publish=true
)


public class TestRunner extends BaseApiTest {
	
}
