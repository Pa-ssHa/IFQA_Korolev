package ifellow;

import ifellow.api.RegistrationClient;
import ifellow.utils.ConstantHeaders;
import ifellow.utils.LoadProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Map;

public class RegistrationTest {
    private static final String URL = LoadProperties.getProperties().getProperty("base.api.url");
    private static final File CREDENTIALS_FILE = new File("src/test/resources/credentials.json");
    private final RegistrationClient registrationClient = new RegistrationClient();

    @Test
    public void testRegistration() {
        Assertions.assertEquals(200, registrationClient.registerUser(CREDENTIALS_FILE, URL + "/register", ConstantHeaders.getJsonHeaders()).statusCode(), "Статус совпадает");
    }
}
