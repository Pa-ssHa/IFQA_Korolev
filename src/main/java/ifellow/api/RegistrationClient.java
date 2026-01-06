package ifellow.api;

import ifellow.service.ResponseCustomApiService;
import io.restassured.response.Response;

import java.io.File;
import java.util.Map;

public class RegistrationClient {
    public Response registerUser(File file, String URL, Map<String, String> headers) {
        return ResponseCustomApiService.postResponse(file, URL, headers);
    }
}
