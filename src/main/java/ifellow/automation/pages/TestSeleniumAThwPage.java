package ifellow.automation.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class TestSeleniumAThwPage {

    private final SelenideElement search = $x("//input[@id='quickSearchInput']").as("Поисковая строка");
    private final SelenideElement nameTask = $x("//h1[@id='summary-val']").as("Название задачи");
    private final SelenideElement statusTask = $x("//span[@class=' jira-issue-status-lozenge aui-lozenge jira-issue-status-lozenge-blue-gray jira-issue-status-lozenge-new jira-issue-status-lozenge-max-width-medium']").as("Статус");
    private final SelenideElement versionTask = $x("//a[contains(text(), 'Version 2.0')]").as("Версия");

    public void findTest() {
        search.shouldBe(Condition.visible, Duration.ofSeconds(15));
        search.click();
        search.setValue("TestSeleniumATHomework").pressEnter();
        nameTask.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public String checkStatus() {
        statusTask.shouldBe(Condition.visible, Duration.ofSeconds(15));
        return statusTask.getText();
    }

    public String checkVersion() {
        versionTask.shouldBe(Condition.visible, Duration.ofSeconds(15));
        return versionTask.getText();
    }


}
