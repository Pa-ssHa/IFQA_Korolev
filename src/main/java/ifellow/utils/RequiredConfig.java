package ifellow.utils;

import org.aeonbits.owner.ConfigFactory;

public class RequiredConfig {

    private final ConfigProperties configProperties;

    public RequiredConfig() {
        this.configProperties = ConfigFactory.create(ConfigProperties.class);
    }

    public String requireLogin() {
        return requireString(configProperties.login(), "login");
    }

    public String requirePassword() {
        return requireString(configProperties.password(), "password");
    }

    public String requireBaseApiUrl() {
        return requireString(configProperties.baseApiUrl(), "base.api.url");
    }

    public String requireNameCharacter() {
        return requireString(configProperties.nameCharacter(), "name.character");
    }

    public String requireBaseApiUrlMorty() {
        return requireString(configProperties.baseApiUrlMorty(), "base.api.morty.url");
    }

    public String requireNotFound() {
        return requireString(configProperties.notFound(), "auth.error.not.found");
    }

    public String requirePasswordWrong() {
        return requireString(configProperties.notRightPass(), "auth.error.password.wrong");
    }

    public String requireSuccessLogout() {
        return requireString(configProperties.successLogout(), "auth.success.logout");
    }

    public String requireCredentialFile() {
        return requireString(configProperties.credentialFile(), "credentials.file");
    }

    public String requireCredentialFileToken() {
        return requireString(configProperties.credentialFileToken(), "credentials.file.token");
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