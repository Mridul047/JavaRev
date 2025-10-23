package rev.helper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpHelper {

  public static <T> Runnable callGetApi(String url, Class<T> DtoClass) {
    return () -> {
      try (HttpClient client = HttpClient.newHttpClient()) {

        // Create a reusable ObjectMapper instance
        ObjectMapper mapper = getObjectMapper();

        HttpRequest request =
            HttpRequest.newBuilder()
                .uri(URI.create(url))
                // .POST(HttpRequest.BodyPublishers.noBody())
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        var res = mapper.readValue(response.body(), DtoClass);

        log.info("Http RESPONSE: {}", res);
        Thread.sleep(5_000L);
      } catch (InterruptedException | IOException e) {
        log.error(e.getMessage(), e);
      }
    };
  }

  public static ObjectMapper getObjectMapper() {
    // Create a reusable ObjectMapper instance
    ObjectMapper mapper = new ObjectMapper();

    // Basic mapper configuration
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    return mapper;
  }
}
