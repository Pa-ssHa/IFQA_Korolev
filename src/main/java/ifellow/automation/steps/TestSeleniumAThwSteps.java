package ifellow.automation.steps;

import ifellow.automation.infrastructure.TestSeleniumAThwTestBase;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class TestSeleniumAThwSteps {
    private final TestSeleniumAThwTestBase testSeleniumAThwTestBase = new TestSeleniumAThwTestBase();

    @И("создаю новую задачу")
    public void createNewTask() {
        testSeleniumAThwTestBase.addNewTask();
    }

    @Когда("я ищу созданную задачу TestSeleniumATHomework")
    public void findCreatedTask() {
        testSeleniumAThwTestBase.findTask();
    }

    @И("вижу имя задачи")
    public void seeTaskName() {
        testSeleniumAThwTestBase.checkFindingTask();
    }

    @Тогда("отображается статус задачи {string}")
    public void seeTaskStatus(String status) {
        testSeleniumAThwTestBase.checkStatusTask(status);
    }

    @Тогда("отображается версия задачи {string}")
    public void seeTaskVersion(String version) {
        testSeleniumAThwTestBase.checkVersionTask(version);
    }
}
