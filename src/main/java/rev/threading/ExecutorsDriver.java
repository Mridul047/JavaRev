package rev.threading;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorsDriver {

  public static void main(String[] args) {
    ScheduledExecutorService ex_run = Executors.newScheduledThreadPool(1);

    Runnable command_1 =
        () ->
            log.info(
                "CurrentTime: {}",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));

    try {

      var sf = ex_run.scheduleAtFixedRate(command_1, 1, 2, TimeUnit.SECONDS);
      sf.get();

    } catch (Exception e) {

      log.error(e.getMessage());

    } finally {

      ex_run.shutdown();
    }
  }

  public void readFile(String filePath) {
    Path path = Paths.get("D:\\NewsGroupService");
    path.toFile().isDirectory();
  }
}
//  public void example_1() {
//    // GET product categories -> https://dummyjson.com/products/categories
//    //
//    try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
//
//      CompletableFuture<Products> getProductsTask =
//          CompletableFuture.supplyAsync(getAllProducts(getObjectMapper()), executor)
//              .exceptionally(
//                  ex -> {
//                    log.error("EXCEPTION HAS OCCURRED: {}", ex.getMessage());
//                    return new Products(new ArrayList<>(), 0, 0, 0);
//                  });
//
//      Thread.sleep(6_100L);
//      log.info("Perform other task-1");
//
//      Products products = getProductsTask.get();
//      log.info("Perform other task-2");
//
//      Set<String> productCategory =
//          products.products().stream().map(Product::category).collect(Collectors.toSet());
//
//      log.info("productCategory: {}", productCategory);
//
//      executor.shutdown();
//    } catch (Exception ex) {
//      log.error(ex.getMessage());
//    }
//  }
//
//  private static ObjectMapper getObjectMapper() {
//    // Create a reusable ObjectMapper instance
//    ObjectMapper mapper = new ObjectMapper();
//    // Basic mapper configuration
//    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//    return mapper;
//  }
//
//  private static Supplier<Products> getAllProducts(ObjectMapper mapper) {
//    return () -> {
//      Products res = null;
//      try (HttpClient client = HttpClient.newHttpClient()) {
//
//        HttpRequest request =
//            HttpRequest.newBuilder()
//                .uri(URI.create("https://dummyjson.com/products"))
//                // .POST(HttpRequest.BodyPublishers.noBody())
//                .GET()
//                .build();
//
//        HttpResponse<String> response = client.send(request,
// HttpResponse.BodyHandlers.ofString());
//        res = mapper.readValue(response.body(), Products.class);
//
//        // log.info("GET API RESPONSE: {}", res);
//        Thread.sleep(6_000L);
//
//      } catch (InterruptedException | IOException e) {
//        log.error("Error occurred while calling api. Message: {}", e.getCause().getMessage());
//        throw new RuntimeException(e);
//      }
//      return res;
//    };
//  }
// }
