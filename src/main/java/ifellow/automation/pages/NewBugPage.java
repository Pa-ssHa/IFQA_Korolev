package ifellow.automation.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;

@Getter
public class NewBugPage {

    private final SelenideElement createTaskButton = $x("//button[@class='aui-button aui-button-subtle' and contains(text(),'Создать')]").as("Кнопка создания задачи");
    private final SelenideElement listTasks = $x("//button[@class='iic-widget__issue-type-selector__trigger aui-button aui-button-subtle aui-button-compact aui-dropdown2-trigger']").as("Список для выбора задачи");
    private final SelenideElement elementTask = $x("//a[@class='aui-icon-container' and contains(text(), 'Ошибка')]").as("Список для выбора задачи");
    private final SelenideElement dialogWindow = $x("//button[@class='aui-button aui-button-text iic-widget__more' and contains(text(), 'Открыть в диалоговом окне')]").as("Кнопка открытия диалогового окна");

    private final SelenideElement themeBug = $x("//input[@id='summary']").as("Поле ввода темы бага");
    private final SelenideElement visualButton1 = $x("(//button[@class='aui-button' and contains(text(), 'Визуальный')])[1]").as("Кнопка визуальный");
    private final SelenideElement visualButton2 = $x("(//button[@class='aui-button' and contains(text(), 'Визуальный')])[2]").as("Кнопка визуальный");
    private final SelenideElement descriptionText = $x("(//iframe[contains(@id,'mce_') and contains(@title,'Rich Text Area')])[1]").as("Поле для описания");
    private final SelenideElement version1 = $x("(//option[@value='10001'])[1]").as("Версия1");
    private final SelenideElement version2 = $x("(//option[@value='10001'])[2]").as("Версия2");

    private final SelenideElement tags = $x("//textarea[@id='labels-textarea']").as("Список меток");

    private final SelenideElement environmentText = $x("(//iframe[contains(@id,'mce_') and contains(@title,'Rich Text Area')])[2]").as("Поле для окружения");

    private final SelenideElement task = $x("//textarea[@id='issuelinks-issues-textarea']").as("Список задач");

    private final SelenideElement linkEpic = $x("//input[@id='customfield_10100-field']").as("ссылка на эпик");

    private final SelenideElement sprint = $x("//input[@id='customfield_10104-field']").as("Спринт");

    private final SelenideElement serious = $x("//select[@id='customfield_10400']").as("Серьезность");
    private final SelenideElement seriousTrivial = $x("//option[contains(text(),'Тривиальный')]").as("Серьезность тривиальный");

    private final SelenideElement buttonCreate = $x("//input[@id='create-issue-submit']").as("Кнопка создания");

    private final SelenideElement buttonTaskInWork = $x("//span[@class='trigger-label' and contains(text(),'В работе')]").as("Кнопка задача в работе");
    private final SelenideElement buttonTaskBusinessProc = $x("//span[@class='dropdown-text' and contains(text(),'Бизнес-процесс')]").as("Кнопка задача в работе");
    private final SelenideElement buttonTaskFinish = $x("//span[@class='trigger-label' and contains(text(),'Выполнено')]").as("Кнопка задача в работе");

    public void clickCreateTaskButton() {
        createTaskButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        createTaskButton.click();
        listTasks.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    public void clickListTask() {
        listTasks.shouldBe(Condition.visible, Duration.ofSeconds(5));
        listTasks.click();
        elementTask.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    public void selectBug() {
        elementTask.shouldBe(Condition.visible, Duration.ofSeconds(5));
        elementTask.click();
    }

    public void openDialogWindow() {
        dialogWindow.shouldBe(Condition.visible, Duration.ofSeconds(5));
        dialogWindow.click();
        themeBug.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    public void writeTheme(String theme) {
        themeBug.shouldBe(Condition.visible, Duration.ofSeconds(5));
        themeBug.click();
        themeBug.setValue(theme);
    }

    public void clickVisual() {
        visualButton1.shouldBe(Condition.enabled, Duration.ofSeconds(5));
        visualButton1.click();
        visualButton2.shouldBe(Condition.enabled, Duration.ofSeconds(5));
        visualButton2.click();
    }

    public void writeDescription(String description) {
        executeJavaScript("tinymce.editors[0].setContent('" + description + "');");
    }

    public void writeVersion() {
        version1.shouldBe(Condition.enabled, Duration.ofSeconds(5));
        version1.click();
        version2.shouldBe(Condition.enabled, Duration.ofSeconds(5));
        version2.click();
    }

    public void writeTags() {
        tags.shouldBe(Condition.enabled, Duration.ofSeconds(5));
        tags.click();
        tags.setValue("QA_school");
        tags.pressEnter();
    }

    public void writeEnvironment(String environment) {
        executeJavaScript("tinymce.editors[1].setContent('" + environment + "');");
    }

    public void writeTask() {
        task.shouldBe(Condition.enabled, Duration.ofSeconds(15));
        task.click();
        task.setValue("210437");
        Selenide.sleep(500);
        task.pressEnter();
    }

    public void writeLinkEpic() {
        linkEpic.shouldBe(Condition.enabled, Duration.ofSeconds(15));
        linkEpic.click();
        linkEpic.setValue("Epic");
        Selenide.sleep(500);
        linkEpic.sendKeys(Keys.ARROW_DOWN);
        linkEpic.pressEnter();
    }

    public void writeSprint() {
        sprint.shouldBe(Condition.enabled, Duration.ofSeconds(15));
        sprint.click();
        sprint.setValue("Доска Спринт 2");
        sprint.pressEnter();
    }

    public void writeSerious() {
        serious.shouldBe(Condition.enabled, Duration.ofSeconds(15));
        serious.click();
        seriousTrivial.shouldBe(Condition.enabled, Duration.ofSeconds(15));
        seriousTrivial.click();
    }

    public void create() {
        buttonCreate.shouldBe(Condition.enabled, Duration.ofSeconds(15));
        buttonCreate.click();
        buttonTaskInWork.shouldBe(Condition.enabled, Duration.ofSeconds(15));
    }

    public void taskInWork() {
        buttonTaskInWork.shouldBe(Condition.enabled, Duration.ofSeconds(15));
        buttonTaskInWork.click();
    }

    public void taskFinish() {
        buttonTaskBusinessProc.shouldBe(Condition.enabled, Duration.ofSeconds(15));
        buttonTaskBusinessProc.click();
        buttonTaskFinish.shouldBe(Condition.enabled, Duration.ofSeconds(15));
        buttonTaskFinish.click();
    }
}
