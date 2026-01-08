package ifellow.automation.infrastructure;

import ifellow.automation.WebHooks;
import ifellow.automation.pages.IfellowLoginPage;
import ifellow.automation.utils.LoadProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthTestBase extends WebHooks {

    private final IfellowLoginPage ifellowLoginPage = new IfellowLoginPage();
    private final Properties properties = LoadProperties.getProperties();

    public void fillLogin() {
        displayLoginForm();
        enterLoginData();
        clickEnterLoginButton();
        checkSuccessPass();
    }

    public void displayLoginForm() {
        ifellowLoginPage.goToLoginPage();
        assertTrue(ifellowLoginPage.getLoginForm().isDisplayed());
    }

    public void enterLoginData() {
        ifellowLoginPage.enterLoginData(properties.getProperty("login"), properties.getProperty("password"));
        assertEquals(properties.getProperty("login"), ifellowLoginPage.getLoginTextBox().getValue());
    }

    public void enterLoginData(String username, String password) {
        ifellowLoginPage.enterLoginData(username, password);
        assertEquals(username, ifellowLoginPage.getLoginTextBox().getValue());
    }

    public void clickEnterLoginButton() {
        ifellowLoginPage.clickButtonLogin();
        ifellowLoginPage.checkPassLogin();
    }

    public void checkSuccessPass() {
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
