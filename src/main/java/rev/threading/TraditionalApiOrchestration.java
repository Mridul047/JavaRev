package rev.threading;

import java.util.List;
import java.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TraditionalApiOrchestration {

  static void main() throws InterruptedException {
    long start = System.currentTimeMillis();

    // 👇 Fixed thread pool for running tasks in parallel
    try (ExecutorService executor = Executors.newFixedThreadPool(3)) {

      // 🔹 Submit subtasks to ExecutorService
      Future<String> userFuture = executor.submit(TraditionalApiOrchestration::fetchUserProfile);
      Future<String> orderFuture = executor.submit(TraditionalApiOrchestration::fetchRecentOrders);
      Future<String> productsFuture =
          executor.submit(TraditionalApiOrchestration::failFetchRecommendations);

      log.info("Main thread: waiting for subtasks to complete...");

      // 🔹 Wait for all subtasks (manual orchestration)
      List<Future<String>> futures = List.of(userFuture, orderFuture, productsFuture);

      // You can use Future.isDone() to check intermediate states (not as rich as structured)
      pollTaskStates(futures);

      // 🔹 Retrieve results (blocking get)
      String user = userFuture.get(); // may throw ExecutionException
      String orders = orderFuture.get();
      String products = productsFuture.get();

      String combinedResponse = combine(user, orders, products);
      log.info("✅ CombinedResponse -> {}", combinedResponse);

    } catch (ExecutionException e) {
      log.error("❌ One of the subtasks failed: {}", e.getCause().toString());
      // In traditional concurrency, YOU must cancel other tasks manually
    }

    log.info("Total Time taken: {} ms", System.currentTimeMillis() - start);
  }

  // --- Subtasks (same as Structured version) ---
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
      log.error("Fetching recent orders interrupted!");
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

  // 🕒 Poll task status manually
  static void pollTaskStates(List<Future<String>> futures) throws InterruptedException {
    boolean allDone = false;
    while (!allDone) {
      allDone = true;
      for (int i = 0; i < futures.size(); i++) {
        Future<String> f = futures.get(i);
        log.info("Task-{} -> isDone={} | isCancelled={}", (i + 1), f.isDone(), f.isCancelled());
        if (!f.isDone()) allDone = false;
      }
      Thread.sleep(500);
    }
  }
}
