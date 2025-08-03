package rev.datetime;

import java.time.OffsetTime;
import java.time.ZoneOffset;

public class OffsetTimeExample {
  public static void main(String[] args) {
    OffsetTime now = OffsetTime.now();
    OffsetTime custom = OffsetTime.of(10, 15, 30, 0, ZoneOffset.of("+05:30"));

    System.out.println("Current Offset Time: " + now);
    System.out.println("Custom Offset Time: " + custom);
  }
}
