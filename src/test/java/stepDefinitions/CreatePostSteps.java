package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import tests.BaseApiTest;
import utilities.JsonReader;
import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.RestAssured.given;

public class CreatePostSteps extends BaseApiTest {
    RequestSpecification response;
    @Given("base URL is set from")
    public void baseURLIsSetFrom() {
        response=RestAssured.given().when();
    }

    @And("request header set to value from")
    public void requestHeaderSetToValueFrom() {
        response.post(JsonReader.getValue("Headers","POST").toString());
        
    }

    @When("request body is set to be {string}")
    public void requestBodyIsSetToBe(String arg0) {
        response.body(JsonReader.getJsonObject(arg0).toJSONString());
    }

    @Then("response status code should be {int}")
    public void responseStatusCodeShouldBe(int arg0) {
        
       
      
            
    }
}
