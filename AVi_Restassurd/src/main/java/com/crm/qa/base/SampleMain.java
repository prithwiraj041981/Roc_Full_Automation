package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SampleMain {

	public static Properties prop;
	public static String filePath; 
			 
		public SampleMain(){
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
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		JSONParser jsonparser = new JSONParser();
		
		FileReader reader = new FileReader(".\\src\\main\\java\\com\\crm\\qa\\testdata\\HCS_Sample.json");
		
		Object obj = jsonparser.parse(reader);
		
		JSONObject jsonobject = (JSONObject)obj;
		
		//return jsonobject;
		System.out.println(jsonobject.get("userId"));
		System.out.println(jsonobject.get("morConfigurations"));
	}

}
