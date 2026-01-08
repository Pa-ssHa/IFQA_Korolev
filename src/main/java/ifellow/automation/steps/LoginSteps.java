package ifellow.automation.steps;

import ifellow.automation.infrastructure.AuthTestBase;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class LoginSteps {

    private final AuthTestBase authTestBase = new AuthTestBase();

    @Когда("я перехожу на страницу логина")
    public void goToLoginPage() {
        authTestBase.displayLoginForm();
    }

    @И("ввожу логин {string} и пароль {string}")
    public void enterCredentials(String login, String password) {
        authTestBase.enterLoginData(login, password);
    }

    @И("нажимаю кнопку \"Войти\"")
    public void clickLoginButton() {
        authTestBase.clickEnterLoginButton();
    }

    @Тогда("я вижу дашборд с задачами")
    public void seeDashboard() {
        authTestBase.checkSuccessPass();
    }
}