package com.petstore;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Petstore_Test2 extends Base_Class{
	
  @Test
  public void placeOrder() {
	  
	  String payload = "{\n"
	  		+ "  \"id\": 0,\n"
	  		+ "  \"petId\": 0,\n"
	  		+ "  \"quantity\": 0,\n"
	  		+ "  \"shipDate\": \"2023-03-10T06:04:47.262Z\",\n"
	  		+ "  \"status\": \"placed\",\n"
	  		+ "  \"complete\": true\n"
	  		+ "}";
	  
	  given().contentType(ContentType.JSON).body(payload).log().all().when().
	  post("/v2/store/order").then().log().all().assertThat().statusCode(200).
	  body("status",equalTo("placed")).header("Content-Type", "application/json");
  }
  
  @Test
  public void findById() {
	  given().contentType(ContentType.JSON).when().
	  get("/v2/store/order/1").then().log().all().assertThat().statusCode(200).
	  body("status",equalTo("placed")).header("Content-Type", "application/json");  
  }
  
  @Test
  public void findByStatus() {
	  given().contentType(ContentType.JSON).when().
	  get("/v2/store/inventory").then().log().all().assertThat().statusCode(200).
	  body("$", hasKey("sold")).body("$", hasKey("available")).header("Content-Type", "application/json");  
  }
}
