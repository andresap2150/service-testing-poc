package service.testing.poc;

import org.junit.Before;
import org.junit.Test;
import service.testing.data.Constants;
import service.testing.helpers.EpisodesHelper;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class EpisodeTest {
    @Before
    public void startCommons(){
        baseURI = Constants.BASE_URL;
        basePath = Constants.BASE_PATH;
    }

    @Test
    public void get_first_episodes(){
        given()
                .get(Constants.EPISODES_ENDPOINT)
                .then()
                .statusCode(200);
    }

    @Test
    public void get_szechuan_sauce_episode(){
        EpisodesHelper eHelper = new EpisodesHelper();
        eHelper.get_a_episode(22).then().body("name", equalTo("The Rickshank Rickdemption"));
    }
}
