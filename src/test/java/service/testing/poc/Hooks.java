package service.testing.poc;

import org.junit.Before;
import org.junit.BeforeClass;
import service.testing.data.Constants;

import static io.restassured.RestAssured.baseURI;

public class Hooks {

    @BeforeClass
    public static void startCommons(){
        baseURI = Constants.BASE_URL;
    }
}
