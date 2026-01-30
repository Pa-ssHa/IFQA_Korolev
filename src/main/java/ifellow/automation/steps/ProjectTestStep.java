package ifellow.automation.steps;

import com.codeborne.selenide.Condition;
import ifellow.automation.pages.DashboardTaskPage;
import io.qameta.allure.Step;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectTestStep {
    private final DashboardTaskPage dashboardTaskPage = new DashboardTaskPage();

    @Step("Выбор проекта 'Test'")
    public void selectProjectTest() {
        openProjectList();
        selectProject();
        seeOpenTasks();
    }

    @Step("Открыть список проектов")
    public void openProjectList() {
        dashboardTaskPage.selectListProject();
        assertTrue(dashboardTaskPage.getProjectTest().isDisplayed());
    }

    @Step("Выбрать проект 'Test'")
    public void selectProject() {
        dashboardTaskPage.selectTestProject();
    }

    @Step("Проверить, что открылись задачи")
    public void seeOpenTasks() {
        dashboardTaskPage.getOpenTasks().shouldBe(Condition.visible, Duration.ofSeconds(10));
        assertTrue(dashboardTaskPage.getOpenTasks().isDisplayed());
    }
}
