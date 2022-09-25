package tests;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.ConfigReader;
import utilities.JsonReader;

public class GET {
	
	// make post request authentication

	public static String ApiAuthentication() {
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("clientName","adafwfwdadjfwff");
		jsonObject.put("client","adafwfdadawjfwff@gdadmail.com");
		JSONObject jsonObject_1=new JSONObject();
		jsonObject.put("Content-type","application/json");


		RestAssured.baseURI=ConfigReader.getStringProperty("baseURL");
		Response response = given().headers(jsonObject_1)
	              .and()
	              .body(jsonObject.toJSONString())
	              .when()
	              .post("/api-clients/")
	              .then()
	              .extract().response();
		String accessToken=response.jsonPath().getString("accessToken");
		System.out.println(response.statusCode());
		return accessToken;
	}

	public static void main(String[] args) {
		System.out.println(ApiAuthentication());

	}


	

	  

	
}
