package ifellow.automation.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import ifellow.automation.utils.LoadProperties;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

public class WebHooks {
    private final Properties properties = LoadProperties.getProperties();

    @BeforeEach
    public void initBrowser() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));

        String pathDriver = properties.getProperty("path.chrome.driver");
        String chromeVersion = properties.getProperty("chrome.version");
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
        Configuration.baseUrl = properties.getProperty("base.url");
    }

    @AfterEach
    public void closeBrowser() {
        WebDriverRunner.closeWindow();
    }
}
