package ifellow.utils.rickMorty;

public class ExtractId {
    public static String extractId(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }
}
