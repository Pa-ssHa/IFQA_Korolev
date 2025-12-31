package ifellow.automation.infrastructure;

import com.codeborne.selenide.SelenideElement;
import ifellow.automation.pages.OpenTasksMainPage;
import ifellow.automation.utils.TaskCounter;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenTaskTestBase extends ProjectTestBase {

    private final OpenTasksMainPage openTasksMainPage = new OpenTasksMainPage();

    public void addNewTask() {
        selectProjectTest();

        assertTrue(openTasksMainPage.getCreateTaskButton().isDisplayed(), "Кнопка создания отображается");
        openTasksMainPage.clickCreateTaskButton();

        assertTrue(openTasksMainPage.getListTasks().isDisplayed(), "Список выбора задачи");
        openTasksMainPage.clickListTask();

        assertTrue(openTasksMainPage.getElementTask().isDisplayed(), "Задача для выбора отображается");
        openTasksMainPage.selectTask();

        assertTrue(openTasksMainPage.getDialogWindow().isDisplayed(), "Кнопка диалоговое окно отображается");
        openTasksMainPage.openDialogWindow();

        int beforeAdd = TaskCounter.currentCounter(openTasksMainPage.getCounter().getText());

        assertTrue(openTasksMainPage.getNewTaskThemeTextBox().isDisplayed(), "поле ввода темы отображается");
        openTasksMainPage.createNewTask();

        assertTrue(openTasksMainPage.getCreateButton().isDisplayed(), "кнопка создания отображается");
        openTasksMainPage.buttonCreateNewTask();

        openTasksMainPage.updatePage();
        assertTrue(openTasksMainPage.checkVisibleCounterTask(), "Счетчик отображается");
        assertTrue(openTasksMainPage.getCounter().getText().contains(String.valueOf(beforeAdd + 1)), "Счетчик увеличился верно");
    }
}
