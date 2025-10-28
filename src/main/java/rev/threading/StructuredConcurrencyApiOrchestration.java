package rev.threading;

import java.time.Instant;
import java.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("preview")
public class StructuredConcurrencyApiOrchestration {

  static void main() throws InterruptedException, ExecutionException {
    long start = System.currentTimeMillis();

    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {

      StructuredTaskScope.Subtask<String> userSubTask =
          scope.fork(StructuredConcurrencyApiOrchestration::fetchUserProfile);

      StructuredTaskScope.Subtask<String> orderSubTask =
          scope.fork(StructuredConcurrencyApiOrchestration::fetchRecentOrders);

      // 👇 Simulate failure here
      StructuredTaskScope.Subtask<String> productsSubTask =
          scope.fork(StructuredConcurrencyApiOrchestration::failFetchRecommendations);

      log.info("Main thread: waiting for subtasks (max 3s)...");
      // Wait up to 3s for all subtasks
      scope.joinUntil(Instant.now().plusSeconds(3));

      // scope.join(); // Alternative if you want to wait indefinitely

      // ⚡ Print subtask states before throwing any exceptions
      log.info("---- Subtask States After joinUntil() ----");
      log.info("userSubTask: {}", userSubTask.state());
      log.info("orderSubTask: {}", orderSubTask.state());
      log.info("productsSubTask: {}", productsSubTask.state());
      log.info("------------------------------------------");

      // Will throw ExecutionException if any subtask failed
      scope.throwIfFailed();

      String user = userSubTask.get();
      String orders = orderSubTask.get();
      String products = productsSubTask.get();

      String combinedResponse = combine(user, orders, products);
      log.info("✅ CombinedResponse -> {}", combinedResponse);

    } catch (TimeoutException e) {
      log.error("⏰ Timeout occurred while waiting for subtasks");
    } catch (ExecutionException e) {
      log.error("❌ One of the subtasks failed: {}", e.getCause().toString());
    } catch (Exception e) {
      log.error("Unexpected exception!", e);
    }

    log.info("Total Time taken: {} ms", System.currentTimeMillis() - start);
  }

  static String fetchUserProfile() {
    log.info("Fetching user profile...");
    try {
      Thread.sleep(1100);
    } catch (InterruptedException e) {
      log.error("Fetching user profile interrupted!");
    }
    return "User: James";
  }

  static String fetchRecentOrders() {
    log.info("Fetching recent orders...");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      log.error("Fetching recent orders was interrupted!");
    }
    return "Orders: [ORD-#312, ORD-#300]";
  }

  static String fetchRecommendations() throws InterruptedException {
    log.info("Fetching recommendations...");
    Thread.sleep(1500);
    return "Recommendations: [Monitor, Webcam]";
  }

  static String failFetchRecommendations() throws InterruptedException {
    log.info("Fetching recommendations (expected to fail)...");
    Thread.sleep(1500);
    throw new RuntimeException("❌ Exception occurred while fetching recommendations!");
  }

  static String combine(String user, String orders, String products) {
    return user + " | " + orders + " | " + products;
  }
}
