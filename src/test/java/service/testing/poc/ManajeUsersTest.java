package service.testing.poc;

import org.json.simple.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import io.restassured.http.ContentType;
import service.testing.helpers.UsersHelper;

import static io.restassured.RestAssured.*;

public class ManajeUsersTest {
	@Ignore
	@Test
	public void get_all_users() {
		baseURI = "http://localhost:3000/";
		given()
		.get("/users/").then()
		.statusCode(200)
		.log().all();		
	}
	
	@Ignore
	@Test
	public void create_user() {
		baseURI="http://localhost:3000/";
		
		UsersHelper users = new UsersHelper();

		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		header("Content-Type", "application/json").
		body(users.generate_new_user("Andres", "Aparicio", 1)).
		when().
		post("/users").
		then().statusCode(201).
		log().all();
	}
	
	@Ignore
	@Test	
	public void parcial_user_update() {
		baseURI="http://localhost:3000/";
		//POST-1
		JSONObject request = new JSONObject();
		request.put("lastName", "Larrate");

		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		header("Content-Type", "application/json").
		body(request.toJSONString()).
		when().patch("/users/3").
		then().statusCode(200).
		log().all();
	}
	
	@Ignore
	@Test	
	public void update_user() {
		//if the user not exist it is created
		baseURI="http://localhost:3000/";

		UsersHelper users = new UsersHelper();

		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		header("Content-Type", "application/json").
		body(users.generate_new_user("Katy", "Garcia", 2)).
		when().
		put("/users/1").
		then().statusCode(200).
		log().all();
	}
	
	@Ignore
	@Test	
	public void delete_a_user() {
		baseURI="http://localhost:3000/";
		JSONObject request = new JSONObject();
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		header("Content-Type", "application/json").
		body(request.toJSONString()).
		when().delete("/users/4").
		then().statusCode(200).
		log().all();
	}
	
	@Test
	public void create_and_delete_a_user() {
		baseURI = "http://localhost:3000/";
		
		UsersHelper users = new UsersHelper();
		
		String newId = 
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		header("Content-Type", "application/json").
		body(users.generate_new_user("Emel", "Mora", 1)).
		when().
		post("/users").
		then().statusCode(201).extract().path("id").toString();
		
		System.out.println("se creo, pero se va a borrar:"+newId);
		
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		header("Content-Type", "application/json").
		when().delete("/users/"+newId).
		then().statusCode(200).
		log().all();
	}

}
