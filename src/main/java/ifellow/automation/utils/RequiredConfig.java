package ifellow.automation.utils;

public class RequiredConfig {

    private final ConfigProperties configProperties;

    public RequiredConfig(ConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    public String requireLogin() {
        return requireString(configProperties.login(), "login");
    }

    public String requirePassword() {
        return requireString(configProperties.password(), "password");
    }

    public String requireStatus() {
        return requireString(configProperties.status(), "status");
    }

    public String requireVersion() {
        return requireString(configProperties.version(), "version");
    }

    public String requireTheme() {
        return requireString(configProperties.theme(), "theme");
    }

    public String requireTag() {
        return requireString(configProperties.tag(), "tag");
    }

    public String requireTask() {
        return requireString(configProperties.task(), "task");
    }

    public String requireEpic() {
        return requireString(configProperties.epic(), "epic");
    }

    public String requireSprint() {
        return requireString(configProperties.sprint(), "sprint");
    }

    public String requireDescription() {
        return requireString(configProperties.description(), "description");
    }

    public String requireEnvironment() {
        return requireString(configProperties.environment(), "environment");
    }

    public String requireBaseUrl() {
        return requireString(configProperties.baseUrl(), "base.url");
    }

    public String requireLoginUrl() {
        return requireString(configProperties.loginUrl(), "login.url");
    }

    public String requireChromeDriverPath() {
        return requireString(configProperties.chromeDriverPath(), "path.chrome.driver");
    }

    public String requireChromeVersion() {
        return requireString(configProperties.chromeVersion(), "chrome.version");
    }

    public boolean loggerScreen() {
        return configProperties.loggerScreen();
    }

    public boolean loggerPageSource() {
        return configProperties.loggerPageSource();
    }

    private String requireString(String value, String key) {
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "параметр отсутствует или пустой: " + key
            );
        }
        return value;
    }
}
