package service.testing.helpers;

import io.restassured.response.Response;
import service.testing.data.Constants;

import static io.restassured.RestAssured.given;

public class CharacterHelper {
    public Response get_a_character(int id){
        return given()
                .pathParam("id",id)
                .when()
                .get(Constants.CHARACTER_ENDPOINT +"/{id}");
    }
}
