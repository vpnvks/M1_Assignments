package com.petstore;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeMethod;

public class Base_Class {
	
	@BeforeMethod
	public void base() {
	baseURI="https://petstore.swagger.io";	
	}
}
