//package ifellow;
//
//import ifellow.api.AuthorizationClient;
//import ifellow.service.AuthorizationTokenService;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.Test;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Map;
//
//import static ifellow.utils.ConstantHeaders.getJsonHeaders;
//import static ifellow.utils.LoadProperties.getProperties;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class AuthorizationTest {
//    private static final File CREDENTIALS_FILE = new File("src/test/resources/credentials.json");
//    private static final String URL = getProperties().getProperty("base.api.url");
//    private static final String USER_NOT_FOUND = getProperties().getProperty("auth.error.not.found");
//    private static final String PASSWORD_WRONG = getProperties().getProperty("auth.error.password.wrong");
//    private final AuthorizationTokenService tokenService = new AuthorizationTokenService();
//    private final AuthorizationClient authorizationClient = new AuthorizationClient();
//    private final Map<String, String> headersJson = getJsonHeaders();
//
//    @Test
//    public void testAuthorizationChangeName() throws IOException {
//        Response responseAuthorization = authorizationClient.authorizeChangeName(CREDENTIALS_FILE, URL + "/login", "changeName", headersJson);
//
//        assertEquals(responseAuthorization.asString().trim(), USER_NOT_FOUND, "Ответ совпадает");
//        assertEquals(responseAuthorization.getStatusCode(), 401, "Статус совпадает");
//    }
//
//    @Test
//    public void testAuthorizationChangePassword() throws IOException {
//        Response responseAuthorization = authorizationClient.authorizeChangePassword(CREDENTIALS_FILE, URL + "/login", "changePassword", headersJson);
//
//        assertEquals(responseAuthorization.asString().trim(), PASSWORD_WRONG, "Ответ совпадает");
//        assertEquals(responseAuthorization.getStatusCode(), 401, "Статус совпадает");
//    }
//
//    @Test
//    public void testAuthorizationSuccess() throws IOException {
//        Response responseAuthorization = authorizationClient.authorize(CREDENTIALS_FILE, URL + "/login", headersJson);
//
//        assertEquals(responseAuthorization.getStatusCode(), 200, "Статус совпадает");
//        assertTrue(responseAuthorization.asString().contains("token"), "Токен получен");
//
//        tokenService.saveTokenNewFile(CREDENTIALS_FILE, responseAuthorization);
//    }
//}
