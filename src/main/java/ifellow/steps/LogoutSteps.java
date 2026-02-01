package ifellow.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import ifellow.api.LogoutClient;
import ifellow.utils.RequiredConfig;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static ifellow.utils.ConstantHeaders.getTokenHeaders;

public class LogoutSteps {
    private final RequiredConfig requiredConfig = new RequiredConfig();
    private final String URL = requiredConfig.requireBaseApiUrl();
    private final File CREDENTIALS_FILE_TOKEN = new File(requiredConfig.requireCredentialFileToken());
    private final String USER_NOT_FOUND = requiredConfig.requireNotFound();
    private final String SUCCESS_LOGOUT = requiredConfig.requireSuccessLogout();
    private final LogoutClient logoutClient = new LogoutClient();
    private final ObjectMapper mapper = new ObjectMapper();
    private Response response;

    @Step("Отправить запрос выхода с неправильным токеном")
    @Когда("отправляю запрос выхода с некорректным токеном")
    public void logoutWithInvalidToken() {
        response = logoutClient.logout(URL + "/logout", getTokenHeaders(UUID.randomUUID().toString()));
    }

    @Step("Отправить запрос выхода с корректным токеном")
    @Когда("отправляю запрос выхода с корректным токеном")
    public void logoutWithValidToken() throws IOException {
        String token = mapper.readTree(CREDENTIALS_FILE_TOKEN).get("token").asText();
        response = logoutClient.logout(URL + "/logout", getTokenHeaders(token));
    }

    @Step("Проверить статус ответа выхода")
    @Тогда("статус ответа выхода равен {int}")
    public void checkStatusCode(int expectedStatus) {
        Assertions.assertEquals(expectedStatus, response.getStatusCode(), "Статус ответа не совпадает");
    }

    @Step("Проверить текст ответа выхода")
    @И("текст ответа выхода равен {string}")
    public void checkResponseText(String errorType) {
        String expected = switch (errorType) {
            case "success logout" -> SUCCESS_LOGOUT;
            case "not found" -> USER_NOT_FOUND;
            default -> throw new IllegalArgumentException("Неизвестная ошибка: " + errorType);
        };
        Assertions.assertEquals(expected, response.asString().trim(), "Текст ответа не совпадает");
    }
}
