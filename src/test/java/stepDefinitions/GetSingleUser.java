package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.JsonReader;

public class GetSingleUser  {
	 RequestSpecification response;
@Given("base URL is set to from {string}")
public void base_url_is_set_to_from(String string) {
	RestAssured.baseURI="https://reqres.in/api";
	
}

@Given("request header is set from {string} json file")
public void request_header_is_set_from_json_file(String string) {
   response=RestAssured.
           given().accept(ContentType.JSON);
    
}

@When("request method is set to GET")
public void request_method_is_set_to_get() {
    response.when().get(JsonReader.getValue(".//resources//TestData//Headers.json","GET_LIST_OF_USERS").toString());
}

@Then("the response status code is {int}")
public void the_response_status_code_is(Integer code) {
   response.then().statusCode(code);

	
}

@Then("the response body have id equals to {int}")
public void the_response_body_have_id_equals_to(Integer int1) {
    response.then().body("data",arrayWithSize(5));
}

}
