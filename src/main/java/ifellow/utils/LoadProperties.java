package ifellow.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {

    public static Properties getProperties() {
        Properties prop = new Properties();
        try (InputStream general = LoadProperties.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (general != null) {
                prop.load(general);
            }
        } catch (IOException e) {
            throw new RuntimeException("не удалось загрузить application.properties");
        }

        try (InputStream local = LoadProperties.class.getClassLoader()
                .getResourceAsStream("application-local.properties")) {
            if (local != null) {
                prop.load(local);
            }
            String login = prop.getProperty("login");
            String password = prop.getProperty("password");

            if (login == null || login.isEmpty() || password == null || password.isEmpty()) {
                throw new RuntimeException("данные авторизации не найдены");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }
}
