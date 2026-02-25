package leet.array;

import java.util.Arrays;
import java.util.Random;

public class ArrayDriver {

  static void main() {
    // Print array values
    Arrays.stream(getRandomIntArray()).forEach(System.out::println);
    getOddNumbers(getRandomIntArray());
  }

  // Get integer array with random values
  static Integer[] getRandomIntArray() {
    return new Random()
        .ints(10, 1, 101) // size, min, max
        .boxed() // converts int to Integer
        .toArray(Integer[]::new);
  }

  // Get odd integers from array
  static void getOddNumbers(Integer[] input) {
    var filteredInput = Arrays.stream(input).filter(element -> element % 2 != 0).toList();
    System.out.println(filteredInput);
  }
}
