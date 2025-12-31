package ifellow.automation.infrastructure;

import ifellow.automation.pages.TestSeleniumAThwPage;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSeleniumAThwTestBase extends OpenTaskTestBase {

    private final TestSeleniumAThwPage testSeleniumAThwPage = new TestSeleniumAThwPage();

    public void checkTaskHW() {
        addNewTask();

        assertTrue(testSeleniumAThwPage.getSearch().isDisplayed(), "Поисковая строка найдена");
        testSeleniumAThwPage.findTest();

        assertTrue(testSeleniumAThwPage.getNameTask().isDisplayed(), "Переход осуществлен");

        assertTrue(testSeleniumAThwPage.getStatusTask().isDisplayed(), "Статус отображается");
        assertEquals(testSeleniumAThwPage.checkStatus(), "СДЕЛАТЬ");

        assertTrue(testSeleniumAThwPage.getVersionTask().isDisplayed(), "Версия отображается");
        assertEquals(testSeleniumAThwPage.checkVersion(), "Version 2.0");
    }
}
