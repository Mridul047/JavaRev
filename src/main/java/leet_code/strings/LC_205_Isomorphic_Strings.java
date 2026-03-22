package leet_code.strings;

// LC_205: https://leetcode.com/problems/isomorphic-strings/description/

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC_205_Isomorphic_Strings {
  static void main() {

    String s = "egg";
    String t = "add";
    log.info("Check if s & t are isomorphic: {}", isIsomorphic(s, t));
  }

  public static boolean isIsomorphic(String s, String t) {
    int[] hashTableS = new int[128];
    int[] hashTableT = new int[128];

    for (int i = 0; i < s.length(); i++) {
      // Check if the occurrence for S & T char is having same position or not
      if (hashTableS[s.charAt(i)] != hashTableT[t.charAt(i)]) return false;

      // Update position for each occurrence for S & T char for given i
      hashTableS[s.charAt(i)] = i + 1;
      hashTableT[t.charAt(i)] = i + 1;
    }

    return true;
  }
}
