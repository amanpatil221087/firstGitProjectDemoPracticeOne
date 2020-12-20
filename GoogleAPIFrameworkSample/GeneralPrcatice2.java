package API_Automation.GoogleAPIFrameworkSample;

import java.util.ArrayList;
import java.util.List;

import getGoogleAPI_POJO.LocationLangLatt;
import getGoogleAPI_POJO.getAPIBody;
import io.restassured.RestAssured;

public class GeneralPrcatice2 {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
 		List<String> lists=new ArrayList<String>();
 		lists.add("Volvo");
 		lists.add("Saab");

 		
 		LocationLangLatt l=new LocationLangLatt();
 		 l.setLat("-38.383494");
 		 l.setLng("33.427362");
 		 
 		List<String> typeList=new ArrayList<String>();
 		 typeList.add("shoe park");
 		 typeList.add("shop");
 	 
 		 getAPIBody apiBody=new getAPIBody();
 		 apiBody.setAccuracy("50");
 		 apiBody.setName("Frontline house");
 		 apiBody.setPhone_number("(+91) 983 893 3937");
 		 apiBody.setAddress("29, side layout, cohen 09");
 		 apiBody.setWebsite("http://google.com");
 		 apiBody.setLanguage("French-IN");
 		 apiBody.setLocation(l); 
 		 apiBody.setTypes(typeList);
 		
 		
 String postLocRS= RestAssured.given().formParam("cars", lists).
		 header("Content-Type","application/json").
			body(apiBody).log().all().
			when().
			post("/maps/api/place/add/json").then().log().all().extract().response().asString();
	}

}
