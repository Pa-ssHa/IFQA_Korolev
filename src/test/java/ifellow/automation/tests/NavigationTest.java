package ifellow.automation.tests;

import ifellow.automation.hooks.WebHooks;
import ifellow.automation.steps.ProjectTestStep;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NavigationTest extends WebHooks {
    private final ProjectTestStep projectTestStep = new ProjectTestStep();

    @Feature("Навигация")
    @Story("Переход в проект 'Test'")
    @Test
    @DisplayName("Выбор проекта 'Test'")
    public void testSelectProject() {
        projectTestStep.selectProjectTest();
    }
}
