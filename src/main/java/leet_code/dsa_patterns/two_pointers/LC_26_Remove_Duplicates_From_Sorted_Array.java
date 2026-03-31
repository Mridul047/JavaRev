package leet_code.dsa_patterns.two_pointers;

// LC_26: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC_26_Remove_Duplicates_From_Sorted_Array {
  static void main() {
    int[] inputNums = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int uniqueCount = removeDuplicates(inputNums);

    log.info("inputNums: {}", inputNums);
    log.info("uniqueCount={}", uniqueCount);
  }

  public static int removeDuplicates(int[] nums) {
    int uniqueCount = 1;

    int i = 0;
    int j = 1;

    while (j < nums.length) {
      if (nums[j] == nums[j - 1]) {
        j++;
      } else {
        nums[i + 1] = nums[j];
        i++;
        j++;
        uniqueCount++;
      }
    }

    return uniqueCount;
  }
}
