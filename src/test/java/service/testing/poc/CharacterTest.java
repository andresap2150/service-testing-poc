package service.testing.poc;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import service.testing.data.Constants;
import service.testing.helpers.CharacterHelper;

public class CharacterTest {
	@Before
	public void startCommons(){
		baseURI = Constants.BASE_URL;
		basePath = Constants.BASE_PATH;
	}
		
	@Test
	public void get_first_characters() {
		given()
				.get(Constants.CHARACTER_ENDPOINT)
				.then()
				.statusCode(200)
				.log().all();
	}


	@Test
	public void get_second_twenty_characters(){
		given()
				.param("page","2")
				.get(Constants.CHARACTER_ENDPOINT)
				.then().body("results.size()", equalTo(20))
				.log().all();


	}

	@Test
	public void get_jerry(){
		CharacterHelper chHelper = new CharacterHelper();
		chHelper.get_a_character(5)
				.then()
				.body("name", equalTo("Jerry Smith"))
				.log().all();
	}
}
