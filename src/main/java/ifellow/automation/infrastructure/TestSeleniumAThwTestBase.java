package ifellow.automation.infrastructure;

import ifellow.automation.pages.TestSeleniumAThwPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSeleniumAThwTestBase extends OpenTaskTestBase {
    private final TestSeleniumAThwPage testSeleniumAThwPage = new TestSeleniumAThwPage();

    public void checkTaskHW() {
        findTask();
        checkFindingTask();
        checkStatusTask();
        checkVersionTask();
    }

    public void checkTaskHWUnit() {
        addNewTaskUnit();
        findTask();
        checkFindingTask();
        checkStatusTask();
        checkVersionTask();
    }

    public void checkTaskHW(String status, String version) {
        findTask();
        checkFindingTask();
        checkStatusTask(status);
        checkVersionTask(version);
    }

    public void findTask() {
        assertTrue(testSeleniumAThwPage.getSearch().isDisplayed(), "Поисковая строка найдена");
        testSeleniumAThwPage.findTest();
    }

    public void checkFindingTask() {
        assertTrue(testSeleniumAThwPage.getNameTask().isDisplayed(), "Переход осуществлен");
    }

    public void checkStatusTask() {
        assertTrue(testSeleniumAThwPage.getStatusTask().isDisplayed(), "Статус отображается");
        assertEquals(testSeleniumAThwPage.checkStatus(), "СДЕЛАТЬ");
    }

    public void checkVersionTask() {
        assertTrue(testSeleniumAThwPage.getVersionTask().isDisplayed(), "Версия отображается");
        assertEquals(testSeleniumAThwPage.checkVersion(), "Version 2.0");
    }

    public void checkStatusTask(String status) {
        assertTrue(testSeleniumAThwPage.getStatusTask().isDisplayed(), "Статус отображается");
        assertEquals(testSeleniumAThwPage.checkStatus(), status);
    }

    public void checkVersionTask(String version) {
        assertTrue(testSeleniumAThwPage.getVersionTask().isDisplayed(), "Версия отображается");
        assertEquals(testSeleniumAThwPage.checkVersion(), version);
    }
}
