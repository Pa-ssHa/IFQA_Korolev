package ifellow.service;

import io.restassured.response.Response;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ResponseCustomApiService {
    public static Response postResponse(File file, String URL, Map<String, String> headers) {
        return given()
                .headers(headers)
                .body(file)
                .when()
                .post(URL);
    }

    public static Response postResponse(String file, String URL, Map<String, String> headers) {
        return given()
                .headers(headers)
                .body(file)
                .when()
                .post(URL);
    }

    public static Response getResponse(String URL, Map<String, String> headers) {
        return given()
                .headers(headers)
                .when()
                .get(URL);
    }
}
