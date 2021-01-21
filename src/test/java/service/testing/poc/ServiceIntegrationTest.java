package service.testing.poc;

import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import service.testing.data.Constants;
import service.testing.helpers.CharacterHelper;
import service.testing.helpers.EpisodesHelper;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.core.IsEqual.equalTo;

public class ServiceIntegrationTest {
    @Before
    public void startCommons(){
        baseURI = Constants.BASE_URL;
        basePath = Constants.BASE_PATH;
    }

    @Test
    public void check_episodename_mrpoopy(){
        CharacterHelper chHelper = new CharacterHelper();
        EpisodesHelper epHelper = new EpisodesHelper();

        Response characterResponse = chHelper.get_a_character(244).then().statusCode(200).extract().response();
        String episodeUrl = characterResponse.path("episode[0]");

        int episodeID= Integer.valueOf(episodeUrl.split("/")[episodeUrl.split("/").length-1]);

        epHelper.get_a_episode(episodeID).then().body("name", equalTo("Total Rickall"));
    }


}
