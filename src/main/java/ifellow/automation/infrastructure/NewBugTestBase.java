package ifellow.automation.infrastructure;

import ifellow.automation.pages.NewBugPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewBugTestBase extends TestSeleniumAThwTestBase {

    private final NewBugPage newBugPage = new NewBugPage();

    public void addNewBugs() {
        clickMenuTask();
        clickListTask();
        selectBug();
        openDialogWindowTask();
        enterThemeBug();
        clickVisualButton();
        enterDescription();
        enterVersion();
        enterTags();
        enterEnvironment();
        enterTask();
        enterEpic();
        enterSprint();
        enterSerious();
        clickCreateBug();
        clickButtonTaskInWorking();
        clickButtonTaskInFinish();
    }

    public void addNewBugUnit() {
        checkTaskHWUnit();
        clickMenuTask();
        clickListTask();
        selectBug();
        openDialogWindowTask();
        enterThemeBug();
        clickVisualButton();
        enterDescription();
        enterVersion();
        enterTags();
        enterEnvironment();
        enterTask();
        enterEpic();
        enterSprint();
        enterSerious();
        clickCreateBug();
        clickButtonTaskInWorking();
        clickButtonTaskInFinish();
    }

    public void clickButtonTaskInFinish() {
        assertTrue(newBugPage.getButtonTaskBusinessProc().isEnabled(), "Кнопка финишного этапа доступна");
        newBugPage.taskFinish();
    }

    public void clickButtonTaskInWorking() {
        assertTrue(newBugPage.getButtonTaskInWork().isEnabled(), "Кнопка процесса в работе доступна");
        newBugPage.taskInWork();
    }

    public void clickCreateBug() {
        assertTrue(newBugPage.getButtonCreate().isEnabled(), "Кнопка создания доступна");
        newBugPage.create();
    }

    public void enterSerious() {
        assertTrue(newBugPage.getSerious().isDisplayed(), "Список серьезности доступен");
        assertTrue(newBugPage.getSeriousTrivial().isDisplayed(), "Тривиальный доступен");
        newBugPage.writeSerious();
    }

    public void enterSprint() {
        assertTrue(newBugPage.getSprint().isDisplayed(), "Спринт доступен");
        newBugPage.writeSprint();
    }

    public void enterEpic() {
        assertTrue(newBugPage.getLinkEpic().isDisplayed(), "Ссылка на эпик доступна");
        newBugPage.writeLinkEpic();
    }

    public void enterTask() {
        assertTrue(newBugPage.getTask().isEnabled(), "Список с задачами доступен");
        newBugPage.writeTask();
    }

    public void enterEnvironment() {
        assertTrue(newBugPage.getEnvironmentText().isEnabled(), "Поле для окружения отображается");
        newBugPage.writeEnvironment("Environment task");
    }

    public void enterEnvironment(String environment) {
        assertTrue(newBugPage.getEnvironmentText().isEnabled(), "Поле для окружения отображается");
        newBugPage.writeEnvironment(environment);
    }

    public void enterTags() {
        assertTrue(newBugPage.getTags().isEnabled(), "Список с метками отображается");
        newBugPage.writeTags();
    }

    public void enterVersion() {
        assertTrue(newBugPage.getVersion1().isEnabled(), "Исправить в версии отображается");
        assertTrue(newBugPage.getVersion2().isEnabled(), "Затронутые версии отображаются");
        newBugPage.writeVersion();
    }

    public void enterDescription() {
        assertTrue(newBugPage.getDescriptionText().isEnabled(), "Поле описание доступно");
        newBugPage.writeDescription("Description task");
    }

    public void enterDescription(String description) {
        assertTrue(newBugPage.getDescriptionText().isEnabled(), "Поле описание доступно");
        newBugPage.writeDescription(description);
    }

    public void clickVisualButton() {
        assertTrue(newBugPage.getVisualButton1().isEnabled(), "Кнопка виртуальный в описании доступна");
        assertTrue(newBugPage.getVisualButton2().isEnabled(), "Кнопка виртуальный в окружении доступна");
        newBugPage.clickVisual();
    }

    public void enterThemeBug() {
        assertTrue(newBugPage.getThemeBug().isEnabled(), "поле ввода темы отображается");
        String theme = "Theme 1";
        newBugPage.writeTheme(theme);
    }

    public void enterThemeBug(String theme) {
        assertTrue(newBugPage.getThemeBug().isEnabled(), "поле ввода темы отображается");
        newBugPage.writeTheme(theme);
    }

    public void openDialogWindowTask() {
        assertTrue(newBugPage.getDialogWindow().isEnabled(), "Кнопка диалоговое окно отображается");
        newBugPage.openDialogWindow();
    }

    public void selectBug() {
        assertTrue(newBugPage.getElementTask().isEnabled(), "Баг для выбора отображается");
        newBugPage.selectBug();
    }

    public void clickListTask() {
        assertTrue(newBugPage.getListTasks().isEnabled(), "Список выбора задачи");
        newBugPage.clickListTask();
    }

    public void clickMenuTask() {
        newBugPage.clickReturnMenu();
        assertTrue(newBugPage.getCreateTaskButton().isEnabled(), "Кнопка создания отображается");
        newBugPage.clickCreateTaskButton();
    }
}
