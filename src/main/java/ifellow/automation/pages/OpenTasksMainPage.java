package ifellow.automation.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ifellow.automation.utils.TaskCounter;
import lombok.Getter;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class OpenTasksMainPage {

    private final SelenideElement counter = $x("//span[contains(text(),' из ')]").as("Счетчик");
    private final SelenideElement createTaskButton = $x("//button[contains(text(),'Создать задачу')]").as("Кнопка создания задачи");
    private final SelenideElement listTasks = $x("//button[@class='iic-widget__issue-type-selector__trigger aui-button aui-button-subtle aui-button-compact aui-dropdown2-trigger']").as("Список для выбора задачи");
    private final SelenideElement elementTask = $x("//a[@class='aui-icon-container' and contains(text(), 'Задача')]").as("Список для выбора задачи");
    private final SelenideElement dialogWindow = $x("//button[@class='aui-button aui-button-text iic-widget__more' and contains(text(), 'Открыть в диалоговом окне')]").as("Кнопка открытия диалогового окна");
    private final SelenideElement newTaskThemeTextBox = $x("//input[@class='text long-field' and @id='summary']").as("Поле ввода темы задачи");
    private final SelenideElement createButton = $x("//input[@id='create-issue-submit']").as("Кнопка сохранения");

    private int getIncreaseCounter() {
        counter.shouldBe(Condition.visible, Duration.ofSeconds(5));
        return TaskCounter.increaseCounter(counter.getText());
    }

    public void clickCreateTaskButton() {
        createTaskButton.shouldBe(Condition.visible, Duration.ofSeconds(10));
        createTaskButton.click();
        listTasks.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void clickListTask() {
        listTasks.shouldBe(Condition.visible, Duration.ofSeconds(10));
        listTasks.click();
        elementTask.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void selectTask() {
        elementTask.shouldBe(Condition.visible, Duration.ofSeconds(10));
        elementTask.click();
    }

    public void openDialogWindow() {
        dialogWindow.shouldBe(Condition.visible, Duration.ofSeconds(10));
        dialogWindow.click();
        newTaskThemeTextBox.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public String createNewTask() {
        newTaskThemeTextBox.shouldBe(Condition.visible, Duration.ofSeconds(15));
        newTaskThemeTextBox.clear();
        String nameTask = "TASK-" + getIncreaseCounter();
        newTaskThemeTextBox.setValue(nameTask);
        return nameTask;
    }

    public void buttonCreateNewTask() {
        createButton.shouldBe(Condition.visible, Duration.ofSeconds(15));
        createButton.click();
    }

    public void updatePage() {
        Selenide.refresh();
    }

    public boolean checkVisibleCounterTask() {
        Selenide.refresh();
        return true ? counter.shouldBe(Condition.visible, Duration.ofSeconds(10)) != null : false;
    }
}
