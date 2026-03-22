package leet_code.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// Pattern Used: Monotonic Stack

public class NextGreaterElement {
  static void main() {
    int[] input = {4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6};
    // {1, 34, 0, 3, 10, 12, 5};

    int[] result1 = getNextGreaterElement(input);
    Arrays.stream(result1).forEach(element -> System.out.print(element + " "));

    System.out.print("\n");

    int[] result2 = optimizedGetNextGreaterElement(input);
    Arrays.stream(result2).forEach(element -> System.out.print(element + " "));
  }

  // Brute force approach
  private static int[] getNextGreaterElement(int[] input) {
    int[] result = new int[input.length];
    Arrays.fill(result, -1);

    for (int i = 0; i < input.length; i++) {
      for (int j = i + 1; j < input.length; j++) {
        if (input[j] > input[i]) {
          result[i] = input[j];
          break;
        }
      }
    }
    return result;
  }

  // Optimized approach
  private static int[] optimizedGetNextGreaterElement(int[] input) {
    int[] result = new int[input.length];
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = input.length - 1; i >= 0; i--) {

      while (!stack.isEmpty() && stack.peek() <= input[i]) {
        stack.pop();
      }

      result[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(input[i]);
    }

    return result;
  }
}
