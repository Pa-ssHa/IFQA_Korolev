package ifellow.automation.infrastructure;

import com.codeborne.selenide.SelenideElement;
import ifellow.automation.WebHooks;
import ifellow.automation.pages.IfellowLoginPage;
import ifellow.automation.utils.LoadProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthTestBase extends WebHooks {

    private final IfellowLoginPage ifellowLoginPage = new IfellowLoginPage();
    private final Properties properties = LoadProperties.getProperties();

    public void fillLogin() {
        ifellowLoginPage.goToLoginPage();
        assertTrue(ifellowLoginPage.getLoginForm().isDisplayed());

        ifellowLoginPage.enterLoginData(properties.getProperty("login"), properties.getProperty("password"));
        assertEquals(properties.getProperty("login"), ifellowLoginPage.getLoginTextBox().getValue());

        ifellowLoginPage.clickButtonLogin();
        ifellowLoginPage.checkPassLogin();
        assertTrue(ifellowLoginPage.getDashboard().isDisplayed());
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
