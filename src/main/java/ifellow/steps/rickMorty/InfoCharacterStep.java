package ifellow.steps.rickMorty;

import ifellow.api.rickMorty.CharacterClient;
import ifellow.dto.rickMorty.CharacterDto;

public class InfoCharacterStep {
    private final CharacterClient characterClient = new CharacterClient();

    public String getLocationCharacter(String nameCharacter, String url) {
        CharacterDto characterDto = characterClient.getCharacterByName(nameCharacter, url);
        return characterDto.getLocation().getName();
    }

    public String getSpeciesCharacter(String nameCharacter, String url) {
        CharacterDto characterDto = characterClient.getCharacterByName(nameCharacter, url);
        return characterDto.getSpecies();
    }
}
