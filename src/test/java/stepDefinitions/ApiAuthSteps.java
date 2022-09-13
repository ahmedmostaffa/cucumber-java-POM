package stepDefinitions;

import static org.hamcrest.Matchers.*;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

import utilities.JsonReader;

public class ApiAuthSteps {
    RequestSpecification response;

    @Given("request body is set to be {int}")
    public void request_body_is_set_to_be(Integer index) {
        RestAssured.baseURI="https://simple-books-api.glitch.me";
        response=RestAssured
                .given()
                .body(JsonReader.getJsonArray(".//resources//TestData//MOCK_DATA.json").toArray()[index].toString());
    }

    @When("user set request header from {string}")
    public void user_set_request_header_from(String string) {
        response.when().post(JsonReader.getValue(string ,"POST").toString());
    }

    @Then("status code should be {int}")
    public void status_code_should_be(Integer code) {
        response.then().statusCode(code);
    }

}
