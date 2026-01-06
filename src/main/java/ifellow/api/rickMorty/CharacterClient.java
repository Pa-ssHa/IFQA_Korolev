package ifellow.api.rickMorty;

import ifellow.dto.rickMorty.CharacterDto;
import ifellow.dto.rickMorty.EnumParamRickMorty;
import ifellow.dto.rickMorty.EnumPathRickMorty;
import io.restassured.response.Response;

import static ifellow.service.rickMorty.ResponseBaseRickMortyService.getResponseWithId;
import static ifellow.service.rickMorty.ResponseBaseRickMortyService.getResponseWithParam;

public class CharacterClient {
    public CharacterDto getCharacterByName(String nameCharacter, String url) {
        Response mortyResponse = getResponseWithParam(url,
                EnumPathRickMorty.character, EnumParamRickMorty.name, nameCharacter);
        return mortyResponse.jsonPath().getObject("results[0]", CharacterDto.class);
    }

    public CharacterDto getCharacterById(String id, String url) {
        Response character = getResponseWithId(url,
                EnumPathRickMorty.character, id);
        return character.jsonPath().getObject("", CharacterDto.class);
    }
}
