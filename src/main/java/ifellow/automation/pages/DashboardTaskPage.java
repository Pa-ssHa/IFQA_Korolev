package ifellow.automation.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class DashboardTaskPage {
    private final SelenideElement projectAllList = $x("//a[@id='browse_link']").as("Проекты");
    private final SelenideElement projectTest = $x("//a[@id='admin_main_proj_link_lnk']").as("Проект тест");
    private final SelenideElement projectMenu = $x("//div[@id='browse_link-content']").as("Меню с проектами");
    private final SelenideElement openTasks = $x("//span[@id='issues-subnavigation-title']").as("Заголовок открытые задачи");

    public void selectListProject() {
        projectAllList.shouldBe(Condition.visible, Duration.ofSeconds(15));
        projectAllList.click();
        projectMenu.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void selectTestProject() {
        projectTest.shouldBe(Condition.visible, Duration.ofSeconds(15));
        projectTest.click();
    }

}
