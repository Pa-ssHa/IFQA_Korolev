package ifellow.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
    private static Properties properties;

    public static Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            try (InputStream input = LoadProperties.class
                    .getClassLoader()
                    .getResourceAsStream("application.properties")) {

                if (input == null) {
                    throw new RuntimeException("application.properties не найден");
                }
                properties.load(input);
                requireNonEmpty("login");
                requireNonEmpty("password");
                requireNonEmpty("base.api.url");
                requireNonEmpty("base.api.morty.url");
                requireNonEmpty("name.character");
                requireNonEmpty("auth.error.not.found");
                requireNonEmpty("auth.error.password.wrong");
                requireNonEmpty("auth.success.logout");
            } catch (IOException e) {
                throw new RuntimeException("не удалось загрузить application.properties", e);
            }
        }
        return properties;
    }

    private static void requireNonEmpty(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            throw new RuntimeException(key + " отсутствует или пустое в application.properties");
        }
    }
}
