package ifellow.automation.steps;

import ifellow.automation.pages.TestSeleniumAThwPage;
import ifellow.automation.utils.LoadProperties;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSeleniumAThwSteps {
    private final TestSeleniumAThwPage testSeleniumAThwPage = new TestSeleniumAThwPage();
    private final Properties properties = LoadProperties.getProperties();

    @Когда("я ищу созданную задачу TestSeleniumATHomework")
    public void findCreatedTask() {
        assertTrue(testSeleniumAThwPage.getSearch().isDisplayed(), "Поисковая строка найдена");
        testSeleniumAThwPage.findTest();
    }

    @И("вижу имя задачи")
    public void seeTaskName() {
        assertTrue(testSeleniumAThwPage.getNameTask().isDisplayed(), "Переход осуществлен");
    }

    @Тогда("отображается статус задачи")
    public void seeTaskStatus() {
        String status = properties.getProperty("status");
        if (status == null || status.trim().isEmpty()) {
            throw new RuntimeException("status отсутствует или пустое в application.properties");
        }
        assertTrue(testSeleniumAThwPage.getStatusTask().isDisplayed(), "Статус отображается");
        assertEquals(testSeleniumAThwPage.checkStatus(), status);
    }

    @Тогда("отображается версия задачи")
    public void seeTaskVersion() {
        String version = properties.getProperty("version");
        if (version == null || version.trim().isEmpty()) {
            throw new RuntimeException("version отсутствует или пустое в application.properties");
        }
        assertTrue(testSeleniumAThwPage.getVersionTask().isDisplayed(), "Версия отображается");
        assertEquals(testSeleniumAThwPage.checkVersion(), version);
    }
}
