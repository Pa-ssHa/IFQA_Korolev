package ifellow;

import com.fasterxml.jackson.databind.ObjectMapper;
import ifellow.utils.LoadProperties;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RegistrationTest {

    private static final String URL = LoadProperties.getProperties().getProperty("base.api.url");
    private static final File CREDENTIALS_FILE = new File("src/test/resources/credentials.json");

    @Test
    public void testRegistration() {

        ObjectMapper mapper = new ObjectMapper();

        Response responseRegistration = given()
                .header("Content-Type", "application/json")
                .body(CREDENTIALS_FILE)
                .when()
                .post(URL + "/register");

        Assertions.assertEquals(200, responseRegistration.statusCode(), "Статус совпадает");
    }
}
