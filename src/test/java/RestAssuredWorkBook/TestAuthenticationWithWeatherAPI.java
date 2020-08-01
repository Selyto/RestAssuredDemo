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

public class TestAuthenticationWithWeatherAPI {
	
	String userID = "";
	
	@BeforeTest()
	public void getBaseURI() {
		RestAssured.baseURI = "https://community-open-weather-map.p.rapidapi.com/weather";
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
	}
	
	@Test
	public void getWeatherWithAuthentication() {
		RequestSpecification request = RestAssured.given();
		Response resp = request
				.header("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
				.header("x-rapidapi-key", "24fc3e5b1fmsh02c0a7993b9ea4dp12908djsn962cf53ec33b")
				//.auth().oauth2("24fc3e5b1fmsh02c0a7993b9ea4dp12908djsn962cf53ec33")
				.queryParam("q","London,uk")
				.get()
				;
	
		System.out.println(  resp.asString() );
		
	}
		
}