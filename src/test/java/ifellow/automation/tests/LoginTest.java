package ifellow.automation.tests;

import ifellow.automation.hooks.WebHooks;
import ifellow.automation.steps.AuthTestStep;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends WebHooks {
    private final AuthTestStep authTestStep = new AuthTestStep();

    @Feature("Авторизация")
    @Story("Вход в систему")
    @Test
    @DisplayName("Проверка авторизации")
    public void testAuthorization() {
        authTestStep.fillLogin();
    }
}
