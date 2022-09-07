package stepDefinitions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import tests.BaseApiTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class SignUpSteps extends BaseApiTest {
    public static RequestSpecification response;
    @Given("the base url is navigated")
    public void the_base_url_is_naviagted() {
        System.out.println("user is naviagted to base url");
        response=RestAssured.given();

    }

    @When("user enter header content type equals to {string}")
    public void user_enter_header_content_type_equals_to(String string) {
        response.header("Content-type","application/json");


    }

    @When("enter end point {string}")
    public void enter_end_point(String string) {
    	response.and().when().get(string);
    }

    @Then("the status code will be {int}")
    public void the_status_code_will_be(Integer statusCode) {
    	//response.expect().statusCode(statusCode);
    	response.then().statusCode(200);
    	
    
    }

    @Then("response time is less than {int}")
    public void reponse_time_is_less_than(Integer responseTime) {
        response.expect().time(lessThan((long) responseTime), TimeUnit.SECONDS);
    }

}
