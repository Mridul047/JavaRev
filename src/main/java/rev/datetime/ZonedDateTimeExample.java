package rev.datetime;

import static java.time.ZoneId.SHORT_IDS;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeExample {
  public static void main(String[] args) {
    ZonedDateTime nowUTC = ZonedDateTime.now(ZoneId.of("UTC"));
    ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of(SHORT_IDS.get("IST")));

    System.out.println("UTC: " + nowUTC);
    System.out.println("India Time: " + indiaTime);
  }
}
