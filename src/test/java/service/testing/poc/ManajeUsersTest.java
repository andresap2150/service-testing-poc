package service.testing.poc;

import org.junit.Test;

import static io.restassured.RestAssured.*;

public class ManajeUsersTest {
	@Test
	public void Get_test() {
		baseURI = "http://localhost:3000/";
		given()
		.get("/users/").then()
		.statusCode(404)
		.log().all();
	}

}
