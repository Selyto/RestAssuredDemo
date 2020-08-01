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

public class TestUser {
	
	String userID = "";
	
	@BeforeTest()
	public void getBaseURI() {
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
	}
	
	@Test(dataProvider = "userlist") // dataprovider way for creating and validating user creation
	public void createuser(String name, String job, String validate) {
		RequestSpecification request = RestAssured.given();
		Response resp = request
				.body(buildUserBody(name, job))
				.post("/api/users")
				;
		
		System.out.println( resp.getBody().toString());
		
		if( resp.getStatusCode() ==  201 ) {
			userID = "2";
			System.out.println( "PASS");
		}
		
		
		if( validate.equalsIgnoreCase("True")) {
			resp = request
					.get("/api/users/" + userID)
					;
			
			if( resp.jsonPath().getString("data.first_name").equalsIgnoreCase(name)) {
				System.out.println(" Data Validation Succssful");
			}
		}
	}
	
		
	@DataProvider(name="userlist")
	public String[][] getUsers(){
		String[][] userslist = {
									{"John","Tester","True" },
									//{"","","False"},
									//{"","Tester","False"}
								};
		return userslist;
	}
	
	public String buildUserBody(String name, String job) {
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", name); 
		requestParams.put("job",job);
		
		return requestParams.toJSONString();
	}
}
