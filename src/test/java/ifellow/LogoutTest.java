//package ifellow;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import ifellow.api.LogoutClient;
//import ifellow.utils.LoadProperties;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.Test;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.UUID;
//
//import static ifellow.utils.ConstantHeaders.getTokenHeaders;
//import static ifellow.utils.LoadProperties.getProperties;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class LogoutTest {
//    private final ObjectMapper mapper = new ObjectMapper();
//    private static final File CREDENTIALS_FILE_TOKEN = new File("src/test/resources/credentialsWithToken.json");
//    private static final String URL = LoadProperties.getProperties().getProperty("base.api.url");
//    private final LogoutClient logoutClient = new LogoutClient();
//    private static final String USER_NOT_FOUND = getProperties().getProperty("auth.error.not.found");
//    private static final String SUCCESS_LOGOUT = getProperties().getProperty("auth.success.logout");
//
//    @Test
//    public void testLogoutUnsuccessful() {
//        Response responseLogout = logoutClient.logout(URL + "/logout", getTokenHeaders(UUID.randomUUID().toString()));
//
//        assertEquals(responseLogout.asString().trim(), USER_NOT_FOUND, "Ответ совпадает");
//        assertEquals(responseLogout.getStatusCode(), 401, "Статус совпадает");
//    }
//
//    @Test
//    public void testLogoutSuccessful() throws IOException {
//        String token = mapper.readTree(CREDENTIALS_FILE_TOKEN).get("token").asText();
//        Response responseLogout = logoutClient.logout(URL + "/logout", getTokenHeaders(token));
//
//        assertEquals(responseLogout.asString().trim(), SUCCESS_LOGOUT, "Ответ совпадает");
//        assertEquals(responseLogout.getStatusCode(), 200, "Статус совпадает");
//    }
//}
