package ifellow.automation.steps;

import ifellow.automation.pages.NewBugPage;
import ifellow.automation.utils.LoadProperties;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewBugSteps {
    private final NewBugPage newBugPage = new NewBugPage();
    private final Properties properties = LoadProperties.getProperties();

    @И("открываю меню задач")
    public void openMenuAndCreateBug() {
        newBugPage.clickReturnMenu();
        assertTrue(newBugPage.getCreateTaskButton().isEnabled(), "Кнопка создания отображается");
        newBugPage.clickCreateTaskButton();
    }

    @И("выбираю баг для создания")
    public void selectBugStep() {
        assertTrue(newBugPage.getListTasks().isEnabled(), "Список выбора задачи");
        newBugPage.clickListTask();
        assertTrue(newBugPage.getElementTask().isEnabled(), "Баг для выбора отображается");
        newBugPage.selectBug();
    }

    @И("открываю диалоговое окно бага")
    public void openDialog() {
        assertTrue(newBugPage.getDialogWindow().isEnabled(), "Кнопка диалоговое окно отображается");
        newBugPage.openDialogWindow();
    }

    @И("ввожу тему бага")
    public void enterTheme() {
        String theme = properties.getProperty("theme");
        if (theme == null || theme.trim().isEmpty()) {
            throw new RuntimeException("theme отсутствует или пустое в application.properties");
        }
        assertTrue(newBugPage.getThemeBug().isEnabled(), "поле ввода темы отображается");
        newBugPage.writeTheme(theme);
    }

    @И("нажимаю кнопки визуальный")
    public void clickVisualButtons() {
        assertTrue(newBugPage.getVisualButton1().isEnabled(), "Кнопка виртуальный в описании доступна");
        assertTrue(newBugPage.getVisualButton2().isEnabled(), "Кнопка виртуальный в окружении доступна");
        newBugPage.clickVisual();
    }

    @И("ввожу описание бага")
    public void enterDescriptionStep() {
        String description = properties.getProperty("description");
        if (description == null || description.trim().isEmpty()) {
            throw new RuntimeException("description отсутствует или пустое в application.properties");
        }
        assertTrue(newBugPage.getDescriptionText().isEnabled(), "Поле описание доступно");
        newBugPage.writeDescription(description);
    }

    @И("выбираю версии")
    public void selectVersionStep() {
        assertTrue(newBugPage.getVersion1().isEnabled(), "Исправить в версии отображается");
        assertTrue(newBugPage.getVersion2().isEnabled(), "Затронутые версии отображаются");
        newBugPage.writeVersion();
    }

    @И("добавляю метки")
    public void addTags() {
        assertTrue(newBugPage.getTags().isEnabled(), "Список с метками отображается");
        newBugPage.writeTags();
    }

    @И("заполняю окружение")
    public void enterEnvironmentStep() {
        String environment = properties.getProperty("environment");
        if (environment == null || environment.trim().isEmpty()) {
            throw new RuntimeException("environment отсутствует или пустое в application.properties");
        }
        assertTrue(newBugPage.getEnvironmentText().isEnabled(), "Поле для окружения отображается");
        newBugPage.writeEnvironment(environment);
    }

    @И("добавляю задачу")
    public void linkTask() {
        assertTrue(newBugPage.getTask().isEnabled(), "Список с задачами доступен");
        newBugPage.writeTask();
    }

    @И("добавляю эпик")
    public void linkEpic() {
        assertTrue(newBugPage.getLinkEpic().isDisplayed(), "Ссылка на эпик доступна");
        newBugPage.writeLinkEpic();
    }

    @И("выбираю спринт")
    public void selectSprint() {
        assertTrue(newBugPage.getSprint().isDisplayed(), "Спринт доступен");
        newBugPage.writeSprint();
    }

    @И("устанавливаю серьезность")
    public void setSeriousness() {
        assertTrue(newBugPage.getSerious().isDisplayed(), "Список серьезности доступен");
        assertTrue(newBugPage.getSeriousTrivial().isDisplayed(), "Тривиальный доступен");
        newBugPage.writeSerious();
    }

    @И("создаю баг")
    public void createBugStep() {
        assertTrue(newBugPage.getButtonCreate().isEnabled(), "Кнопка создания доступна");
        newBugPage.create();
    }

    @И("перевожу баг в работу")
    public void moveBugWork() {
        assertTrue(newBugPage.getButtonTaskInWork().isEnabled(), "Кнопка процесса в работе доступна");
        newBugPage.taskInWork();
    }

    @Тогда("я перевожу баг на финальный этап")
    public void moveBugFinish() {
        assertTrue(newBugPage.getButtonTaskBusinessProc().isEnabled(), "Кнопка финишного этапа доступна");
        newBugPage.taskFinish();
    }
}
