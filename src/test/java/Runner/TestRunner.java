package Runner;



import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import listeners.TestListener;
import listeners.TransformAnno;

import tests.BaseTest;

//@Listeners({TestListener.class,TransformAnno.class})

@CucumberOptions(features="src/test/java/features"
	,glue={"stepDefinitions"}
	,monochrome=false
	,plugin={"html:target/cucumber.html"}
	,tags= "@smoke"
	,publish=true
)


public class TestRunner extends AbstractTestNGCucumberTests  {
	
}
