package elis.api.automation;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.qa.base.APIBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class createHCS extends APIBase{
	

	static String hcs_Id ;
	 
	
	@Test
	public static String create_HCS_Id() throws ParseException {
		
	
		
//		Response res = APIBase.PostCall_ELISHCS_Id();
//		Assert.assertEquals(res.statusCode(), 200);
//		System.out.println(res.toString());
		
//		JsonPath jsonPathEvaluator = res.jsonPath();
//		 b_token = jsonPathEvaluator.get("access_token");
//		System.out.println("Bearer Token  " + b_token);
//		return b_token;
		
		
		
		return hcs_Id;
	}
	

}
