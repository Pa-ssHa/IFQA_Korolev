package ifellow.automation.steps;

import ifellow.automation.WebHooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebHooksCucumber {
    private final WebHooks webHooks = new WebHooks();

    @Before
    public void start() {
        webHooks.initBrowser();
    }

    @After
    public void stop() {
        webHooks.closeBrowser();
    }
}
