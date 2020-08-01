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

public class TestResource {
	
	String userID = "";
	
	@BeforeTest()
	public void getBaseURI() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
	}
	
		
	@Test
	public void getResources() {
		RestAssured.baseURI = "https://reqres.in";
		Response resp = RestAssured.get("/api/unknown");
		
		//Get the value from an array JSON Object
		List<Map<String, String>> data = resp.jsonPath().getList("data");
		System.out.println( data.get(0).get("name"));
		
		//Get the value from an array JSON Object
		Map<String, String> company = resp.jsonPath().getMap("data[0]");
		System.out.println(company.get("name"));
		
		//Get the single attribute from a JSon Object
		String adcompany = resp.jsonPath().getString("ad.company");
		System.out.println( adcompany );
		
	}
	
	
	
}
