package tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.ConfigReader;
import utilities.JsonReader;

public class GET {
	
	// make post request authentication
	@Test
	public static String ApiAuthentication() {
		RestAssured.baseURI=ConfigReader.getStringProperty("baseURL");
		Response response = given()
	              .header("Content-type", "application/json")
	              .and()
	              .body(JsonReader.getJsonObject("TestData").toJSONString())
	              .when()
	              .post(JsonReader.getValue("Headers", "POST").toString())
	              .then()
	              .extract().response();
		String accessToken=response.jsonPath().getString("accessToken");
		return accessToken;
	}
	
	
	  

	
}
