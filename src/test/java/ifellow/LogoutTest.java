package ifellow;

import com.fasterxml.jackson.databind.ObjectMapper;
import ifellow.utils.LoadProperties;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutTest {

    private final ObjectMapper mapper = new ObjectMapper();
    private static final File CREDENTIALS_FILE_TOKEN = new File("src/test/resources/credentialsWithToken.json");
    private static final String URL = LoadProperties.getProperties().getProperty("base.api.url");

    @Test
    public void testLogoutUnsuccessful() {

        Response responseLogout = given()
                .header("Authorization", UUID.randomUUID().toString())
                .when()
                .get(URL + "/logout");

        assertEquals(responseLogout.asString().trim(), "not found", "Ответ совпадает");
        assertEquals(responseLogout.getStatusCode(), 401, "Статус совпадает");
    }

    @Test
    public void testLogoutSuccessful() throws IOException {

        String token = mapper.readTree(CREDENTIALS_FILE_TOKEN).get("token").asText();

        Response responseLogout = given()
                .header("Authorization", token)
                .when()
                .get(URL + "/logout");

        assertEquals(responseLogout.asString().trim(), "success logout", "Ответ совпадает");
        assertEquals(responseLogout.getStatusCode(), 200, "Статус совпадает");
    }
}
