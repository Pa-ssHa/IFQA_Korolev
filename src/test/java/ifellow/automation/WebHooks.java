package ifellow.automation;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ifellow.automation.utils.LoadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

public class WebHooks {
    private final Properties properties = LoadProperties.getProperties();

    public void initBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);

        Configuration.timeout = 15000;
        Configuration.baseUrl = properties.getProperty("base.url");
    }

    public void closeBrowser() {
        WebDriverRunner.closeWindow();
    }
}
