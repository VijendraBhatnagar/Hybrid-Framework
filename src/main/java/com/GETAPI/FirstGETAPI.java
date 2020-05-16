package com.GETAPI;

import static io.restassured.RestAssured.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class FirstGETAPI {
	
	@Test(priority=1)
	public void responseCode() {
	
	Response responce=get("https://reqres.in/api/users?page=2");
	int status_code=responce.getStatusCode();
	long responce_time=responce.getTime();
	
	System.out.println("Status_Code--->" + status_code);

	System.out.println("Responce_Time --->" + responce_time);
	
	Assert.assertEquals(status_code, 200);
	
	}
	
	@Test(priority=2)
	public void responceBodyData() {
		
	Response responce= get("https://reqres.in/api/users?page=2");
	String body_data=responce.asString();
	
	System.out.println("Body_Data--->" + body_data);
	
	}
	
}
