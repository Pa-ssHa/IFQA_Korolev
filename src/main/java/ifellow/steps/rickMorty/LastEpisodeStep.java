package ifellow.steps.rickMorty;

import ifellow.api.rickMorty.CharacterClient;
import ifellow.dto.rickMorty.CharacterDto;

import java.util.List;

import static ifellow.utils.rickMorty.ExtractId.extractId;

public class LastEpisodeStep {
    private final CharacterClient characterClient = new CharacterClient();

    public String getLastEpisodeId(String nameCharacter, String url) {
        CharacterDto characterDto = characterClient.getCharacterByName(nameCharacter, url);
        List<String> listResultEpisodeUrl = characterDto.getEpisode();
        String lastEpisodeUrl = listResultEpisodeUrl.get(listResultEpisodeUrl.size() - 1);
        return extractId(lastEpisodeUrl);
    }

}
