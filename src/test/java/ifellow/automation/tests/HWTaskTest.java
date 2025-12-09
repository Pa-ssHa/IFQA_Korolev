package ifellow.automation.tests;

import ifellow.automation.infrastructure.TestSeleniumAThwTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HWTaskTest extends TestSeleniumAThwTestBase {

    @Test
    @DisplayName("Проверка задачи TestSeleniumATHomework")
    public void checkTask() {
        checkTaskHW();
    }
}
