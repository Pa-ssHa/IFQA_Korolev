package ifellow.automation.steps;

import ifellow.automation.infrastructure.ProjectTestBase;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class NavigationSteps {

    private final ProjectTestBase projectTestBase = new ProjectTestBase();

    @Когда("я вхожу в систему с логином {string} и паролем {string}")
    public void login(String login, String password) {
        projectTestBase.fillLogin();
    }

    @И("открываю список проектов")
    public void openProjectList() {
        projectTestBase.openListProject();
    }

    @И("выбираю проект \"Test\"")
    public void selectProject() {
        projectTestBase.selectProject();
    }

    @Тогда("я вижу открытые задачи проекта")
    public void seeOpenTasks() {
        projectTestBase.viewProjectTest();
    }
}
