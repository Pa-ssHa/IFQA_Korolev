package ifellow.automation.steps;

import ifellow.automation.infrastructure.OpenTaskTestBase;
import ifellow.automation.utils.TaskCounter;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

public class NewTaskSteps {

    private final OpenTaskTestBase openTaskTestBase = new OpenTaskTestBase();
    private int oldCounter;

    @И("перехожу в проект Test")
    public void openProjectTest() {
        openTaskTestBase.selectProjectTest();
    }

    @И("нажимаю кнопку создания новой задачи")
    public void clickButtonNewTask() {
        openTaskTestBase.clickButtonNewTask();
    }

    @И("открываю список доступных задач")
    public void clickListTask() {
        openTaskTestBase.clickListTask();
    }

    @И("выбираю задачу для создания")
    public void selectTaskForCreating() {
        openTaskTestBase.selectTaskForCreating();
    }

    @И("открываю диалоговое окно задачи")
    public void openDialogWindowTask() {
        oldCounter = TaskCounter.currentCounter(openTaskTestBase.getCurrentCounter());
        openTaskTestBase.openDialogWindowTask();
    }

    @И("ввожу тему новой задачи")
    public void enterThemeTask() {
        openTaskTestBase.enterThemeTask();
    }

    @И("создаю задачу")
    public void clickTaskCreate() {
        openTaskTestBase.clickTaskCreate();
    }

    @Тогда("я вижу, что счетчик задач увеличился")
    public void verifyTaskCounter() {
        openTaskTestBase.checkUpdatingCounter(oldCounter);
    }
}
