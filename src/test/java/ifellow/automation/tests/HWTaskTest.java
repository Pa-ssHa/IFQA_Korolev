package ifellow.automation.tests;

import ifellow.automation.hooks.WebHooks;
import ifellow.automation.steps.TestSeleniumAThwTestStep;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HWTaskTest extends WebHooks {
    private final TestSeleniumAThwTestStep testSeleniumAThwTestStep = new TestSeleniumAThwTestStep();

    @Feature("Задачи")
    @Story("Проверка задачи TestSeleniumATHomework")
    @Test
    @DisplayName("Проверка задачи TestSeleniumATHomework")
    public void checkTask() {
        testSeleniumAThwTestStep.checkTaskHW();
    }
}
