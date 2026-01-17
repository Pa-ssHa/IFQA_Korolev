package ifellow.automation.steps;

import ifellow.automation.pages.IfellowLoginPage;
import ifellow.automation.utils.LoadProperties;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    private final IfellowLoginPage ifellowLoginPage = new IfellowLoginPage();

    @Когда("я перехожу на страницу логина")
    public void goToLoginPage() {
        ifellowLoginPage.goToLoginPage();
        assertTrue(ifellowLoginPage.getLoginForm().isDisplayed());
    }

    @И("ввожу логин и пароль")
    public void enterCredentials() {
        Properties properties = LoadProperties.getProperties();
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        ifellowLoginPage.enterLoginData(login, password);
        assertEquals(login, ifellowLoginPage.getLoginTextBox().getValue());
    }

    @И("нажимаю кнопку \"Войти\"")
    public void clickLoginButton() {
        ifellowLoginPage.clickButtonLogin();
        ifellowLoginPage.checkPassLogin();
    }

    @Тогда("я вижу дашборд с задачами")
    public void seeDashboard() {
        assertTrue(ifellowLoginPage.getDashboard().isDisplayed());
    }
}