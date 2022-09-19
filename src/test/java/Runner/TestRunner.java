package Runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Listeners;


import io.cucumber.testng.CucumberOptions;
import listeners.TestListener;
import listeners.TransformAnno;

import tests.BaseApiTest;
import tests.BaseTest;

//@Listeners({TestListener.class,TransformAnno.class})


@CucumberOptions(features="src/test/java/features"
	,glue={"stepDefinitions"}
	,monochrome=true
	,plugin={"json:target/cucumber.json"}
	,tags= "@login or @register"
	,publish=true
)


public class TestRunner extends BaseTest {

}
