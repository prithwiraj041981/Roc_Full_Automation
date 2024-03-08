package com.crm.qa.api.tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class Test03_Post {

	@Test
	public void test03_test() {
		
//		Map<String, Object> map = new HashMap<>();
//		map.put("name", "morpheus");
//		map.put("job", "leader");
//		
//		System.out.println(map);
		
		
		JSONObject req = new JSONObject();
		req.put("name", "morpheus");
		req.put("job", "leader");
		
		System.out.println(req);
		System.out.println(req.toJSONString());

		given().
			header("content-type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
		    body(req.toJSONString()).
		 when().
		 	post("https://reqres.in/api/users").
		 then().
		    statusCode(201);
		    
		    
	}
}
