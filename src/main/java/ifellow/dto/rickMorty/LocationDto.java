package ifellow.dto.rickMorty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDto {
    private String name;
    private String url;
}
