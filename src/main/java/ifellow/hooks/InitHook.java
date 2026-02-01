package ifellow.hooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ifellow.api.AuthorizationClient;
import ifellow.api.RegistrationClient;
import ifellow.utils.ConstantHeaders;
import ifellow.utils.RequiredConfig;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static ifellow.utils.ConstantHeaders.getJsonHeaders;

public class InitHook {
    private final RequiredConfig config = new RequiredConfig();
    private final ObjectMapper mapper = new ObjectMapper();
    private final RegistrationClient registrationClient = new RegistrationClient();
    private final AuthorizationClient authorizationClient = new AuthorizationClient();
    private final RequiredConfig requiredConfig = new RequiredConfig();
    private final String URL = requiredConfig.requireBaseApiUrl();
    private final File CREDENTIALS_FILE = new File(requiredConfig.requireCredentialFile());
    private final Map<String, String> headersJson = getJsonHeaders();

    @Before
    public void initCredentialsFile() throws IOException {
        File file = new File(config.requireCredentialFile());

        if (!file.exists()) {
            ObjectNode json = mapper.createObjectNode();
            json.put("username", config.requireLogin());
            json.put("password", config.requirePassword());
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, json);
        }
    }

    @Before("@auth")
    public void beforeAuth() {
        registrationClient.registerUserInit(CREDENTIALS_FILE, URL + "/register", ConstantHeaders.getJsonHeaders());
    }

    @Before("@logout")
    public void beforeLogout() {
        authorizationClient.authorizeInit(CREDENTIALS_FILE, URL + "/login", headersJson);
    }
}
