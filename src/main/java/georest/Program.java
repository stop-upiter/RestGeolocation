package georest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import java.io.IOException;

public class Program {
    public final static String url = "https://freegeoip.app/json/";
    public static void main(String[] args) {
        String json;
        try{
            json = httpRequest();
        }
        catch (IOException ex){
            System.out.println("Ошибка при запросе");
            return;
        }

        Location location;
        try{
            location = Parser.parseJSONtoLocation(json);
        }
        catch (JSONException ex){
            System.out.println("JSON пришёл сломанный");
            return;
        }

        System.out.print(location.toString());
    }

    /**
     * Сделать запросик за json с текущим местоположением.
     * @return json с текущим местоположением.
     * @throws IOException при ошибке в ходе запроса.
     */
    private static String httpRequest() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        try (
             Response response = okHttpClient
                .newCall(new Request.Builder()
                        .url(url).build()).execute()) {
            return response.body().string();
        }
        finally {
            okHttpClient.connectionPool().evictAll();
        }
    }
}
