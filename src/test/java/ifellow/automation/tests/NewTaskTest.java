package ifellow.automation.tests;

import ifellow.automation.infrastructure.OpenTaskTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NewTaskTest extends OpenTaskTestBase {

    @Test
    @DisplayName("Создание новой задачи")
    public void testCreateNewTask() {
        addNewTaskUnit();
    }
}
