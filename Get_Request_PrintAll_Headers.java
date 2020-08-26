package restassuredProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Request_PrintAll_Headers {
	
	@Test
	
	public void GetWeatherDetails()
	
	
	
	{
		
		//Specify base URI
		
		
				RestAssured.baseURI="http://maps.googleapis.com";
				
				//Request object
				
				RequestSpecification httprequest=RestAssured.given();
				
				//Response object
				Response response=httprequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AlzaSyBjGBCE3VpU4dd53j5n5JJHKJJJ");
				
				//print response in console  window
				
			    String responseBody=response.getBody().asString();	
			    System.out.println("Response Body is:" +responseBody);
			    
			    
			    Headers allheaders=response.headers();  //capture all the headers from response
			    
			    for(Header header:allheaders)
			    {
			    	
			    	System.out.println(header.getName()+"  "+header.getValue());
			  
			    	
			    }
		
		
		
	}
	

}
