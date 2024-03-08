package com.crm.qa.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class APIBase {
	
	public static Properties prop;
	public static String baseURI;
	public static String hcs_URL;
	public APIBase(){
		try {
			prop = new Properties();
			
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
					+ "/qa/config/config.properties");
			prop.load(ip);
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/******
	 * Method Name : RestAssured Get Call
	 * @author eiauvtd-Avijit Dutta
	 * @return Validatable response
	 */

		public static Validatable<ValidatableResponse,Response> GetCall() {
			
			baseURI = prop.getProperty("BASE_URI");
			String URL = baseURI + "/users";
			RequestSpecification httpRequest = RestAssured.given(); 
			// specify the method type (GET) and the parameters if any. 
			//In this case the request does not take any parameters 
			Response response = httpRequest.contentType(ContentType.JSON).get(URL);
			return response;	
			
		}

  /**}
   * @name: RestAssured Post Call
   * @author eiauvtd-Avijit Dutta
   * 
   */
	public static Validatable<ValidatableResponse,Response> PostCall(JSONObject jsonObj){
		
				
		baseURI = prop.getProperty("BASE_URI");
		String URL = baseURI + "/users";
		RequestSpecification httpRequest = RestAssured.given(); 
		Response response = httpRequest.contentType(ContentType.JSON).body(jsonObj.toJSONString()).post(URL);//jsonObj.toJSONString()
		return response;	
	}
	
	 /**}
	   * @name: RestAssured Post Call for ELIS to get the bear token
	   * @author eiauvtd-Avijit Dutta
	   * 
	   */
	
		public static Response PostCall_ELISBearToken(){
			
					
			baseURI = prop.getProperty("ELIS_URI_TOKEN");
			String URL = baseURI;
			RequestSpecification httpRequest = RestAssured.given(); 
			Response response = httpRequest.contentType(ContentType.URLENC)
					.header("Content-Type", "application/x-www-form-urlencoded")
					
					.formParam("grant_type", prop.get("grant_type"))
		            .formParam("client_secret", prop.get("client_secret"))
		            .formParam("client_id", prop.get("client_id"))
		            .formParam("Scope", prop.get("Scope")).when().post(URL);
			
			
			//jsonObj.toJSONString()
			return response;	
		}
	
		 /**}
		   * @name: RestAssured Post Call for ELIS to get the HCS id 
		   * @author eiauvtd-Avijit Dutta
		   * 
		   */
//		public static Response PostCall_ELISHCS_Id() {
//			
//			
//			
////			hcs_URL = prop.getProperty("ELIS_URI_HCS");
////			String URL = hcs_URL;
////			RequestSpecification httpRequest = RestAssured.given(); 
////			Response response = httpRequest.contentType(ContentType.JSON).header("Content-Type", "application/json")
////					.header("Authorization", "Bearer "+ token);
////		            ("Scope", prop.get("Scope")).when().post(URL);
////			return response;
//			
//		}
//	
	
	
	
	 /**}
	   * @name: RestAssured PUT Call
	   * @author eiauvtd-Avijit Dutta
	   * 
	   */
		public static Validatable<ValidatableResponse,Response> PUTCall(JSONObject jsonObj){
			
			
			baseURI = prop.getProperty("BASE_URI");
			String URL = baseURI + "/users/4";
			RequestSpecification httpRequest = RestAssured.given(); 
			Response response = httpRequest.contentType(ContentType.JSON).body(jsonObj).put(URL);
			return response;	
		}
	
		/**}
		   * @name: RestAssured Delete Call
		   * @author eiauvtd-Avijit Dutta
		   * 
		   */
			public static void DeleteCall(){
				baseURI = prop.getProperty("BASE_URI");
				String URL = baseURI + "/users/4";
							
				when().
				    delete(URL).
				   then().
				      statusCode(200).
				      log().all();
				      
					
			}
		
	/**
	 * @author eiauvtd - Avijit
	 * Create and return a JSON object
	 * @return
	 * @throws ParseException 
	 */
	public static JSONObject createJsonObject() throws ParseException {
		
		
//		
		JSONObject req = new JSONObject();
		req.put("firstname", "Kevin");
		req.put("lastname", "Ross");
		req.put("age", 35);
		req.put("book", "DS");
		
		System.out.println(req);
		System.out.println(req.toJSONString());
		
		return req;
	}
	
	/**
	 * Returning JSON object from JSON file
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject createJSONfromeFile() throws ParseException, IOException{
		
		JSONParser jsonparser = new JSONParser();
		
		FileReader reader = new FileReader(".\\src\\main\\java\\com\\crm\\qa\\testdata\\HCS_Sample.json");
		
		Object obj = jsonparser.parse(reader);
		
		JSONObject jsonobject = (JSONObject)obj;
		
		return jsonobject;
		
		
	}
	
	
	
	/**
	 * @author eiauvtd - Avijit
	 * Update and return a JSON object
	 * @return
	 * @throws ParseException 
	 */
	public static JSONObject updateJsonObject() throws ParseException {
		
		
//		
		JSONObject req = new JSONObject();
		req.put("firstname", "Mary");
		req.put("lastname", "Jane");
		req.put("age", 36);
		req.put("book", "DS");
		
		System.out.println(req);
		System.out.println(req.toJSONString());
		
		return req;
	}
}
