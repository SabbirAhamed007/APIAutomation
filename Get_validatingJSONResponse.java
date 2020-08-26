package restassuredProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_validatingJSONResponse {
	
	
	
	@Test
	
	public void GetWeatherDetails()
	
	
	
	{
		
		//Specify base URI
		
		
				RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
				
				//Request object
				
				RequestSpecification httprequest=RestAssured.given();
				
				//Response object
				Response response=httprequest.request(Method.GET,"/Newjersey");
				
				//print response in console  window
				
			    String responseBody=response.getBody().asString();	
			    System.out.println("Response Body is:" +responseBody);
			    
			    
			    Assert.assertEquals(responseBody.contains("Newjersey"), true);
		
		
		
	}
		

}
