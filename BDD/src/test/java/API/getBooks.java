package API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class getBooks {


    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;
    public static RequestSpecification request;
    public static ResponseSpecification response;

    @Given("user navigated to baseURL {string}")
    public void user_access_baseURL(String baseUrl) {
        requestSpec = new RequestSpecBuilder()
                                        .setBaseUri(baseUrl).build();
        request = RestAssured.given(requestSpec);

    }
    @When("user query list of books path {string}")
    public void user_query_list_of_books(String path) {
        request.when().get(path);
    }
    @Then("books list is displayed")
    public void books_list_is_displayed() {
        responseSpec= new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
        //response.
    }

}
