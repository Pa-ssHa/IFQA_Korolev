package ifellow.api;

import ifellow.service.ResponseCustomApiService;
import io.restassured.response.Response;

import java.util.Map;

public class LogoutClient {
    public Response logout(String url, Map<String, String> headers) {
        return ResponseCustomApiService.getResponse(url, headers);
    }
}
