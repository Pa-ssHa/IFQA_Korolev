package ifellow.dto.rickMorty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodeDto {
    private String name;
    private List<String> characters;
}
