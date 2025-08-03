package rev.threading;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import rev.threading.model.Products;

@Slf4j
public class PracticeThreads {

  public static void main(String[] args) {

    log.info(
        "MAIN STARTED ON THREAD: {} & HAVING PRIORITY: {}",
        Thread.currentThread().getName(),
        Thread.currentThread().getPriority());

    try {

      Thread.sleep(5_000L);
      var th1 = performTaskOnVirtualThread(callGetApi());
      var th2 = performTaskOnPlatformThread(callGetApi());
      // Current Thread should wait for th1 to finish
      // th1.join();
      th2.join();

    } catch (InterruptedException e) {
      log.error(e.getMessage(), e);
    }

    log.info(
        "MAIN ENDED ON THREAD: {} & HAVING PRIORITY: {}",
        Thread.currentThread().getName(),
        Thread.currentThread().getPriority());
  }

  private static Thread performTaskOnPlatformThread(Runnable t1) {
    log.info(
        "performTask() RUNNING ON V-THREAD: {} & HAVING PRIORITY: {}",
        Thread.currentThread().isVirtual(),
        Thread.currentThread().getPriority());

    return new Thread(t1);
  }

  private static Thread performTaskOnVirtualThread(Runnable t1) {
    log.info(
        "performTask() RUNNING ON V-THREAD: {} & HAVING PRIORITY: {}",
        Thread.currentThread().isVirtual(),
        Thread.currentThread().getPriority());

    return Thread.startVirtualThread(t1);
  }

  private static Runnable callGetApi() {
    return () -> {
      try (HttpClient client = HttpClient.newHttpClient()) {

        // Create a reusable ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        // Basic mapper configuration
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        log.info(
            "TASK T1 RUNNING ON V-THREAD: {} & HAVING PRIORITY: {}",
            Thread.currentThread().isVirtual(),
            Thread.currentThread().getPriority());

        HttpRequest request =
            HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/products"))
                // .POST(HttpRequest.BodyPublishers.noBody())
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        var res = mapper.readValue(response.body(), Products.class);
        log.info("Http RESPONSE: {}", res);

        Thread.sleep(5_000L);

      } catch (InterruptedException | IOException e) {
        log.error(e.getMessage(), e);
      }
    };
  }
}
