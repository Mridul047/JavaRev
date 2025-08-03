package rev.datetime;

import java.time.LocalDateTime;

public class LocalDateTimeExample {
  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime event = LocalDateTime.of(2025, 12, 31, 20, 0);

    System.out.println("Current: " + now);
    System.out.println("Event: " + event);
  }
}
