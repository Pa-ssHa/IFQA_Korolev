package ifellow.steps;

import ifellow.api.AuthorizationClient;
import ifellow.service.AuthorizationTokenService;
import ifellow.utils.RequiredConfig;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static ifellow.utils.ConstantHeaders.getJsonHeaders;

public class AuthorizationSteps {
    private final RequiredConfig requiredConfig = new RequiredConfig();
    private final File CREDENTIALS_FILE = new File(requiredConfig.requireCredentialFile());
    private final String URL = requiredConfig.requireBaseApiUrl();
    private final String USER_NOT_FOUND = requiredConfig.requireNotFound();
    private final String PASSWORD_WRONG = requiredConfig.requirePasswordWrong();
    private final AuthorizationClient authorizationClient = new AuthorizationClient();
    private final AuthorizationTokenService tokenService = new AuthorizationTokenService();
    private final Map<String, String> headersJson = getJsonHeaders();
    private Response response;

    @Step("Отправить запрос авторизации с неверным именем")
    @Когда("отправляю запрос авторизации с изменённым именем пользователя")
    public void authorizeWithWrongUsername() throws IOException {
        response = authorizationClient.authorizeChangeName(CREDENTIALS_FILE, URL + "/login", "changeName", headersJson);
    }

    @Step("Отправить запрос авторизации с неверным паролем")
    @Когда("отправляю запрос авторизации с неверным паролем")
    public void authorizeWithWrongPassword() throws IOException {
        response = authorizationClient.authorizeChangePassword(CREDENTIALS_FILE, URL + "/login", "changePassword", headersJson);
    }

    @Step("Отправить запрос авторизации с правильными данными")
    @Когда("отправляю запрос авторизации с правильными данными")
    public void authorizeSuccessfully() {
        response = authorizationClient.authorize(CREDENTIALS_FILE, URL + "/login", headersJson);
    }

    @Step("Проверка статуса ответа авторизации равен")
    @Тогда("статус ответа авторизации равен {int}")
    public void checkStatusCode(int expectedStatus) {
        Assertions.assertEquals(expectedStatus, response.getStatusCode(), "Статус ответа не совпадает");
    }

    @Step("Проверка текста ответа авторизации")
    @И("текст ответа авторизации: {string}")
    public void checkResponseText(String errorType) {
        String expected = switch (errorType) {
            case "not found" -> USER_NOT_FOUND;
            case "not right pass" -> PASSWORD_WRONG;
            default -> throw new IllegalArgumentException("Неизвестная ошибка: " + errorType);
        };
        Assertions.assertEquals(expected, response.asString().trim(), "Текст ответа не совпадает");
    }

    @Step("Получить токен из ответа")
    @И("в ответе есть токен")
    public void checkTokenExists() {
        Assertions.assertTrue(response.asString().contains("token"), "Токен отсутствует в ответе");
    }

    @Step("Сохранить токен")
    @И("токен сохраняется")
    public void saveToken() throws IOException {
        tokenService.saveTokenNewFile(CREDENTIALS_FILE, response);
    }
}
