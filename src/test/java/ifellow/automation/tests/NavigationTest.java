package ifellow.automation.tests;

import ifellow.automation.infrastructure.ProjectTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NavigationTest extends ProjectTestBase {

    @Test
    @DisplayName("Выбор проекта 'Test'")
    public void testSelectProject() {
        selectProjectTest();
    }


}
