package com.crm.qa.api.tests;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test04_PUT {
	
//	@Test
	public void test04_put() {
	JSONObject req = new JSONObject();
	req.put("name", "Avijit");
	req.put("job", "Teacher");
	
	System.out.println(req);
	System.out.println(req.toJSONString());

	given().
		header("content-type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
	    body(req.toJSONString()).
	 when().
	 	put("https://reqres.in/api/users/2").
	 then().
	    statusCode(200).
	    log().all();
	}
	
	@Test
	public void test05_patch() {
	JSONObject req = new JSONObject();
	req.put("name", "Avijit");
	req.put("job", "Teacher");
	
	System.out.println(req);
	System.out.println(req.toJSONString());

	given().
		header("content-type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
	    body(req.toJSONString()).
	 when().
	 	patch("https://reqres.in/api/users/2").
	 then().
	    statusCode(200).
	    log().all();
	}
}
