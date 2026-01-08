package ifellow.automation.infrastructure;

import com.codeborne.selenide.Condition;
import ifellow.automation.pages.DashboardTaskPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectTestBase extends AuthTestBase {

    private final DashboardTaskPage dashboardTaskPage = new DashboardTaskPage();

    public void selectProjectTest() {
        openListProject();
        selectProject();
        viewProjectTest();
    }

    public void selectProjectTestUnit() {
        fillLogin();
        openListProject();
        selectProject();
        viewProjectTest();
    }

    public void openListProject() {
        dashboardTaskPage.selectListProject();
        assertTrue(dashboardTaskPage.getProjectTest().isDisplayed(), "Открылся выпадающий список");
    }

    public void selectProject() {
        dashboardTaskPage.selectTestProject();
    }

    public void viewProjectTest() {
        dashboardTaskPage.getOpenTasks().shouldBe(Condition.visible, Duration.ofSeconds(10));
        assertTrue(dashboardTaskPage.getOpenTasks().isDisplayed(), "Задачи открылись");
    }
}
