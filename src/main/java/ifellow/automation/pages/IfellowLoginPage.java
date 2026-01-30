package ifellow.automation.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Param;
import io.qameta.allure.model.Parameter;
import lombok.Getter;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.model.Parameter.Mode.HIDDEN;

@Getter
public class IfellowLoginPage {
    private final SelenideElement loginTextBox = $x("//input[@id='login-form-username']").as("Поле логина");
    private final SelenideElement passwordTextBox = $x("//input[@id='login-form-password']").as("Поле пароля");
    private final SelenideElement loginButton = $x("//input[@id='login-form-submit']").as("Кнопка входа");
    private final SelenideElement loginForm = $x("//h1[contains(text(),'Добро пожаловать в Jira')]").as("Приветствие на входе");
    private final SelenideElement dashboard = $x("//h3[contains(text(),'Назначенные мне')]").as("dashboard с задачами");

    public IfellowLoginPage goToLoginPage(String url) {
        open(url);
        return this;
    }

    public void enterLoginData(String username, String password) {
        loginTextBox.shouldBe(Condition.visible, Duration.ofSeconds(10));
        loginTextBox.setValue(username);
        passwordTextBox.toWebElement().sendKeys(password);
    }

    public void clickButtonLogin() {
        loginButton.shouldBe(Condition.visible, Duration.ofSeconds(10));
        loginButton.click();
    }

    public void checkPassLogin(){
        dashboard.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

}
