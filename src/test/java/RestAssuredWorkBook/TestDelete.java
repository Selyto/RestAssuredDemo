package RestAssuredWorkBook;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import static  io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class TestDelete {
	
	String userID = "";
	
	@BeforeTest()
	public void getBaseURI() {
		RestAssured.baseURI = "https://reqres.in";
		//RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
	}
	
	@Test() //Update and Patch
	public void deleteuser() {
		
		RequestSpecification request = RestAssured.given();

		
		//Update the existing user job
		Response resp = request
				.delete("/api/users/2")
				;
		 System.out.println( "After DeleteTestUpdatePUTPATCH.java " + resp.statusCode() );
		
	}

	
	public String buildUserBody(String name, String lastname) {
		JSONObject requestParams = new JSONObject();
		requestParams.put("first_name", name); 
		requestParams.put("last_name",lastname);
		
		return requestParams.toJSONString();
	}
}
