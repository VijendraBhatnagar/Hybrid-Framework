package com.GETAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class POST_PUT_DELETE {
	
	
	@Test
	public void demo_post() {
		
		RequestSpecification request=RestAssured.given();
		
//		request.header("Content-Type","application/json");
//		
//		JSONObject json= new JSONObject();
//		json.put("id", 16);
//		json.put("title", "PUT_API_");
//		json.put("author", "Albert");
//		
//		request.body(json.toJSONString());
		
		Response response=request.delete("http://localhost:3000/posts/16");
		
		int code =response.getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
