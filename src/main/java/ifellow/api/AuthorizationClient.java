package ifellow.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ifellow.service.ResponseCustomApiService;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class AuthorizationClient {
    private final ObjectMapper mapper = new ObjectMapper();

    public Response authorizeChangeName(File file, String url, String newName, Map<String, String> headers) throws IOException {
        JsonNode currentCredentials = mapper.readTree(file);
        ObjectNode changeName = currentCredentials.deepCopy();
        changeName.put("username", newName);
        return ResponseCustomApiService.postResponse(changeName.toString(), url, headers);
    }

    public Response authorizeChangePassword(File file, String url, String newPassword, Map<String, String> headers) throws IOException {
        JsonNode currentCredentials = mapper.readTree(file);
        ObjectNode changePassword = currentCredentials.deepCopy();
        changePassword.put("password", newPassword);
        return ResponseCustomApiService.postResponse(changePassword.toString(), url, headers);
    }

    public Response authorize(File file, String url, Map<String, String> headers) {
        return ResponseCustomApiService.postResponse(file, url, headers);
    }
}
