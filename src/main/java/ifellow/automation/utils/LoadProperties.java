package ifellow.automation.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {

    public static Properties getProperties() {
        Properties prop = new Properties();
        try (InputStream input = LoadProperties.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (input != null) {
                prop.load(input);
            }
            String login = prop.getProperty("login");
            String password = prop.getProperty("password");
            String url = prop.getProperty("base.url");

            if (login == null || login.trim().isEmpty()) {
                throw new RuntimeException("login отсутствует или пустое в application.properties");
            }
            if (password == null || password.trim().isEmpty()) {
                throw new RuntimeException("password отсутствует или пустое в application.properties");
            }
            if (url == null || url.trim().isEmpty()) {
                throw new RuntimeException("url отсутствует или пустое в application.properties");
            }
        } catch (IOException e) {
            throw new RuntimeException("не удалось загрузить application.properties");
        }
        return prop;
    }
}
