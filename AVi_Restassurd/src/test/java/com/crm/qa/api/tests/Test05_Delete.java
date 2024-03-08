package com.crm.qa.api.tests;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test05_Delete {

	@Test
	public void test05_delete() {
	
	 when().
	 	delete("https://reqres.in/api/users/2").
	 then().
	    statusCode(204).
	    log().all();
	}
}
