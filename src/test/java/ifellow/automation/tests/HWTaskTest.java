package ifellow.automation.tests;

import ifellow.automation.hooks.WebHooks;
import ifellow.automation.steps.AuthTestStep;
import ifellow.automation.steps.OpenTaskTestStep;
import ifellow.automation.steps.ProjectTestStep;
import ifellow.automation.steps.TestSeleniumAThwTestStep;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Проверка перехода в задачу 'TestSeleniumATHomework'")
public class HWTaskTest extends WebHooks {
    private final TestSeleniumAThwTestStep testSeleniumAThwTestStep = new TestSeleniumAThwTestStep();
    private final OpenTaskTestStep openTaskTestStep = new OpenTaskTestStep();
    private final ProjectTestStep projectTestStep = new ProjectTestStep();
    private final AuthTestStep authTestStep = new AuthTestStep();

    @Feature("Задачи")
    @Story("Проверка задачи TestSeleniumATHomework")
    @Test
    @Tag("ID-4")
    @DisplayName("Проверка задачи TestSeleniumATHomework")
    public void checkTask() {
        authTestStep.fillLogin();
        projectTestStep.selectProjectTest();
        openTaskTestStep.addNewTask();
        testSeleniumAThwTestStep.findCreatedTask();
        testSeleniumAThwTestStep.seeTaskName();
        testSeleniumAThwTestStep.seeTaskStatus();
        testSeleniumAThwTestStep.seeTaskVersion();
    }
}
