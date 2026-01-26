package ifellow.service.rickMorty;

import ifellow.dto.rickMorty.EnumParamRickMorty;
import ifellow.dto.rickMorty.EnumPathRickMorty;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ResponseBaseRickMortyService {

    public static Response getResponseWithId(String baseUrl, EnumPathRickMorty pathRickMorty, String id) {
        return given()
                .when()
                .get(baseUrl + "/" + pathRickMorty + "/" + id);
    }

    public static Response getResponseWithParam(String baseUrl, EnumPathRickMorty pathRickMorty,
                                                EnumParamRickMorty paramRickMorty, String volumeParam) {
        return given()
                .when()
                .get(baseUrl + "/" + pathRickMorty + "?" + paramRickMorty + "=" + volumeParam);
    }
}
