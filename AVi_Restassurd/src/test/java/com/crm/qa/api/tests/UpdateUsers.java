package com.crm.qa.api.tests;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.crm.qa.base.APIBase;

public class UpdateUsers extends APIBase{
	
	@Test
	public void test02_put() throws ParseException {
		
		
		
		
		JSONObject jsonOBJ = APIBase.updateJsonObject();
		 APIBase.PUTCall(jsonOBJ)
		    .then()
			.statusCode(200)
			.log().all();
	}

}

