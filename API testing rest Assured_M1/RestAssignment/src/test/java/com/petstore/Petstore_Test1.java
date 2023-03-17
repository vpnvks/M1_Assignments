package com.petstore;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Petstore_Test1 extends Base_Class{
	String id1;
  	
  @Test(priority=0)
  public void findById() {
	 given().when().get("/v2/pet/1").then().log().all().assertThat().
	 statusCode(200).body("$", hasKey("name")).
	 header("Content-Type", "application/json");
  }
  
  @Test(priority=1)
  public void findByStatus() {
	given().when().get("/v2/pet/findByStatus?status=available").then().assertThat().
	statusCode(200).
	body("category.id[1]", equalTo(0)).
	header("Content-Type", "application/json");  
  }
  
  @Test(priority=2)
	public  void createPet_chaining() {
		
	Response resp=given().when().post("/v2/pet/2").then().
	statusCode(200).body("message",equalTo("2")).extract().response();
	JsonPath id = resp.jsonPath();
	id1 = id.getString("message");
	}
  
  @Test(priority=3)
	public void deletepet_chaining() {
	
	given().when().delete("/v2/pet/"+id1).
	then().log().all().assertThat().
	statusCode(200).
	body("message",equalTo("2"));
	}
  
  @Test(priority=4)
  public void updatePet() {
   String payload = "{\n"
   		+ "  \"id\": 0,\n"
   		+ "  \"category\": {\n"
   		+ "    \"id\": 0,\n"
   		+ "    \"name\": \"string\"\n"
   		+ "  },\n"
   		+ "  \"name\": \"doggie\",\n"
   		+ "  \"photoUrls\": [\n"
   		+ "    \"string\"\n"
   		+ "  ],\n"
   		+ "  \"tags\": [\n"
   		+ "    {\n"
   		+ "      \"id\": 0,\n"
   		+ "      \"name\": \"string\"\n"
   		+ "    }\n"
   		+ "  ],\n"
   		+ "  \"status\": \"available\"\n"
   		+ "}";
   given().contentType(ContentType.JSON).body(payload).log().all().when().
   post("/v2/pet").then().log().all().assertThat().statusCode(200).
   body("name",equalTo("doggie")).header("Content-Type", "application/json");
  }
  
  @Test(priority=5)
  public void Put_serialisation() {
	  
	  Customer customer = new Customer();
	  Tag tag = new Tag();
	  Category category = new Category();
	  List<Tag> taglist = new ArrayList<>();
	  List<String> urllink = new ArrayList<>();
	  
	  tag.setId(0);
	  tag.setName("string");
	  taglist.add(tag);
	  
	  category.setId(0);
	  category.setName("string");
	  
	  urllink.add("string");
	  
	  customer.setId(0);
	  customer.setName("doggie");
	  customer.setCategory(category);
	  customer.setTags(taglist);
	  customer.setStatus("available");
	  customer.setPhotoUrls(urllink);
	  
	  ObjectMapper map = new ObjectMapper();
	  
	  try {
		 String json = map.writeValueAsString(customer);
		 System.out.println("value of body is "+ json);
		 
		 given().contentType(ContentType.JSON).body(json).log().all().when().
		 post("/v2/pet").then().log().all().assertThat().statusCode(200).
		 body("name",equalTo("doggie")).header("Content-Type", "application/json");  
	} catch (JsonProcessingException e) {
		e.printStackTrace();
	}
	  
	  
  }
}
