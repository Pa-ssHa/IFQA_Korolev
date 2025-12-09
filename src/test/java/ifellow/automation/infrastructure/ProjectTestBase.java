package ifellow.automation.infrastructure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ifellow.automation.pages.DashboardTaskPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectTestBase extends AuthTestBase {

    private final DashboardTaskPage dashboardTaskPage = new DashboardTaskPage();

    public void selectProjectTest() {
        fillLogin();

        dashboardTaskPage.selectListProject();
        assertTrue(dashboardTaskPage.getProjectTest().isDisplayed(), "Открылся выпадающий список");

        dashboardTaskPage.selectTestProject();
        SelenideElement openTasks = $x("//span[@id='issues-subnavigation-title']").as("Заголовок открытые задачи");
        openTasks.shouldBe(Condition.visible, Duration.ofSeconds(10));
        assertTrue(openTasks.isDisplayed(), "Задачи открылись");
    }
}
