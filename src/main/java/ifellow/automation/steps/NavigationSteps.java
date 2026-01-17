package ifellow.automation.steps;

import com.codeborne.selenide.Condition;
import ifellow.automation.pages.DashboardTaskPage;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationSteps {
    private final DashboardTaskPage dashboardTaskPage = new DashboardTaskPage();

    @И("открываю список проектов")
    public void openProjectList() {
        dashboardTaskPage.selectListProject();
        assertTrue(dashboardTaskPage.getProjectTest().isDisplayed(), "Открылся выпадающий список");
    }

    @И("выбираю проект \"Test\"")
    public void selectProject() {
        dashboardTaskPage.selectTestProject();
    }

    @Тогда("я вижу открытые задачи проекта")
    public void seeOpenTasks() {
        dashboardTaskPage.getOpenTasks().shouldBe(Condition.visible, Duration.ofSeconds(10));
        assertTrue(dashboardTaskPage.getOpenTasks().isDisplayed(), "Задачи открылись");
    }
}
