package service.testing.poc;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.junit.Test;

public class ManageSubjectsTest {
		
	@Test
	public void get_subject_by_param() {
		
		baseURI = "http://localhost:3000/";	
		
		given().
		param("name", "Maths").
		get("/subjects").then().
		statusCode(200).
		log().all();
	}
}
