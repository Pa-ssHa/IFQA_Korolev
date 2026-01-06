package ifellow.api.rickMorty;

import ifellow.dto.rickMorty.EnumPathRickMorty;
import ifellow.dto.rickMorty.EpisodeDto;
import io.restassured.response.Response;

import static ifellow.service.rickMorty.ResponseBaseRickMortyService.getResponseWithId;
import static ifellow.utils.LoadProperties.getProperties;

public class EpisodeClient {
    private static final String URL = getProperties().getProperty("base.api.morty.url");

    public EpisodeDto getEpisodeById(String id) {
        Response episode = getResponseWithId(URL,
                EnumPathRickMorty.episode, id);
        return episode.jsonPath().getObject("", EpisodeDto.class);
    }
}
