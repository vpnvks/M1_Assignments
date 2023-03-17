package com.petstore;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Petstore_Test3 extends Base_Class{
  
	@Test(priority=0)
  public void createUser() {
	String payload = "[\n"
			+ "  {\n"
			+ "    \"id\": 0,\n"
			+ "    \"username\": \"string\",\n"
			+ "    \"firstName\": \"string\",\n"
			+ "    \"lastName\": \"string\",\n"
			+ "    \"email\": \"string\",\n"
			+ "    \"password\": \"string\",\n"
			+ "    \"phone\": \"string\",\n"
			+ "    \"userStatus\": 0\n"
			+ "  }\n"
			+ "]";	
		
	given().contentType(ContentType.JSON).body(payload).log().all().when().
	post("/v2/user/createWithArray").then().log().all().assertThat().statusCode(200).
	body("message",equalTo("ok")).header("Content-Type", "application/json");
  }
	
	@Test(priority=1)
	public void getUserByName() {
		
	given().contentType(ContentType.JSON).when().
	get("/v2/user/string").then().log().all().assertThat().statusCode(200).
	body("username",equalTo("string")).header("Content-Type", "application/json");
	}
	
	@Test(priority=2)
	public void updateUser() {
	String payload = "{\n"
			+ "  \"id\": 0,\n"
			+ "  \"username\": \"string\",\n"
			+ "  \"firstName\": \"string\",\n"
			+ "  \"lastName\": \"string\",\n"
			+ "  \"email\": \"string\",\n"
			+ "  \"password\": \"string\",\n"
			+ "  \"phone\": \"string\",\n"
			+ "  \"userStatus\": 0\n"
			+ "}";
		
	given().contentType(ContentType.JSON).body(payload).log().all().when().
	put("/v2/user/string").then().log().all().assertThat().statusCode(200).
	body("$", hasKey("message")).header("Content-Type", "application/json");
	}
	
	@Test(priority=3)
	public void deleteUser() {
		
	given().contentType(ContentType.JSON).when().
	delete("/v2/user/string").then().log().all().assertThat().statusCode(200).
	body("message",equalTo("string")).header("Content-Type", "application/json");
	}
}
