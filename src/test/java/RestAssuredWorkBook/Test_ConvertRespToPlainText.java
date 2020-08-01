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
import io.restassured.parsing.Parser;

import static  io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class Test_ConvertRespToPlainText {
	
	String userID = "";
	
	
	
	 @Test
	    public void testMockMvcGetPlainText() {
		 
	      /// Response resp = new Response( "{ [1,2,3,4] }");
	    }
		
}