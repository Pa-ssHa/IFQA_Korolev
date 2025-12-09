package ifellow.automation.infrastructure;

import com.codeborne.selenide.SelenideElement;
import ifellow.automation.WebHooks;
import ifellow.automation.pages.IfellowLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthTestBase extends WebHooks {

    private final IfellowLoginPage ifellowLoginPage = new IfellowLoginPage();

    public void fillLogin() {
        ifellowLoginPage.goToLoginPage();
        SelenideElement loginForm = $x("//h1[contains(text(),'Добро пожаловать в Jira')]").as("Приветствие на входе");
        assertTrue(loginForm.isDisplayed());

        ifellowLoginPage.enterLoginData("AT6", "Qwerty123");
        assertEquals("AT6", ifellowLoginPage.getLoginTextBox().getValue());

        ifellowLoginPage.clickButtonLogin();

        SelenideElement dashboard = $x("//h3[contains(text(),'Назначенные мне')]").as("dashboard с задачами");
        assertTrue(dashboard.isDisplayed());
    }

    @BeforeEach
    public void initBrowser() {
        super.initBrowser();
    }

    @AfterEach
    public void closeBrowser() {
        super.closeBrowser();
    }
}
