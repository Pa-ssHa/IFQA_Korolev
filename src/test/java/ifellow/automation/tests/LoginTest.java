package ifellow.automation.tests;

import ifellow.automation.hooks.WebHooks;
import ifellow.automation.steps.AuthTestStep;
import ifellow.automation.utils.ConfigProperties;
import ifellow.automation.utils.RequiredConfig;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Проверка авторизации")
public class LoginTest extends WebHooks {
    private final AuthTestStep authTestStep = new AuthTestStep();
    private final ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    private final RequiredConfig requiredConfig = new RequiredConfig(configProperties);

    @Feature("Авторизация")
    @Story("Вход в систему")
    @Test
    @DisplayName("Проверка авторизации")
    public void testAuthorization() {
        authTestStep.goToLoginPage();
        authTestStep.enterCredentials(requiredConfig.requireLogin(), requiredConfig.requirePassword());
        authTestStep.clickLoginButton();
        authTestStep.seeDashboard();
    }
}
