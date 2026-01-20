package ifellow.automation.tests;

import ifellow.automation.hooks.WebHooks;
import ifellow.automation.steps.OpenTaskTestStep;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NewTaskTest extends WebHooks {
    private final OpenTaskTestStep openTaskTestStep = new OpenTaskTestStep();

    @Feature("Задачи")
    @Story("Создание задачи")
    @Test
    @DisplayName("Создание новой задачи")
    public void testCreateNewTask() {
        openTaskTestStep.addNewTask();
    }
}
