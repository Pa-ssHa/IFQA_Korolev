package ifellow.automation.infrastructure;

import ifellow.automation.pages.NewBugPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewBugTestBase extends OpenTaskTestBase {

    private final NewBugPage newBugPage = new NewBugPage();

    public void addNewBugs() {
        addNewTask();

        assertTrue(newBugPage.getCreateTaskButton().isEnabled(), "Кнопка создания отображается");
        newBugPage.clickCreateTaskButton();

        assertTrue(newBugPage.getListTasks().isEnabled(), "Список выбора задачи");
        newBugPage.clickListTask();

        assertTrue(newBugPage.getElementTask().isEnabled(), "Баг для выбора отображается");
        newBugPage.selectBug();

        assertTrue(newBugPage.getDialogWindow().isEnabled(), "Кнопка диалоговое окно отображается");
        newBugPage.openDialogWindow();

        assertTrue(newBugPage.getThemeBug().isEnabled(), "поле ввода темы отображается");
        newBugPage.writeTheme("Theme 1");

        assertTrue(newBugPage.getVisualButton1().isEnabled(), "Кнопка виртуальный в описании доступна");
        assertTrue(newBugPage.getVisualButton2().isEnabled(), "Кнопка виртуальный в окружении доступна");
        newBugPage.clickVisual();

        assertTrue(newBugPage.getDescriptionText().isEnabled(), "Поле описание доступно");
        newBugPage.writeDescription("Description task");

        assertTrue(newBugPage.getVersion1().isEnabled(), "Исправить в версии отображается");
        assertTrue(newBugPage.getVersion2().isEnabled(), "Затронутые версии отображаются");
        newBugPage.writeVersion();

        assertTrue(newBugPage.getTags().isEnabled(), "Список с метками отображается");
        newBugPage.writeTags();

        assertTrue(newBugPage.getEnvironmentText().isEnabled(), "Поле для окружения отображается");
        newBugPage.writeEnvironment("Environment task");

        assertTrue(newBugPage.getTask().isEnabled(), "Список с задачами доступен");
        newBugPage.writeTask();

        assertTrue(newBugPage.getLinkEpic().isDisplayed(), "Ссылка на эпик доступна");
        newBugPage.writeLinkEpic();

        assertTrue(newBugPage.getSprint().isDisplayed(), "Спринт доступен");
        newBugPage.writeSprint();

        assertTrue(newBugPage.getSerious().isDisplayed(), "Список серьезности доступен");
        assertTrue(newBugPage.getSeriousTrivial().isDisplayed(), "Тривиальный доступен");
        newBugPage.writeSerious();

        assertTrue(newBugPage.getButtonCreate().isEnabled(), "Кнопка создания доступна");
        newBugPage.create();

        assertTrue(newBugPage.getButtonTaskInWork().isEnabled(), "Кнопка процесса в работе доступна");
        newBugPage.taskInWork();

        assertTrue(newBugPage.getButtonTaskBusinessProc().isEnabled(), "Кнопка финишного этапа доступна");
        newBugPage.taskFinish();
    }
}
