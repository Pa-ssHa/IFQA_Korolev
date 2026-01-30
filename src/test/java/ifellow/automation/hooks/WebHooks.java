package ifellow.automation.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import ifellow.automation.utils.ConfigProperties;
import ifellow.automation.utils.RequiredConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebHooks {
    private final ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    private final RequiredConfig requiredConfig = new RequiredConfig(configProperties);

    @BeforeEach
    public void initBrowser() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(requiredConfig.loggerScreen())
                .savePageSource(requiredConfig.loggerPageSource()));

        String pathDriver = requiredConfig.requireChromeDriverPath();
        String chromeVersion = requiredConfig.requireChromeVersion();
        if ((pathDriver == null || pathDriver.trim().isEmpty()) &&
                (chromeVersion == null || chromeVersion.trim().isEmpty())) {
            System.setProperty("webdriver.selenium.manager.enabled", "true");
        } else {
            System.setProperty("webdriver.selenium.manager.enabled", "false");
            System.setProperty("webdriver.chrome.driver", pathDriver + "/" + chromeVersion + "/chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);

        Configuration.timeout = 15000;
        Configuration.baseUrl = requiredConfig.requireBaseUrl();
    }

    @AfterEach
    public void closeBrowser() {
        WebDriverRunner.closeWindow();
    }
}
