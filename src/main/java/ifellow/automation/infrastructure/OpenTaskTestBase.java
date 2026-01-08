package ifellow.automation.infrastructure;

import ifellow.automation.pages.OpenTasksMainPage;
import ifellow.automation.utils.TaskCounter;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenTaskTestBase extends ProjectTestBase {
    private final OpenTasksMainPage openTasksMainPage = new OpenTasksMainPage();

    public void addNewTask() {
        clickButtonNewTask();
        clickListTask();
        selectTaskForCreating();
        openDialogWindowTask();
        int beforeAdd = TaskCounter.currentCounter(getCurrentCounter());
        enterThemeTask();
        clickTaskCreate();
        checkUpdatingCounter(beforeAdd);
    }

    public void addNewTaskUnit() {
        selectProjectTestUnit();
        clickButtonNewTask();
        clickListTask();
        selectTaskForCreating();
        openDialogWindowTask();
        int beforeAdd = TaskCounter.currentCounter(getCurrentCounter());
        enterThemeTask();
        clickTaskCreate();
        checkUpdatingCounter(beforeAdd);
    }

    public String getCurrentCounter() {
        return openTasksMainPage.getCounter().getText();
    }

    public void clickButtonNewTask() {
        assertTrue(openTasksMainPage.getCreateTaskButton().isDisplayed(), "Кнопка создания отображается");
        openTasksMainPage.clickCreateTaskButton();
    }

    public void clickListTask() {
        assertTrue(openTasksMainPage.getListTasks().isDisplayed(), "Список выбора задачи");
        openTasksMainPage.clickListTask();
    }

    public void selectTaskForCreating() {
        assertTrue(openTasksMainPage.getElementTask().isDisplayed(), "Задача для выбора отображается");
        openTasksMainPage.selectTask();
    }

    public void openDialogWindowTask() {
        assertTrue(openTasksMainPage.getDialogWindow().isDisplayed(), "Кнопка диалоговое окно отображается");
        openTasksMainPage.openDialogWindow();
    }

    public void enterThemeTask() {
        assertTrue(openTasksMainPage.getNewTaskThemeTextBox().isDisplayed(), "поле ввода темы отображается");
        openTasksMainPage.createNewTask();
    }

    public void clickTaskCreate() {
        assertTrue(openTasksMainPage.getCreateButton().isDisplayed(), "кнопка создания отображается");
        openTasksMainPage.buttonCreateNewTask();
    }

    public void checkUpdatingCounter(int oldCounter) {
        openTasksMainPage.updatePage();
        assertTrue(openTasksMainPage.checkVisibleCounterTask(), "Счетчик отображается");
        assertTrue(openTasksMainPage.getCounter().getText().contains(String.valueOf(oldCounter + 1)), "Счетчик увеличился верно");
    }
}
