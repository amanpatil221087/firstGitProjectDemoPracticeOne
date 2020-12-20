package API_Automation.GoogleAPIFrameworkSample;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.List;

import getGoogleAPI_POJO.LocationLangLatt;
import getGoogleAPI_POJO.getAPIBody;
import getGoogleAPI_POJO.postLocationResponse;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SecondTest {
	public static void main(String[] args) throws FileNotFoundException {
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		LocationLangLatt l = new LocationLangLatt();
		l.setLat("-38.383494");
		l.setLng("33.427362");

		List<String> typeList = new ArrayList<String>();
		typeList.add("shoe park");
		typeList.add("shop");
		getAPIBody apiBody = new getAPIBody();
		apiBody.setAccuracy("50");
		apiBody.setName("Frontline house");
		apiBody.setPhone_number("(+91) 983 893 3937");
		apiBody.setAddress("29, side layout, cohen 09");
		apiBody.setWebsite("http://google.com");
		apiBody.setLanguage("French-IN");
		apiBody.setLocation(l);
		apiBody.setTypes(typeList);

	 

		PrintStream streamIlog = new PrintStream("F:\\Projects JavaSelenium\\GoogleAPIFrameworkSample\\TestLogs\\requestFIle.log");
		//PrintStream streamOlog = new PrintStream("F:\\Projects JavaSelenium\\GoogleAPIFrameworkSample\\TestLogs\\responseFIle.log");
//Request
		RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).setBody(apiBody)
				.addFilter(RequestLoggingFilter.logRequestTo(streamIlog)).
				addFilter(ResponseLoggingFilter.logResponseTo(streamIlog)).build();
//Reponse
		ResponseSpecification resSpec=new ResponseSpecBuilder().expectContentType(ContentType.JSON).
				expectStatusCode(200).build();
		
//Hitting The Rquest
		postLocationResponse postLocRS = 
				given().spec(reqSpec).when().post("/maps/api/place/add/json")
				.then().spec(resSpec).extract().response().as(postLocationResponse.class);

		System.out.println(postLocRS.getPlace_id() + " ***********");

		
		streamIlog.append("****************************************-------------------////+&%");
		
 
	}
}
