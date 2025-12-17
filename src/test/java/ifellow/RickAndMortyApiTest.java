package ifellow;

import ifellow.dto.CharacterDto;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ifellow.utils.ExtractId.extractId;
import static ifellow.utils.LoadProperties.getProperties;
import static io.restassured.RestAssured.given;

public class RickAndMortyApiTest {

    private static final String URL = getProperties().getProperty("base.api.morty.url");
    private static final String nameCharacter = getProperties().getProperty("name.character");

    @Test
    public void testInfoEpisodeMorty() {

        Response mortyResponse = given()
                .when()
                .get(URL + "/character?name=" + nameCharacter);

        CharacterDto morty = mortyResponse.jsonPath().getObject("results[0]", CharacterDto.class);

        String mortyLocation = morty.getLocation().getName();
        String mortySpecies = morty.getSpecies();
        List<String> listResultEpisodeUrl = morty.getEpisode();

        String lastEpisodeUrl = listResultEpisodeUrl.get(listResultEpisodeUrl.size() - 1);
        String lastEpisodeId = extractId(lastEpisodeUrl);


        Response lastEpisodeResponse = given()
                .when()
                .get(URL + "/episode/" + lastEpisodeId);

        List<String> listCharacter = lastEpisodeResponse.jsonPath().getList("characters");
        String lastCharacter = listCharacter.get(listCharacter.size() - 1);
        String lastCharacterId = extractId(lastCharacter);


        Response lastCharacterResponse = given()
                .when()
                .get(URL + "/character/" + lastCharacterId);

        CharacterDto lastCharacterDto = lastCharacterResponse.jsonPath().getObject("", CharacterDto.class);
        String locationCharacter = lastCharacterDto.getLocation().getName();
        String speciesCharacter = lastCharacterDto.getSpecies();

        Assertions.assertNotEquals(mortyLocation, locationCharacter, "Местоположение не совпало");
        Assertions.assertEquals(mortySpecies, speciesCharacter, "Расы совпали");
    }
}
