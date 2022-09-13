package runner;

import TestCases.BaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features"
        ,glue = {"runner","bddSteps"}
        ,plugin = {"pretty","html:target/cucumber.html"}
        ,tags="@function"
        ,monochrome = true)
public class TestRunner extends BaseTest {


}
