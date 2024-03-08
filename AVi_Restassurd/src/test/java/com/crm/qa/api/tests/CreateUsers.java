package com.crm.qa.api.tests;

import static org.hamcrest.Matchers.containsString;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.crm.qa.base.APIBase;

public class CreateUsers extends APIBase{
	
	@Test
	public void test02_post() throws ParseException {
		
		
		
		
		JSONObject jsonOBJ = APIBase.createJsonObject();
		 APIBase.PostCall(jsonOBJ)
		    .then()
			.statusCode(201)
			.log().all();
	}

}
