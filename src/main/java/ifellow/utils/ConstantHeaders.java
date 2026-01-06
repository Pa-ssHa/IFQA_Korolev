package ifellow.utils;

import java.util.Map;

public class ConstantHeaders {
    public static Map<String, String> getJsonHeaders() {
        return Map.of("Content-Type", "application/json");
    }

    public static Map<String, String> getTokenHeaders(String token) {
        return Map.of("Authorization", token);
    }
}
