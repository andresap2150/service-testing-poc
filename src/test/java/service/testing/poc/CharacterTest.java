package service.testing.poc;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.junit.Test;
import service.testing.data.Constants;

public class CharacterTest {
		
	@Test
	public void get_first_characters() {
		
		baseURI = Constants.BASE_URL;
		
		given()
				.get("/character")
				.then()
				.statusCode(200)
				.log().all();
	}
}
