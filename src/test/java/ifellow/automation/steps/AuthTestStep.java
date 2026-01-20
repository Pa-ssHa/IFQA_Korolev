package ifellow.automation.steps;

import ifellow.automation.pages.IfellowLoginPage;
import ifellow.automation.utils.LoadProperties;
import io.qameta.allure.Step;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthTestStep {
    private final IfellowLoginPage ifellowLoginPage = new IfellowLoginPage();
    private final Properties properties = LoadProperties.getProperties();

    @Step("Авторизоваться в системе")
    public void fillLogin() {
        goToLoginPage();
        enterCredentials();
        clickLoginButton();
        seeDashboard();
    }

    @Step("Открыть страницу логина")
    public void goToLoginPage() {
        ifellowLoginPage.goToLoginPage();
        assertTrue(ifellowLoginPage.getLoginForm().isDisplayed());
    }

    @Step("Ввести логин и пароль")
    public void enterCredentials() {
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
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
