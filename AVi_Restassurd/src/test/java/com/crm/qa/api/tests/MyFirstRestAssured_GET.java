package com.crm.qa.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

//import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class MyFirstRestAssured_GET {
	String baseURI ="https://reqres.in/";
	@Test
	void test01_get() {
		
		
		String fullURI = baseURI + "api/users?page=2";
		Response response = get(fullURI);
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
	
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
			
		
	}
	@Test
	void test_02() {
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200).body("data.email[0]", containsString("michael"));
		
		
	}
}