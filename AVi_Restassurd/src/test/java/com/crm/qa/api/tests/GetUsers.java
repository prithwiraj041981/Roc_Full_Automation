package com.crm.qa.api.tests;

import com.crm.qa.base.APIBase;
import org.testng.annotations.Test;

public class GetUsers extends APIBase{
	
	@Test
	public void test01_getalluser() {
		
		//Validatable<ValidatableResponse, Response> response = TestBase.GetCall();
		
//		Assert.assertEquals(200, response.statusCode());
//	    String resBody = response.getBody().toString();
//	    Assert.assertTrue(resBody.contains("michael"));
		
	    APIBase.GetCall()
	    .then()
		.statusCode(200)//body("firstname[1]", containsString("David"))
		.log().all();
	 
	    
	    
		
	}
	
}
