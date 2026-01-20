package ifellow.automation.steps;

import ifellow.automation.pages.OpenTasksMainPage;
import ifellow.automation.utils.TaskCounter;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenTaskTestStep {

    private final ProjectTestStep projectTestStep = new ProjectTestStep();
    private final OpenTasksMainPage openTasksMainPage = new OpenTasksMainPage();

    private int oldCounter;

    @Step("Создание новой задачи")
    public void addNewTask() {
        projectTestStep.selectProjectTest();
        clickButtonNewTask();
        clickListTask();
        selectTaskForCreating();
        openDialogWindowTask();
        enterThemeTask();
        clickTaskCreate();
        checkTaskCounter();
    }

    @Step("Нажатие кнопки создания задачи")
    public void clickButtonNewTask() {
        assertTrue(openTasksMainPage.getCreateTaskButton().isDisplayed(), "Кнопка создания отображается");
        openTasksMainPage.clickCreateTaskButton();
    }

    @Step("Открытие списка типов задач")
    public void clickListTask() {
        assertTrue(openTasksMainPage.getListTasks().isDisplayed(), "Список выбора задачи");
        openTasksMainPage.clickListTask();
    }

    @Step("Выбор тип 'задача'")
    public void selectTaskForCreating() {
        assertTrue(openTasksMainPage.getElementTask().isDisplayed(), "Задача для выбора отображается");
        openTasksMainPage.selectTask();
    }

    @Step("Открытие диалогового окна создания задачи")
    public void openDialogWindowTask() {
        oldCounter = TaskCounter.currentCounter(openTasksMainPage.getCounter().getText());
        assertTrue(openTasksMainPage.getDialogWindow().isDisplayed(), "Диалоговое окно отображается");
        openTasksMainPage.openDialogWindow();
    }

    @Step("Ввод темы новой задачи")
    public void enterThemeTask() {
        assertTrue(openTasksMainPage.getNewTaskThemeTextBox().isDisplayed(), "Поле ввода темы отображается");
        openTasksMainPage.createNewTask();
    }

    @Step("Подтверждение создания задачи")
    public void clickTaskCreate() {
        assertTrue(openTasksMainPage.getCreateButton().isDisplayed(), "Кнопка создания отображается");
        openTasksMainPage.buttonCreateNewTask();
    }

    @Step("Проверка увеличения счетчика")
    public void checkTaskCounter() {
        openTasksMainPage.updatePage();
        assertTrue(openTasksMainPage.checkVisibleCounterTask(), "Счетчик отображается");
        assertTrue(openTasksMainPage.getCounter().getText().contains(String.valueOf(oldCounter + 1)), "Счетчик увеличился на 1");
    }
}
