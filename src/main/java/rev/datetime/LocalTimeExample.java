package rev.datetime;

import java.time.LocalTime;

public class LocalTimeExample {
  public static void main(String[] args) {
    LocalTime now = LocalTime.now(); // Current time
    LocalTime openingTime = LocalTime.of(9, 0); // Specific time
    LocalTime meeting = now.plusMinutes(30); // Add 30 minutes

    System.out.println("Now: " + now);
    System.out.println("Opening Time: " + openingTime);
    System.out.println("Meeting in 30 mins: " + meeting);
  }
}
