package ifellow.steps.rickMorty;

import ifellow.dto.rickMorty.CharacterDto;
import ifellow.utils.RequiredConfig;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static ifellow.utils.LoadProperties.getProperties;

public class RickMortySteps {
    private final RequiredConfig requiredConfig = new RequiredConfig();
    private final String url = requiredConfig.requireBaseApiUrlMorty();
    private final String mortyName = requiredConfig.requireNameCharacter();
    private final LastEpisodeStep lastEpisodeStep = new LastEpisodeStep();
    private final LastCharacterStep lastCharacterStep = new LastCharacterStep();
    private final InfoCharacterStep infoCharacterStep = new InfoCharacterStep();
    private String lastEpisodeId;
    private CharacterDto lastCharacter;
    private String mortyLocation;
    private String mortySpecies;
    private String lastCharacterLocation;
    private String lastCharacterSpecies;

    @Step("Найти последний эпизод с участием Морти")
    @Когда("нахожу последний эпизод с участием Морти")
    public void getLastEpisodeWithMorty() {
        lastEpisodeId = lastEpisodeStep.getLastEpisodeId(mortyName, url);
    }

    @Step("Получить последнего персонажа из этого эпизода")
    @И("получаю последнего персонажа из этого эпизода")
    public void getLastCharacterFromEpisode() {
        lastCharacter = lastCharacterStep.getLastCharacter(lastEpisodeId, url);
    }

    @Step("Получить расу и местоположение последнего персонажа")
    @И("получаю расу и местоположение последнего персонажа")
    public void getLastCharacterInfo() {
        lastCharacterSpecies = lastCharacter.getSpecies();
        lastCharacterLocation = lastCharacter.getLocation().getName();
    }

    @Step("Получить расу и местоположение Морти")
    @И("получаем расу и местоположение Морти")
    public void getMortyInfo() {
        mortyLocation = infoCharacterStep.getLocationCharacter(mortyName, url);
        mortySpecies = infoCharacterStep.getSpeciesCharacter(mortyName, url);
    }

    @Step("Сравнить расу последнего персонажа и Морти")
    @Тогда("раса последнего персонажа совпадает с расой Морти")
    public void checkSpecies() {
        Assertions.assertEquals(mortySpecies, lastCharacterSpecies, "Расы совпали");
    }

    @Step("Сравнить местоположение последнего персонажа и Морти")
    @Тогда("местоположение последнего персонажа отличается от местоположения Морти")
    public void checkLocation() {
        Assertions.assertNotEquals(mortyLocation, lastCharacterLocation, "Местоположение не совпало");
    }
}
