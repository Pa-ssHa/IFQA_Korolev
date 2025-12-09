package ifellow.automation.tests;

import ifellow.automation.infrastructure.AuthTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends AuthTestBase {

    @Test
    @DisplayName("Проверка авторизации")
    public void testAuthorization() {
        fillLogin();
    }


}
