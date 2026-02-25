package leet.array;

// https://leetcode.com/problems/max-consecutive-ones-iii/description/

public class MaxConsecutive1 {

  static void main() {
    int[] input = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
    int k = 2;
    var res = getMaxConsecutive1(input, k);
    System.out.println("res: " + res);
  }

  static int getMaxConsecutive1(int[] input, int k) {
    int left = 0, maxLen = 0;
    int seenZeros = 0;

    for (int right = 0; right < input.length; right++) {

      if (input[right] == 0) seenZeros += 1;

      while (seenZeros > k) {
        if (input[left] == 0) seenZeros--;
        left++;
      }

      if (seenZeros <= k) {
        int len = right - left + 1;
        maxLen = Math.max(maxLen, len);
      }
    }
    return maxLen;
  }
}
