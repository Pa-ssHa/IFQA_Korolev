package ifellow.automation.steps;

import ifellow.automation.pages.NewBugPage;
import ifellow.automation.utils.ConfigProperties;
import ifellow.automation.utils.RequiredConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewBugTestStep {
    private final NewBugPage newBugPage = new NewBugPage();
    private final ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    private final RequiredConfig requiredConfig = new RequiredConfig(configProperties);

    @Step("Открытие меню создания задачи")
    public void openMenuAndCreateBug() {
        newBugPage.clickReturnMenu();
        assertTrue(newBugPage.getCreateTaskButton().isEnabled(), "Кнопка создания отображается");
        newBugPage.clickCreateTaskButton();
    }

    @Step("Выбор типа задачи 'bug'")
    public void selectBugStep() {
        assertTrue(newBugPage.getListTasks().isEnabled(), "Список выбора задачи");
        newBugPage.clickListTask();
        assertTrue(newBugPage.getElementTask().isEnabled(), "Баг для выбора отображается");
        newBugPage.selectBug();
    }

    @Step("Открытие диалогового окна бага")
    public void openDialog() {
        assertTrue(newBugPage.getDialogWindow().isEnabled(), "Кнопка диалоговое окно отображается");
        newBugPage.openDialogWindow();
    }

    @Step("Ввод темы бага")
    public void enterTheme() {
        String theme = requiredConfig.requireTheme();
        assertTrue(newBugPage.getThemeBug().isEnabled(), "поле ввода темы отображается");
        newBugPage.writeTheme(theme);
    }

    @Step("Нажатие кнопок 'визуальный'")
    public void clickVisualButtons() {
        assertTrue(newBugPage.getVisualButton1().isEnabled(), "Кнопка виртуальный в описании доступна");
        assertTrue(newBugPage.getVisualButton2().isEnabled(), "Кнопка виртуальный в окружении доступна");
        newBugPage.clickVisual();
    }

    @Step("Ввод описания бага")
    public void enterDescriptionStep() {
        String description = requiredConfig.requireDescription();
        assertTrue(newBugPage.getDescriptionText().isEnabled(), "Поле описание доступно");
        newBugPage.writeDescription(description);
    }

    @Step("Выбор версий для бага")
    public void selectVersionStep() {
        assertTrue(newBugPage.getVersion1().isEnabled(), "Исправить в версии отображается");
        assertTrue(newBugPage.getVersion2().isEnabled(), "Затронутые версии отображаются");
        newBugPage.writeVersion();
    }

    @Step("Выбор метки")
    public void addTags() {
        String tag = requiredConfig.requireTag();
        assertTrue(newBugPage.getTags().isEnabled(), "Список с метками отображается");
        newBugPage.writeTags(tag);
    }

    @Step("Ввод окружения")
    public void enterEnvironmentStep() {
        String environment = requiredConfig.requireEnvironment();
        assertTrue(newBugPage.getEnvironmentText().isEnabled(), "Поле для окружения отображается");
        newBugPage.writeEnvironment(environment);
    }

    @Step("Выбор задачи")
    public void linkTask() {
        String task = requiredConfig.requireTask();
        assertTrue(newBugPage.getTask().isEnabled(), "Список с задачами доступен");
        newBugPage.writeTask(task);
    }

    @Step("Выбор эпика")
    public void linkEpic() {
        String epic = requiredConfig.requireEpic();
        assertTrue(newBugPage.getLinkEpic().isDisplayed(), "Ссылка на эпик доступна");
        newBugPage.writeLinkEpic(epic);
    }

    @Step("Выбор спринта")
    public void selectSprint() {
        String sprint = requiredConfig.requireSprint();
        if (sprint == null || sprint.trim().isEmpty()) {
            throw new RuntimeException("description отсутствует или пустое в application.properties");
        }
        assertTrue(newBugPage.getSprint().isDisplayed(), "Спринт доступен");
        newBugPage.writeSprint(sprint);
    }

    @Step("Выбор серьезности")
    public void setSeriousness() {
        assertTrue(newBugPage.getSerious().isDisplayed(), "Список серьезности доступен");
        assertTrue(newBugPage.getSeriousTrivial().isDisplayed(), "Тривиальный доступен");
        newBugPage.writeSerious();
    }

    @Step("Создание бага")
    public void createBugStep() {
        assertTrue(newBugPage.getButtonCreate().isEnabled(), "Кнопка создания доступна");
        newBugPage.create();
    }

    @Step("Перевод бага в статус 'в работе'")
    public void moveBugWork() {
        assertTrue(newBugPage.getButtonTaskInWork().isEnabled(), "Кнопка процесса в работе доступна");
        newBugPage.taskInWork();
    }

    @Step("Перевод бага в статус 'выполнено'")
    public void moveBugFinish() {
        assertTrue(newBugPage.getButtonTaskBusinessProc().isEnabled(), "Кнопка финишного этапа доступна");
        newBugPage.taskFinish();
    }
}
