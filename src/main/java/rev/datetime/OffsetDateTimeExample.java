package rev.datetime;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimeExample {
  public static void main(String[] args) {
    OffsetDateTime now = OffsetDateTime.now();
    OffsetDateTime custom = OffsetDateTime.of(2024, 12, 25, 10, 15, 30, 0, ZoneOffset.of("+05:30"));

    System.out.println("Current Offset Date-Time: " + now);
    System.out.println("Custom Offset Date-Time: " + custom);
  }
}
