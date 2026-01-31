package ifellow.automation.tests;

import ifellow.automation.hooks.WebHooks;
import ifellow.automation.steps.AuthTestStep;
import ifellow.automation.steps.ProjectTestStep;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Проверка перехода проекта 'Test'")
public class NavigationTest extends WebHooks {
    private final ProjectTestStep projectTestStep = new ProjectTestStep();
    private final AuthTestStep authTestStep = new AuthTestStep();

    @Feature("Навигация")
    @Story("Переход в проект 'Test'")
    @Test
    @Tag("ID-2")
    @DisplayName("Выбор проекта 'Test'")
    public void testSelectProject() {
        authTestStep.fillLogin();
        projectTestStep.openProjectList();
        projectTestStep.selectProject();
        projectTestStep.seeOpenTasks();
    }
}
