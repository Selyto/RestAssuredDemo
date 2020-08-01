package RestAssuredWorkBook;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestResource_AltWay {
	
	String userID = "";
	
	@BeforeTest()
	public void getBaseURI() {
		RestAssured.baseURI = "https://reqres.in";
		//RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
	}
	
		
	
	
	@Test	
	public void getResourcesInAltWay() {
		RestAssured.baseURI = "https://reqres.in";
		
		RequestSpecification request = RestAssured.given();
		
		Response resp = request.get("/api/unknown");
		
		System.out.println( "Body : " + resp.getBody().asString() );
		
		System.out.println( "Status Code : " + resp.getStatusCode() );
		
		System.out.println( "Status Line : " + resp.getStatusLine() );
	}
	
	
}
