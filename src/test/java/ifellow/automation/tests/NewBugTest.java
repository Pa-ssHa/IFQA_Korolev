package ifellow.automation.tests;

import ifellow.automation.hooks.WebHooks;
import ifellow.automation.steps.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Создание нового бага с описанием")
public class NewBugTest extends WebHooks {
    private final NewBugTestStep newBugTestStep = new NewBugTestStep();
    private final TestSeleniumAThwTestStep testSeleniumAThwTestStep = new TestSeleniumAThwTestStep();
    private final OpenTaskTestStep openTaskTestStep = new OpenTaskTestStep();
    private final ProjectTestStep projectTestStep = new ProjectTestStep();
    private final AuthTestStep authTestStep = new AuthTestStep();

    @Feature("Баги")
    @Story("Создание бага")
    @DisplayName("Создание бага")
    @Test
    public void checkBug() {
        authTestStep.fillLogin();
        projectTestStep.selectProjectTest();
        openTaskTestStep.addNewTask();
        testSeleniumAThwTestStep.checkTaskHW();
        newBugTestStep.openMenuAndCreateBug();
        newBugTestStep.selectBugStep();
        newBugTestStep.openDialog();
        newBugTestStep.enterTheme();
        newBugTestStep.clickVisualButtons();
        newBugTestStep.enterDescriptionStep();
        newBugTestStep.selectVersionStep();
        newBugTestStep.addTags();
        newBugTestStep.enterEnvironmentStep();
        newBugTestStep.linkTask();
        newBugTestStep.linkEpic();
        newBugTestStep.selectSprint();
        newBugTestStep.setSeriousness();
        newBugTestStep.createBugStep();
        newBugTestStep.moveBugWork();
        newBugTestStep.moveBugFinish();
    }
}
