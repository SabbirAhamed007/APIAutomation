package restassuredProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Request1 {
	
	
	//validate the header and API key is involve
	
	@Test
	void googleMapTest()
	
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
	    
	    
	    //validating header
	    
	    String contentType=response.header("Content-Type");  //capture details of Content-Type header
	    System.out.println("Content Type is:"+contentType);
	    Assert.assertEquals(contentType, "application/xml; charset=UFT-8");
	    
	    
	    String contentEncoding=response.header("Content-Encoding");  //capture details of Content-Encoding header
	    System.out.println("Content encoding value is:"+contentEncoding);
	    Assert.assertEquals(contentEncoding, "gzip");
	    
	    
	    //like these we can verify all the header content
	    
		
		
		
	}
	
	

}
