package ifellow.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ifellow.utils.RequiredConfig;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;

public class AuthorizationTokenService {
    private final RequiredConfig requiredConfig = new RequiredConfig();
    public void saveTokenNewFile(File oldFile, Response response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode currentCredentials = mapper.readTree(oldFile);
        ObjectNode successAuth = currentCredentials.deepCopy();

        successAuth.put("token", response.asString()
                .substring(response.asString().indexOf("token : ") + 8));

        File fileCredentialsWithToken = new File(requiredConfig.requireCredentialFileToken());
        mapper.writerWithDefaultPrettyPrinter().writeValue(fileCredentialsWithToken, successAuth);
    }
}
