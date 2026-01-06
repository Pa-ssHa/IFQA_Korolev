package ifellow.steps.rickMorty;

import ifellow.api.rickMorty.CharacterClient;
import ifellow.api.rickMorty.EpisodeClient;
import ifellow.dto.rickMorty.CharacterDto;

import java.util.List;

import static ifellow.utils.rickMorty.ExtractId.extractId;

public class LastCharacterStep {
    private final CharacterClient characterClient = new CharacterClient();
    private final EpisodeClient episodeClient = new EpisodeClient();

    public CharacterDto getLastCharacter(String idEpisode, String url) {
        List<String> characters = episodeClient.getEpisodeById(idEpisode).getCharacters();
        String lastCharacterUrl = characters.get(characters.size() - 1);
        String lastCharacterId = extractId(lastCharacterUrl);
        return characterClient.getCharacterById(lastCharacterId, url);
    }

}
