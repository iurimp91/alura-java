import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
  public static void main(String[] args) throws Exception {
    String url = "https://alura-filmes.herokuapp.com/conteudos";
    URI address = URI.create(url);
    HttpClient client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(address).GET().build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    String body = response.body();

    var parser = new JsonParser();
    List<Map<String, String>> moviesList = parser.parse(body);
    
    
  }
}
