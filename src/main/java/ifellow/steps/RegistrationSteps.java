package ifellow.steps;

import ifellow.api.RegistrationClient;
import ifellow.utils.ConstantHeaders;
import ifellow.utils.LoadProperties;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.io.File;

public class RegistrationSteps {
    private static final String URL = LoadProperties.getProperties().getProperty("base.api.url");
    private static final File CREDENTIALS_FILE = new File("src/test/resources/credentials.json");
    private final RegistrationClient registrationClient = new RegistrationClient();
    private Response response;

    @Когда("отправляю запрос на регистрацию пользователя")
    public void sendRegistrationRequest() {
        response = registrationClient.registerUser(CREDENTIALS_FILE, URL + "/register", ConstantHeaders.getJsonHeaders());
    }

    @Тогда("статус ответа равен {int}")
    public void checkStatusCode(int expectedStatus) {
        Assertions.assertEquals(expectedStatus, response.statusCode(), "Статус ответа не совпадает");
    }
}
