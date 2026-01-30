package ifellow.automation.utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:application.properties"})
public interface ConfigProperties extends Config {

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("status")
    String status();

    @Key("version")
    String version();

    @Key("theme")
    String theme();

    @Key("tag")
    String tag();

    @Key("task")
    String task();

    @Key("epic")
    String epic();

    @Key("sprint")
    String sprint();

    @Key("description")
    String description();

    @Key("environment")
    String environment();

    @Key("base.url")
    String baseUrl();

    @Key("login.url")
    String loginUrl();

    @Key("path.chrome.driver")
    String chromeDriverPath();

    @Key("chrome.version")
    String chromeVersion();

    @Key("selenide.logger.screen")
    @DefaultValue("true")
    boolean loggerScreen();

    @Key("selenide.logger.pageSource")
    @DefaultValue("true")
    boolean loggerPageSource();
}
