package rev.threading;

import static rev.helper.HttpHelper.callGetApi;

import lombok.extern.slf4j.Slf4j;
import rev.threading.model.Products;

@Slf4j
public class ThreadsDriver {

  public static void main(String[] args) {

    log.info(
        "MAIN STARTED ON THREAD: {} & HAVING PRIORITY: {}",
        Thread.currentThread().getName(),
        Thread.currentThread().getPriority());

    try {

      Thread.sleep(5_000L);
      var th1 =
          performTaskOnVirtualThread(callGetApi("https://dummyjson.com/products", Products.class));
      var th2 =
          performTaskOnPlatformThread(callGetApi("https://dummyjson.com/products", Products.class));
      // Current Thread should wait for th1 to finish
      th1.join();
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
}
