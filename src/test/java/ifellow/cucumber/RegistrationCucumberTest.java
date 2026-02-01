package ifellow.cucumber;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@Tag("ID-2")
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("ifellow/automation/feature/Registration.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "ifellow.steps, ifellow/hooks")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RegistrationCucumberTest {
}
