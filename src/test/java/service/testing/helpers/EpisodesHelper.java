package service.testing.helpers;

import io.restassured.response.Response;
import service.testing.data.Constants;

import static io.restassured.RestAssured.given;

public class EpisodesHelper {
    public Response get_a_episode(int id){
        return given()
                .pathParam("id",id)
                .when()
                .get(Constants.EPISODES_ENDPOINT+"/{id}");
    }
}
