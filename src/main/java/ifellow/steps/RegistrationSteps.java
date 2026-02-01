package ifellow.steps;

import ifellow.api.RegistrationClient;
import ifellow.utils.ConstantHeaders;
import ifellow.utils.RequiredConfig;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.io.File;

public class RegistrationSteps {
    private final RequiredConfig requiredConfig = new RequiredConfig();
    private final String URL = requiredConfig.requireBaseApiUrl();
    private final File CREDENTIALS_FILE = new File(requiredConfig.requireCredentialFile());
    private final RegistrationClient registrationClient = new RegistrationClient();
    private Response response;

    @Step("Отправить запрос на регистрацию пользователя")
    @Когда("отправляю запрос на регистрацию пользователя")
    public void sendRegistrationRequest() {
        response = registrationClient.registerUser(CREDENTIALS_FILE, URL + "/register", ConstantHeaders.getJsonHeaders());
    }

    @Step("Получить статус ответа 200")
    @Тогда("статус ответа регистрации равен {int}")
    public void checkStatusCode(int expectedStatus) {
        Assertions.assertEquals(expectedStatus, response.statusCode(), "Статус ответа не совпадает");
    }
}
