package ifellow.api;

import ifellow.service.ResponseCustomApiService;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.io.File;
import java.util.Map;

public class RegistrationClient {

    @Step("Отправить POST /register")
    public Response registerUser(File file, String URL, Map<String, String> headers) {
        return ResponseCustomApiService.postResponse(file, URL, headers);
    }

    public void registerUserInit(File file, String URL, Map<String, String> headers) {
        ResponseCustomApiService.postResponse(file, URL, headers);
    }
}
