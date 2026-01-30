package ifellow.automation.steps;

import ifellow.automation.pages.TestSeleniumAThwPage;
import ifellow.automation.utils.ConfigProperties;
import ifellow.automation.utils.RequiredConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSeleniumAThwTestStep {
    private final TestSeleniumAThwPage testSeleniumAThwPage = new TestSeleniumAThwPage();
    private final ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    private final RequiredConfig requiredConfig = new RequiredConfig(configProperties);

    @Step("Проверка задачи 'TestSeleniumATHomework'")
    public void checkTaskHW() {
        findCreatedTask();
        seeTaskName();
        seeTaskStatus();
        seeTaskVersion();
    }

    @Step("Поиск задачи")
    public void findCreatedTask() {
        assertTrue(testSeleniumAThwPage.getSearch().isDisplayed(), "Поисковая строка найдена");
        testSeleniumAThwPage.findTest();
    }

    @Step("Проверка видимости задачи")
    public void seeTaskName() {
        assertTrue(testSeleniumAThwPage.getNameTask().isDisplayed(), "Переход осуществлен");
    }

    @Step("Проверка статуса задачи")
    public void seeTaskStatus() {
        String status = requiredConfig.requireStatus();
        assertTrue(testSeleniumAThwPage.getStatusTask().isDisplayed(), "Статус отображается");
        assertEquals(testSeleniumAThwPage.checkStatus(), status);
    }

    @Step("Проверка версии задачи")
    public void seeTaskVersion() {
        String version = requiredConfig.requireVersion();
        assertTrue(testSeleniumAThwPage.getVersionTask().isDisplayed(), "Версия отображается");
        assertEquals(testSeleniumAThwPage.checkVersion(), version);
    }
}
