package ifellow.automation.steps;

import ifellow.automation.infrastructure.NewBugTestBase;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

public class NewBugSteps {
    private final NewBugTestBase newBugTestBase = new NewBugTestBase();

    @И("проверяю созданную задачу TestSeleniumATHomework со статусом {string} и версией {string}")
    public void checkCreatedTask(String status, String version) {
        newBugTestBase.checkTaskHW(status, version);
    }

    @И("открываю меню задач")
    public void openMenuAndCreateBug() {
        newBugTestBase.clickMenuTask();
    }

    @И("выбираю баг для создания")
    public void selectBugStep() {
        newBugTestBase.clickListTask();
        newBugTestBase.selectBug();
    }

    @И("открываю диалоговое окно бага")
    public void openDialog() {
        newBugTestBase.openDialogWindowTask();
    }

    @И("ввожу тему бага {string}")
    public void enterTheme(String theme) {
        newBugTestBase.enterThemeBug(theme);
    }

    @И("нажимаю кнопки визуальный")
    public void clickVisualButtons() {
        newBugTestBase.clickVisualButton();
    }

    @И("ввожу описание бага {string}")
    public void enterDescriptionStep(String description) {
        newBugTestBase.enterDescription(description);
    }

    @И("выбираю версии")
    public void selectVersionStep() {
        newBugTestBase.enterVersion();
    }

    @И("добавляю метки")
    public void addTags() {
        newBugTestBase.enterTags();
    }

    @И("заполняю окружение {string}")
    public void enterEnvironmentStep(String environment) {
        newBugTestBase.enterEnvironment(environment);
    }

    @И("добавляю задачу")
    public void linkTask() {
        newBugTestBase.enterTask();
    }

    @И("добавляю эпик")
    public void linkEpic() {
        newBugTestBase.enterEpic();
    }

    @И("выбираю спринт")
    public void selectSprint() {
        newBugTestBase.enterSprint();
    }

    @И("устанавливаю серьезность")
    public void setSeriousness() {
        newBugTestBase.enterSerious();
    }

    @И("создаю баг")
    public void createBugStep() {
        newBugTestBase.clickCreateBug();
    }

    @И("перевожу баг в работу")
    public void moveBugToWork() {
        newBugTestBase.clickButtonTaskInWorking();
    }

    @Тогда("я перевожу баг на финальный этап")
    public void moveBugToFinish() {
        newBugTestBase.clickButtonTaskInFinish();
    }
}
