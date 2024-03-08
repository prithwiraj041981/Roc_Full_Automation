package com.crm.qa.api.tests;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.crm.qa.base.APIBase;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class DeleteUsers extends APIBase{
	
	@Test
	public void test02_delete() throws ParseException {
		
	
		
		 APIBase.DeleteCall();

			 
	}

}
