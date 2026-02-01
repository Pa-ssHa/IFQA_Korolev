package ifellow.utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:application.properties"})
public interface ConfigProperties extends Config {

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("base.api.url")
    String baseApiUrl();

    @Key("name.character")
    String nameCharacter();

    @Key("base.api.morty.url")
    String baseApiUrlMorty();

    @Key("auth.error.not.found")
    String notFound();

    @Key("auth.error.password.wrong")
    String notRightPass();

    @Key("auth.success.logout")
    String successLogout();

    @Key("credentials.file")
    String credentialFile();

    @Key("credentials.file.token")
    String credentialFileToken();
}