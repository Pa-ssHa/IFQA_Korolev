package ifellow.automation.steps;

import ifellow.automation.pages.IfellowLoginPage;
import ifellow.automation.utils.ConfigProperties;
import ifellow.automation.utils.RequiredConfig;
import io.qameta.allure.Allure;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.qameta.allure.model.Parameter;
import org.aeonbits.owner.ConfigFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthTestStep {
    private final IfellowLoginPage ifellowLoginPage = new IfellowLoginPage();
    private final ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    private final RequiredConfig requiredConfig = new RequiredConfig(configProperties);
    private final String login = requiredConfig.requireLogin();
    private final String password = requiredConfig.requirePassword();
    private final String LOGIN_URL = requiredConfig.requireLoginUrl();

    @Step("Авторизоваться в системе")
    public void fillLogin() {
        goToLoginPage();
        enterCredentials(login, password);
        clickLoginButton();
        seeDashboard();
    }

    @Step("Открыть страницу логина")
    public void goToLoginPage() {
        ifellowLoginPage.goToLoginPage(LOGIN_URL);
        assertTrue(ifellowLoginPage.getLoginForm().isDisplayed());
    }

    @Step("Ввести логин {login} и пароль ***")
    public void enterCredentials(String login, @Param(mode = Parameter.Mode.MASKED) String password) {
        ifellowLoginPage.enterLoginData(login, password);
        assertEquals(login, ifellowLoginPage.getLoginTextBox().getValue());
    }

    @Step("Нажать кнопку 'Войти'")
    public void clickLoginButton() {
        ifellowLoginPage.clickButtonLogin();
        ifellowLoginPage.checkPassLogin();
    }

    @Step("Проверить отображение дашборда")
    public void seeDashboard() {
        assertTrue(ifellowLoginPage.getDashboard().isDisplayed());
    }
}
