package elis.api.automation;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.qa.base.APIBase;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;

public class createToken extends APIBase {
	
	static String b_token ;
	
	
	@Test
	public static String create_Token() throws ParseException {
		
		Response res = APIBase.PostCall_ELISBearToken();
		Assert.assertEquals(res.statusCode(), 200);
		System.out.println(res.toString());
		
		JsonPath jsonPathEvaluator = res.jsonPath();
		 b_token = jsonPathEvaluator.get("access_token");
		System.out.println("Bearer Token  " + b_token);
		return b_token;
	}
	
	
	
}
