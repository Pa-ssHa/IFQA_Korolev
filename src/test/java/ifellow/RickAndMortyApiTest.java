//package ifellow;
//
//import ifellow.dto.rickMorty.CharacterDto;
//import ifellow.steps.rickMorty.InfoCharacterStep;
//import ifellow.steps.rickMorty.LastCharacterStep;
//import ifellow.steps.rickMorty.LastEpisodeStep;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import static ifellow.utils.LoadProperties.getProperties;
//
//public class RickAndMortyApiTest {
//    private static final String URL = getProperties().getProperty("base.api.morty.url");
//    private static final String nameCharacter = getProperties().getProperty("name.character");
//
//    @Test
//    public void testInfoEpisodeMorty() {
//        LastEpisodeStep lastEpisodeStep = new LastEpisodeStep();
//        LastCharacterStep lastCharacterStep = new LastCharacterStep();
//        InfoCharacterStep infoCharacterStep = new InfoCharacterStep();
//
//        CharacterDto lastCharacterDto = lastCharacterStep.getLastCharacter(lastEpisodeStep.getLastEpisodeId(nameCharacter, URL), URL);
//
//        String mortyLocation = infoCharacterStep.getLocationCharacter(nameCharacter, URL);
//        String mortySpecies = infoCharacterStep.getSpeciesCharacter(nameCharacter, URL);
//
//        String locationCharacter = lastCharacterDto.getLocation().getName();
//        String speciesCharacter = lastCharacterDto.getSpecies();
//
//        Assertions.assertNotEquals(mortyLocation, locationCharacter, "Местоположение не совпало");
//        Assertions.assertEquals(mortySpecies, speciesCharacter, "Расы совпали");
//    }
//}
