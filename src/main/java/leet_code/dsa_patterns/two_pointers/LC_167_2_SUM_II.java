package leet_code.dsa_patterns.two_pointers;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

// LC_167: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

@Slf4j
class LC_167_2_SUM_II {

  static void main() {
    int[] result = isTwoSumII(new int[] {2, 7, 11, 15}, 9);
    log.info(
        "Get index from input numbers array where numbers with sum equal to target:{}",
        Arrays.toString(result));
  }

  public static int[] isTwoSumII(int[] numbers, int target) {
    int[] result = new int[2];
    int i = 0;
    int j = numbers.length - 1;
    int sum = 0;

    while (i < j) {

      sum = numbers[i] + numbers[j];

      if (sum == target) {
        result[0] = i + 1;
        result[1] = j + 1;
        return result;
      }

      if (sum > target) j--;
      else i++;
    }
    return result;
  }
}
