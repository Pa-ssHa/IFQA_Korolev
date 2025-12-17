package ifellow.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterDto {
    private String name;
    private String species;
    private LocationDto location;
    private List<String> episode;
}
