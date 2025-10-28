package leet.recusion;

import static rev.helper.TimerHelper.measureNanoTime;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FibDriver {

  public static void main(String[] args) {
    int num = 45;
    int[] dpMemoArray = new int[num + 1];
    Arrays.fill(dpMemoArray, -1);

    int[] dpTabulationArray = new int[num + 1];
    Arrays.fill(dpTabulationArray, -1);

    var fibResult = measureNanoTime(() -> fib(num));
    log.info("fibResult -> {}", fibResult);

    var fibWithMemoResult = measureNanoTime(() -> fibWithMemo(num, dpMemoArray));
    log.info("fibWithMemoResult -> {}", fibWithMemoResult);

    var fibWithTabulationResult = measureNanoTime(() -> fibWithTabulation(num, dpTabulationArray));
    log.info("fibWithTabulationResult -> {}", fibWithTabulationResult);

    var fib2Result = measureNanoTime(() -> fib2(num));
    log.info("fib2Result -> {}", fib2Result);
  }

  /*
    The total time taken Exponential i.e 2^n
  */
  public static int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
  }

  /*
    The total time taken is O(n)
    This function uses Memoization which follows Top-Down Approach
  */
  public static int fibWithMemo(int n, int[] dpArray) {
    if (n <= 1) return n;
    if (dpArray[n] != -1) return dpArray[n];
    return dpArray[n] = fibWithMemo(n - 1, dpArray) + fibWithMemo(n - 2, dpArray);
  }

  /*
    The total time taken is O(n)
    This function uses Tabulation which follows Bottom-Up Approach
  */
  public static int fibWithTabulation(int n, int[] dpArray) {
    if (n <= 1) return n;
    dpArray[0] = 0;
    dpArray[1] = 1;
    for (int i = 2; i <= n; i++) {
      dpArray[i] = dpArray[i - 1] + dpArray[i - 2];
    }
    return dpArray[n];
  }

  /*
   This function performs calculation with Space Optimization
  */
  public static int fib2(int n) {
    if (n <= 1) return n;
    int prev = 1;
    int prev2 = 0;
    int current = 0;
    for (int i = 2; i <= n; i++) {
      current = prev + prev2;
      prev2 = prev;
      prev = current;
    }
    return current;
  }
}
