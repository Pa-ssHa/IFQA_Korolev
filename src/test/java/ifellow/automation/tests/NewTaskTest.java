package ifellow.automation.tests;

import ifellow.automation.hooks.WebHooks;
import ifellow.automation.steps.AuthTestStep;
import ifellow.automation.steps.OpenTaskTestStep;
import ifellow.automation.steps.ProjectTestStep;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Счетчика задач через создание задачи")
public class NewTaskTest extends WebHooks {
    private final OpenTaskTestStep openTaskTestStep = new OpenTaskTestStep();
    private final ProjectTestStep projectTestStep = new ProjectTestStep();
    private final AuthTestStep authTestStep = new AuthTestStep();

    @Feature("Задачи")
    @Story("Создание задачи")
    @Test
    @DisplayName("Создание новой задачи")
    public void testCreateNewTask() {
        authTestStep.fillLogin();
        projectTestStep.selectProjectTest();
        openTaskTestStep.clickButtonNewTask();
        openTaskTestStep.clickListTask();
        openTaskTestStep.selectTaskForCreating();
        openTaskTestStep.openDialogWindowTask();
        openTaskTestStep.enterThemeTask();
        openTaskTestStep.clickTaskCreate();
        openTaskTestStep.checkTaskCounter();
    }
}
