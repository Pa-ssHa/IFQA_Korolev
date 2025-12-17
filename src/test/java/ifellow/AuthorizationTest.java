package ifellow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ifellow.utils.LoadProperties;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthorizationTest {

    private final ObjectMapper mapper = new ObjectMapper();
    private static final File CREDENTIALS_FILE = new File("src/test/resources/credentials.json");
    private static final String URL = LoadProperties.getProperties().getProperty("base.api.url");

    @Test
    public void testAuthorizationChangeName() throws IOException {

        JsonNode currentCredentials = mapper.readTree(CREDENTIALS_FILE);
        ObjectNode changeName = (ObjectNode) currentCredentials.deepCopy();
        changeName.put("username", "changeName");

        Response responseAuthorization = given()
                .header("Content-Type", "application/json")
                .body(changeName.toString())
                .when()
                .post(URL + "/login");


        assertEquals(responseAuthorization.asString().trim(), "not found", "Ответ совпадает");
        assertEquals(responseAuthorization.getStatusCode(), 401, "Статус совпадает");
    }

    @Test
    public void testAuthorizationChangePassword() throws IOException {

        JsonNode currentCredentials = mapper.readTree(CREDENTIALS_FILE);
        ObjectNode changePassword = (ObjectNode) currentCredentials.deepCopy();
        changePassword.put("password", "changePassword");

        Response responseAuthorization = given()
                .header("Content-Type", "application/json")
                .body(changePassword.toString())
                .when()
                .post(URL + "/login");


        assertEquals(responseAuthorization.asString().trim(), "not right pass", "Ответ совпадает");
        assertEquals(responseAuthorization.getStatusCode(), 401, "Статус совпадает");
    }

    @Test
    public void testAuthorizationSuccess() throws IOException {

        JsonNode currentCredentials = mapper.readTree(CREDENTIALS_FILE);
        ObjectNode successAuth = (ObjectNode) currentCredentials.deepCopy();

        Response responseAuthorization = given()
                .header("Content-Type", "application/json")
                .body(CREDENTIALS_FILE)
                .when()
                .post(URL + "/login");


        assertEquals(responseAuthorization.getStatusCode(), 200, "Статус совпадает");
        assertTrue(responseAuthorization.asString().contains("token"), "Токен получен");

        successAuth.put("token", responseAuthorization.asString()
                .substring(responseAuthorization.asString().indexOf("token : ") + 8));

        File fileCredentialsWithToken = new File("src/test/resources/credentialsWithToken.json");
        mapper.writerWithDefaultPrettyPrinter().writeValue(fileCredentialsWithToken, successAuth);
    }

}
