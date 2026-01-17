package ifellow.automation.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ifellow.automation.utils.LoadProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

public class WebHooks {
    private final Properties properties = LoadProperties.getProperties();

    @Before
    public void initBrowser() {
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

    @After
    public void closeBrowser() {
        WebDriverRunner.closeWindow();
    }
}
