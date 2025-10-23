package rev.sorting;

import java.util.Random;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SortDriver {
  public static void main(String[] args) {
    // IO.println("PIPELINING ANALYZING SORTING ... ");
    try {
      int[] arr1 = generateRandomArray(90_000, 1, 10_00_000);
      int[] arr2 = generateRandomArray(90_000, 1, 10_00_000);
      int[] arr3 = generateRandomArray(90_000, 1, 10_00_000);

      selectionSort(arr1);
      bubbleSort(arr2);
      insertionSort(arr3);
    } catch (IllegalArgumentException exception) {
      log.error(exception.getMessage());
    }
  }

  public static int[] generateRandomArray(int size, int a, int b) {
    if (size <= 0 || a > b) {
      throw new IllegalArgumentException("Invalid input parameters.");
    }

    int[] result = new int[size];
    Random rand = new Random();

    for (int i = 0; i < size; i++) {
      result[i] = rand.nextInt(b - a + 1) + a;
    }

    return result;
  }

  public static int[] selectionSort(int[] nums) {

    long startTime = System.currentTimeMillis();

    for (int i = 0; i <= nums.length - 2; i++) {
      int minIdx = i;

      for (int j = i; j <= nums.length - 1; j++) {
        if (nums[j] < nums[minIdx]) minIdx = j;
      }

      int temp = nums[minIdx];
      nums[minIdx] = nums[i];
      nums[i] = temp;
    }

    long totalTime = (System.currentTimeMillis() - startTime);

    log.info("Selection Sort took {} seconds.", totalTime / 1000);
    return nums;
  }

  public static int[] bubbleSort(int[] nums) {

    long startTime = System.currentTimeMillis();

    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = 0; j < nums.length - i - 1; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j + 1];
          nums[j + 1] = nums[j];
          nums[j] = temp;
        }
      }
    }
    long totalTime = (System.currentTimeMillis() - startTime);

    log.info("Bubble Sort took {} seconds.", totalTime / 1000);
    return nums;
  }

  public static int[] insertionSort(int[] nums) {
    long startTime = System.currentTimeMillis();

    for (int i = 1; i < nums.length; i++) {
      int key = nums[i];
      int j = i - 1;
      while (j >= 0 && nums[j] > key) {
        nums[j + 1] = nums[j];
        j--;
      }
      nums[j + 1] = key;
    }

    long totalTime = (System.currentTimeMillis() - startTime);

    log.info("Insertion Sort took {} seconds.", totalTime / 1000);
    return nums;
  }
}
