package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeMethod;
import io.restassured.RestAssured;
import utilities.ConfigReader;

public class BaseApiTest extends AbstractTestNGCucumberTests {
	
	@BeforeMethod 
	public void setUp() {
		RestAssured.baseURI= ConfigReader.getStringProperty("baseURL");
	}

}
