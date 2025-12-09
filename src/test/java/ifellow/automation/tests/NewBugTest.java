package ifellow.automation.tests;

import ifellow.automation.infrastructure.NewBugTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NewBugTest extends NewBugTestBase {

    @DisplayName("Создание бага")
    @Test
    public void checkBug() {
        addNewBugs();
    }
}
