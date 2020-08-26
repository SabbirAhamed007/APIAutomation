package restassuredProject;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Request {
	
	@Test
	void RegistrationSuccessful()
	
	{
		
	//Specify base URI
		
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		//Request object
		
		RequestSpecification httprequest=RestAssured.given();
		
		
		
		//Request payload or body along with post request
		
		JSONObject requestParams=new JSONObject();
		requestParams.put("FisrtName", "Sabbir");
		requestParams.put("LastName", "Ahamed");
		requestParams.put("UserName", "Sabbir");
		requestParams.put("Password", "Andew123");
		requestParams.put("Email", "sabbirahamedcs@gmail.com");
		
		httprequest.header("Content-Type", "application/json");
		
		httprequest.body(requestParams.toJSONString());
		
		//Response object
		Response response=httprequest.request(Method.POST,"/register");
		
		
		
		//print response in console  window
		
	    String responseBody=response.getBody().asString();	
	    System.out.println("Response Body is:" +responseBody);
	    
	    //status code validation
	    
	    int statusCode=response.getStatusCode();
	    System.out.println("status code is: "+statusCode);
	    Assert.assertEquals(statusCode, 201);
	    
	  //success code validation
	    
	    String successCode=response.jsonPath().get("SuccessCode");
	    Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	    
	    
		
		
	}
	

}
