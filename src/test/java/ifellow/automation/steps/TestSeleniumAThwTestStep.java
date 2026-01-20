package ifellow.automation.steps;

import ifellow.automation.pages.TestSeleniumAThwPage;
import ifellow.automation.utils.LoadProperties;
import io.qameta.allure.Step;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSeleniumAThwTestStep {

    private final OpenTaskTestStep openTaskTestStep = new OpenTaskTestStep();
    private final TestSeleniumAThwPage testSeleniumAThwPage = new TestSeleniumAThwPage();
    private final Properties properties = LoadProperties.getProperties();

    @Step("Проверка задачи 'TestSeleniumATHomework'")
    public void checkTaskHW() {
        openTaskTestStep.addNewTask();
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
        String status = properties.getProperty("status");
        if (status == null || status.trim().isEmpty()) {
            throw new RuntimeException("status отсутствует или пустое в application.properties");
        }
        assertTrue(testSeleniumAThwPage.getStatusTask().isDisplayed(), "Статус отображается");
        assertEquals(testSeleniumAThwPage.checkStatus(), status);
    }

    @Step("Проверка версии задачи")
    public void seeTaskVersion() {
        String version = properties.getProperty("version");
        if (version == null || version.trim().isEmpty()) {
            throw new RuntimeException("version отсутствует или пустое в application.properties");
        }
        assertTrue(testSeleniumAThwPage.getVersionTask().isDisplayed(), "Версия отображается");
        assertEquals(testSeleniumAThwPage.checkVersion(), version);
    }
}
