package rev.helper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimerHelper {

  /** Runs the given task, logs the execution time in milliseconds & returns the result */
  public static <T> T measureTimeMillis(TimedCallableTask<T> task) {
    long start = System.currentTimeMillis();
    T result = task.run();
    long end = System.currentTimeMillis();
    log.info("Execution time: {} ms", end - start);
    return result;
  }

  /** Runs the given task & logs the execution time in milliseconds */
  public static void measureTimeMillis(TimedRunnableTask task) {
    long start = System.currentTimeMillis();
    task.run();
    long end = System.currentTimeMillis();
    log.info("Execution time: {} ms", end - start);
  }

  /** Runs the given task, logs the execution time in nanoseconds & returns the result */
  public static <T> T measureNanoTime(TimedCallableTask<T> task) {
    long start = System.nanoTime();
    T result = task.run();
    long end = System.nanoTime();
    log.info("Execution time: {} ns", end - start);
    return result;
  }

  /** Runs the given task & logs the execution time in nanoseconds */
  public static void measureNanoTime(TimedRunnableTask task) {
    long start = System.nanoTime();
    task.run();
    long end = System.nanoTime();
    log.info("Execution time: {} ms", end - start);
  }

  /** Represents a function that runs the task. */
  @FunctionalInterface
  public interface TimedRunnableTask {
    void run();
  }

  /** Represents a function that runs the task & returns the result. */
  @FunctionalInterface
  public interface TimedCallableTask<T> {
    T run();
  }
}
