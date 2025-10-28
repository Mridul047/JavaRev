package leet;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeetCodeBank {

  static void main() {
    var moneyInBank = totalMoney(4);
    log.info("Total money in bank: {}", moneyInBank);
  }

  public static int totalMoney(int n) {

    int totalMoney = 0;
    int weeklyStartingtMoney = 0;
    int weeklyTotalMoney = 0;

    for (int i = 0; i < n; i++) {
      if (i != 0 && i % 7 == 0) {
        weeklyStartingtMoney += 1;
        weeklyTotalMoney = weeklyStartingtMoney;
      }
      weeklyTotalMoney += 1;
      totalMoney += weeklyTotalMoney;
    }

    return totalMoney;
  }
}
