package ifellow.steps.rickMorty;

import ifellow.dto.rickMorty.CharacterDto;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import static ifellow.utils.LoadProperties.getProperties;

public class RickMortySteps {
    private final String url = getProperties().getProperty("base.api.morty.url");
    private final String mortyName = getProperties().getProperty("name.character");

    private final LastEpisodeStep lastEpisodeStep = new LastEpisodeStep();
    private final LastCharacterStep lastCharacterStep = new LastCharacterStep();
    private final InfoCharacterStep infoCharacterStep = new InfoCharacterStep();

    private String lastEpisodeId;
    private CharacterDto lastCharacter;
    private String mortyLocation;
    private String mortySpecies;
    private String lastCharacterLocation;
    private String lastCharacterSpecies;

    @Когда("нахожу последний эпизод с участием Морти")
    public void getLastEpisodeWithMorty() {
        lastEpisodeId = lastEpisodeStep.getLastEpisodeId(mortyName, url);
    }

    @И("получаю последнего персонажа из этого эпизода")
    public void getLastCharacterFromEpisode() {
        lastCharacter = lastCharacterStep.getLastCharacter(lastEpisodeId, url);
    }

    @И("получаю расу и местоположение последнего персонажа")
    public void getLastCharacterInfo() {
        lastCharacterSpecies = lastCharacter.getSpecies();
        lastCharacterLocation = lastCharacter.getLocation().getName();
    }

    @И("получаем расу и местоположение Морти")
    public void getMortyInfo() {
        mortyLocation = infoCharacterStep.getLocationCharacter(mortyName, url);
        mortySpecies = infoCharacterStep.getSpeciesCharacter(mortyName, url);
    }

    @Тогда("раса последнего персонажа совпадает с расой Морти")
    public void checkSpecies() {
        Assertions.assertEquals(mortySpecies, lastCharacterSpecies, "Расы совпали");
    }

    @Тогда("местоположение последнего персонажа отличается от местоположения Морти")
    public void checkLocation() {
        Assertions.assertNotEquals(mortyLocation, lastCharacterLocation, "Местоположение не совпало");
    }
}
