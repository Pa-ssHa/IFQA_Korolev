package ifellow.steps.logout;

import com.fasterxml.jackson.databind.ObjectMapper;
import ifellow.api.LogoutClient;
import ifellow.utils.LoadProperties;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static ifellow.utils.ConstantHeaders.getTokenHeaders;
import static ifellow.utils.LoadProperties.getProperties;

public class LogoutSteps {
    private static final String URL = LoadProperties.getProperties().getProperty("base.api.url");
    private static final File CREDENTIALS_FILE_TOKEN = new File("src/test/resources/credentialsWithToken.json");
    private static final String USER_NOT_FOUND = getProperties().getProperty("auth.error.not.found");
    private static final String SUCCESS_LOGOUT = getProperties().getProperty("auth.success.logout");
    private final LogoutClient logoutClient = new LogoutClient();
    private final ObjectMapper mapper = new ObjectMapper();
    private Response response;

    @Когда("отправляю запрос выхода с некорректным токеном")
    public void logoutWithInvalidToken() {
        response = logoutClient.logout(URL + "/logout", getTokenHeaders(UUID.randomUUID().toString()));
    }

    @Когда("отправляю запрос выхода с корректным токеном")
    public void logoutWithValidToken() throws IOException {
        String token = mapper.readTree(CREDENTIALS_FILE_TOKEN).get("token").asText();
        response = logoutClient.logout(URL + "/logout", getTokenHeaders(token));
    }

    @Тогда("статус ответа выхода равен {int}")
    public void checkStatusCode(int expectedStatus) {
        Assertions.assertEquals(expectedStatus, response.getStatusCode(), "Статус ответа не совпадает");
    }

    @И("текст ответа выхода равен {string}")
    public void checkResponseText(String expectedText) {
        Assertions.assertEquals(expectedText, response.asString().trim(), "Текст ответа не совпадает");
    }
}
