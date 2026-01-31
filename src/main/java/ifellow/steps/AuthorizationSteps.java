package ifellow.steps;

import ifellow.api.AuthorizationClient;
import ifellow.service.AuthorizationTokenService;
import ifellow.utils.LoadProperties;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static ifellow.utils.ConstantHeaders.getJsonHeaders;

public class AuthorizationSteps {

    private static final File CREDENTIALS_FILE = new File("src/test/resources/credentials.json");
    private static final String URL = LoadProperties.getProperties().getProperty("base.api.url");
    private static final String USER_NOT_FOUND = LoadProperties.getProperties().getProperty("auth.error.not.found");
    private static final String PASSWORD_WRONG = LoadProperties.getProperties().getProperty("auth.error.password.wrong");

    private final AuthorizationClient authorizationClient = new AuthorizationClient();
    private final AuthorizationTokenService tokenService = new AuthorizationTokenService();
    private final Map<String, String> headersJson = getJsonHeaders();

    private Response response;

    @Когда("отправляю запрос авторизации с изменённым именем пользователя")
    public void authorizeWithWrongUsername() throws IOException {
        response = authorizationClient.authorizeChangeName(CREDENTIALS_FILE, URL + "/login", "changeName", headersJson);
    }

    @Когда("отправляю запрос авторизации с неверным паролем")
    public void authorizeWithWrongPassword() throws IOException {
        response = authorizationClient.authorizeChangePassword(CREDENTIALS_FILE, URL + "/login", "changePassword", headersJson);
    }

    @Когда("отправляю запрос авторизации с корректными данными")
    public void authorizeSuccessfully() {
        response = authorizationClient.authorize(CREDENTIALS_FILE, URL + "/login", headersJson);
    }

    @Тогда("статус полученного ответа равен {int}")
    public void checkStatusCode(int expectedStatus) {
        Assertions.assertEquals(expectedStatus, response.getStatusCode(), "Статус ответа не совпадает");
    }

    @И("текст ответа равен {string}")
    public void checkResponseText(String expectedText) {
        Assertions.assertEquals(expectedText, response.asString().trim(), "Текст ответа не совпадает");
    }

    @И("в ответе присутствует токен")
    public void checkTokenExists() {
        Assertions.assertTrue(response.asString().contains("token"), "Токен отсутствует в ответе");
    }

    @И("токен сохраняется")
    public void saveToken() throws IOException {
        tokenService.saveTokenNewFile(CREDENTIALS_FILE, response);
    }
}
