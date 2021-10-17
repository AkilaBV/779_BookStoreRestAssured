package _BookStoreRestAssured._BookStoreRestAssured;

import org.testng.annotations.Test;

import  io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;

public class JsonSchemaValidator {

	
	@Test
	public void testschema() {
		RestAssured.baseURI="https://bookstore.toolsqa.com/BookStore/v1/Books";
		Response response=RestAssured.given().when().get().then().log().body().extract().response();
		
	System.out.println(response.asString());
	
	//checking the schema of the json.
	given().get("https://bookstore.toolsqa.com/BookStore/v1/Books").then().assertThat().body(matchesJsonSchemaInClasspath("_BookStoreRestAssured/_BookStoreRestAssured/sample.json"));
		
	}
}
