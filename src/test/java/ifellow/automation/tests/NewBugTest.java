package ifellow.automation.tests;

import ifellow.automation.hooks.WebHooks;
import ifellow.automation.steps.NewBugTestStep;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NewBugTest extends WebHooks {
    private final NewBugTestStep newBugTestStep = new NewBugTestStep();

    @Feature("Баги")
    @Story("Создание бага")
    @DisplayName("Создание бага")
    @Test
    public void checkBug() {
        newBugTestStep.addNewBugs();
    }
}
