package ifellow.automation.steps;

import ifellow.automation.pages.OpenTasksMainPage;
import ifellow.automation.utils.TaskCounter;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewTaskSteps {
    private final OpenTasksMainPage openTasksMainPage = new OpenTasksMainPage();
    private int oldCounter;

    @И("нажимаю кнопку создания новой задачи")
    public void clickButtonNewTask() {
        assertTrue(openTasksMainPage.getCreateTaskButton().isDisplayed(), "Кнопка создания отображается");
        openTasksMainPage.clickCreateTaskButton();
    }

    @И("открываю список доступных задач")
    public void clickListTask() {
        assertTrue(openTasksMainPage.getListTasks().isDisplayed(), "Список выбора задачи");
        openTasksMainPage.clickListTask();
    }

    @И("выбираю задачу для создания")
    public void selectTaskForCreating() {
        assertTrue(openTasksMainPage.getElementTask().isDisplayed(), "Задача для выбора отображается");
        openTasksMainPage.selectTask();
    }

    @И("открываю диалоговое окно задачи")
    public void openDialogWindowTask() {
        oldCounter = TaskCounter.currentCounter(openTasksMainPage.getCounter().getText());
        assertTrue(openTasksMainPage.getDialogWindow().isDisplayed(), "Кнопка диалоговое окно отображается");
        openTasksMainPage.openDialogWindow();
    }

    @И("ввожу тему новой задачи")
    public void enterThemeTask() {
        assertTrue(openTasksMainPage.getNewTaskThemeTextBox().isDisplayed(), "поле ввода темы отображается");
        openTasksMainPage.createNewTask();
    }

    @И("создаю задачу")
    public void clickTaskCreate() {
        assertTrue(openTasksMainPage.getCreateButton().isDisplayed(), "кнопка создания отображается");
        openTasksMainPage.buttonCreateNewTask();
    }

    @Тогда("я вижу, что счетчик задач увеличился")
    public void verifyTaskCounter() {
        openTasksMainPage.updatePage();
        assertTrue(openTasksMainPage.checkVisibleCounterTask(), "Счетчик отображается");
        assertTrue(openTasksMainPage.getCounter().getText().contains(String.valueOf(oldCounter + 1)), "Счетчик увеличился верно");
    }
}
