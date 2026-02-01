package ifellow.api;

import ifellow.service.ResponseCustomApiService;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.qameta.allure.model.Parameter;
import io.restassured.response.Response;

import java.util.Map;

public class LogoutClient {

    @Step("Отправить GET /logout")
    public Response logout(String url, @Param(mode = Parameter.Mode.MASKED) Map<String, String> headers) {
        return ResponseCustomApiService.getResponse(url, headers);
    }
}
