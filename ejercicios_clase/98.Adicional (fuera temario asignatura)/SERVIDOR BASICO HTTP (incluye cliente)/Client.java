import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    public static void main(String argv[]) {
        // create a client
        HttpClient client = HttpClient.newHttpClient();
        // create a request
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder(
                    new URI("http://localhost:8001/hello"))
                    .build();
            // use the client to send the request
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
